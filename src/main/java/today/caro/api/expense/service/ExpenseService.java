package today.caro.api.expense.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import today.caro.api.common.exception.BusinessException;
import today.caro.api.common.exception.ErrorCode;
import today.caro.api.expense.dto.*;
import today.caro.api.expense.dto.ExpenseSummaryGetResponse.*;
import today.caro.api.expense.entity.Expense;
import today.caro.api.expense.entity.ExpenseCategory;
import today.caro.api.expense.repository.ExpenseRepository;
import today.caro.api.expense.util.ExpenseCursor;
import today.caro.api.car.entity.MemberCar;
import today.caro.api.car.repository.MemberCarRepository;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final MemberCarRepository memberCarRepository;

    @Transactional
    public ExpenseCreateResponse createExpense(Long memberId, ExpenseCreateRequest request) {
        MemberCar memberCar = memberCarRepository.findById(request.memberCarId())
            .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_CAR_NOT_FOUND));

        if (!memberCar.getMember().getId().equals(memberId)) {
            throw new BusinessException(ErrorCode.MEMBER_CAR_ACCESS_DENIED);
        }

        Expense expense = Expense.builder()
            .member(memberCar.getMember())
            .memberCar(memberCar)
            .expenseDate(request.expenseDate())
            .amount(request.amount())
            .category(request.category())
            .location(request.location())
            .memo(request.memo())
            .build();

        Expense createdExpense = expenseRepository.save(expense);

        return ExpenseCreateResponse.from(createdExpense);
    }

    @Transactional(readOnly = true)
    public ExpensePageGetResponse getExpenses(
        Long memberId,
        YearMonth yearMonth,
        LocalDate date,
        ExpenseCategory category,
        String cursor,
        int size
    ) {
        ExpenseCursor decoded = ExpenseCursor.decode(cursor);
        LocalDate cursorDate = decoded != null ? decoded.date() : null;
        Long cursorId = decoded != null ? decoded.id() : null;

        int totalCount = expenseRepository.countExpenses(memberId, yearMonth, date, category);

        List<Expense> expenses = expenseRepository.findExpenses(
            memberId, yearMonth, date, category, cursorDate, cursorId, size + 1
        );

        List<ExpenseGetResponse> responses = expenses.stream()
            .map(ExpenseGetResponse::from)
            .toList();

        return ExpensePageGetResponse.of(totalCount, responses, size);
    }

    @Transactional
    public ExpenseUpdateResponse updateExpense(Long memberId, Long expenseId, ExpenseUpdateRequest request) {
        Expense expense = expenseRepository.findById(expenseId)
            .orElseThrow(() -> new BusinessException(ErrorCode.EXPENSE_NOT_FOUND));

        if (!expense.getMember().getId().equals(memberId)) {
            throw new BusinessException(ErrorCode.EXPENSE_ACCESS_DENIED);
        }

        expense.update(
            request.expenseDate(),
            request.category(),
            request.amount(),
            request.location(),
            request.memo()
        );

        return ExpenseUpdateResponse.from(expense);
    }

    @Transactional(readOnly = true)
    public ExpenseSummaryGetResponse getSummary(Long memberId, YearMonth yearMonth) {
        Period period = buildPeriod(memberId, yearMonth);
        TotalAmount totalAmount = buildTotalAmount(memberId, yearMonth);
        List<CategorySummary> categories = expenseRepository.findCategorySummaries(memberId, yearMonth);

        return new ExpenseSummaryGetResponse(period, totalAmount, categories);
    }

    private Period buildPeriod(Long memberId, YearMonth yearMonth) {
        if (yearMonth != null) {
            return new Period(yearMonth.atDay(1), yearMonth.atEndOfMonth());
        }

        LocalDate firstDate = expenseRepository.findFirstExpenseDate(memberId);
        LocalDate lastDate = expenseRepository.findLastExpenseDate(memberId);

        if (firstDate == null || lastDate == null) {
            LocalDate today = LocalDate.now();
            return new Period(today, today);
        }

        return new Period(firstDate, lastDate);
    }

    private TotalAmount buildTotalAmount(Long memberId, YearMonth yearMonth) {
        BigDecimal amount = expenseRepository.findTotalAmount(memberId, yearMonth);

        if (yearMonth == null) {
            return new TotalAmount(amount, null);
        }

        YearMonth previousMonth = yearMonth.minusMonths(1);
        BigDecimal previousAmount = expenseRepository.findTotalAmount(memberId, previousMonth);
        Comparison comparison = new Comparison(previousAmount, amount.subtract(previousAmount));

        return new TotalAmount(amount, comparison);
    }

}
