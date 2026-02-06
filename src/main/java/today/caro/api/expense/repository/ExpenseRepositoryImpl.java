package today.caro.api.expense.repository;

import static today.caro.api.expense.entity.QExpense.expense;
import static today.caro.api.membercar.entity.QMemberCar.memberCar;
import static today.caro.api.vehicle.entity.QCarModel.carModel;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import today.caro.api.expense.dto.ExpenseSummaryGetResponse.CategorySummary;
import today.caro.api.expense.entity.Expense;
import today.caro.api.expense.entity.ExpenseCategory;

@Repository
@RequiredArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Expense> findExpenses(
        Long memberId,
        YearMonth yearMonth,
        LocalDate date,
        ExpenseCategory category,
        LocalDate cursorDate,
        Long cursorId,
        int size
    ) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(expense.member.id.eq(memberId));

        applyDateCondition(builder, yearMonth, date);
        applyCategoryCondition(builder, category);
        applyCursorCondition(builder, cursorDate, cursorId);

        return queryFactory
            .selectFrom(expense)
            .join(expense.memberCar, memberCar).fetchJoin()
            .join(memberCar.model, carModel).fetchJoin()
            .where(builder)
            .orderBy(expense.expenseDate.desc(), expense.id.desc())
            .limit(size)
            .fetch();
    }

    @Override
    public int countExpenses(
        Long memberId,
        YearMonth yearMonth,
        LocalDate date,
        ExpenseCategory category
    ) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(expense.member.id.eq(memberId));

        applyDateCondition(builder, yearMonth, date);
        applyCategoryCondition(builder, category);

        Long count = queryFactory
            .select(expense.count())
            .from(expense)
            .where(builder)
            .fetchOne();

        return count != null ? count.intValue() : 0;
    }

    @Override
    public List<CategorySummary> findCategorySummaries(Long memberId, YearMonth yearMonth) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(expense.member.id.eq(memberId));
        applyYearMonthCondition(builder, yearMonth);

        Map<ExpenseCategory, BigDecimal> amountByCategory = queryFactory
            .select(expense.category, expense.amount.sum())
            .from(expense)
            .where(builder)
            .groupBy(expense.category)
            .fetch()
            .stream()
            .collect(Collectors.toMap(
                tuple -> tuple.get(expense.category),
                tuple -> {
                    BigDecimal sum = tuple.get(expense.amount.sum());
                    return sum != null ? sum : BigDecimal.ZERO;
                }
            ));

        return Arrays.stream(ExpenseCategory.values())
            .map(category -> new CategorySummary(
                category.name(),
                category.getDescription(),
                amountByCategory.getOrDefault(category, BigDecimal.ZERO)
            ))
            .toList();
    }

    @Override
    public BigDecimal findTotalAmount(Long memberId, YearMonth yearMonth) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(expense.member.id.eq(memberId));
        applyYearMonthCondition(builder, yearMonth);

        BigDecimal total = queryFactory
            .select(expense.amount.sum())
            .from(expense)
            .where(builder)
            .fetchOne();

        return total != null ? total : BigDecimal.ZERO;
    }

    @Override
    public LocalDate findFirstExpenseDate(Long memberId) {
        return queryFactory
            .select(expense.expenseDate.min())
            .from(expense)
            .where(expense.member.id.eq(memberId))
            .fetchOne();
    }

    @Override
    public LocalDate findLastExpenseDate(Long memberId) {
        return queryFactory
            .select(expense.expenseDate.max())
            .from(expense)
            .where(expense.member.id.eq(memberId))
            .fetchOne();
    }

    private void applyDateCondition(BooleanBuilder builder, YearMonth yearMonth, LocalDate date) {
        if (date != null) {
            builder.and(expense.expenseDate.eq(date));
        } else if (yearMonth != null) {
            builder.and(expense.expenseDate.between(
                yearMonth.atDay(1),
                yearMonth.atEndOfMonth()
            ));
        }
    }

    private void applyCategoryCondition(BooleanBuilder builder, ExpenseCategory category) {
        if (category != null) {
            builder.and(expense.category.eq(category));
        }
    }

    private void applyCursorCondition(BooleanBuilder builder, LocalDate cursorDate, Long cursorId) {
        if (cursorDate != null && cursorId != null) {
            builder.and(
                expense.expenseDate.lt(cursorDate)
                    .or(expense.expenseDate.eq(cursorDate).and(expense.id.lt(cursorId)))
            );
        }
    }

    private void applyYearMonthCondition(BooleanBuilder builder, YearMonth yearMonth) {
        if (yearMonth != null) {
            builder.and(expense.expenseDate.between(
                yearMonth.atDay(1),
                yearMonth.atEndOfMonth()
            ));
        }
    }

}
