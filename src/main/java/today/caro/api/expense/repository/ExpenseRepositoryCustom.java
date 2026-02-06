package today.caro.api.expense.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import today.caro.api.expense.dto.ExpenseSummaryGetResponse.CategorySummary;
import today.caro.api.expense.entity.Expense;
import today.caro.api.expense.entity.ExpenseCategory;

public interface ExpenseRepositoryCustom {

    List<Expense> findExpenses(
        Long memberId,
        YearMonth yearMonth,
        LocalDate date,
        ExpenseCategory category,
        LocalDate cursorDate,
        Long cursorId,
        int size
    );

    int countExpenses(
        Long memberId,
        YearMonth yearMonth,
        LocalDate date,
        ExpenseCategory category
    );

    List<CategorySummary> findCategorySummaries(Long memberId, YearMonth yearMonth);

    BigDecimal findTotalAmount(Long memberId, YearMonth yearMonth);

    LocalDate findFirstExpenseDate(Long memberId);

    LocalDate findLastExpenseDate(Long memberId);

}
