package today.caro.api.expense.dto;

import today.caro.api.expense.entity.Expense;
import today.caro.api.expense.entity.ExpenseCategory;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseUpdateResponse(
    Long id,
    LocalDate expenseDate,
    ExpenseCategory category,
    BigDecimal amount,
    String location,
    String memo
) {
    public static ExpenseUpdateResponse from(Expense expense) {
        return new ExpenseUpdateResponse(
            expense.getId(),
            expense.getExpenseDate(),
            expense.getCategory(),
            expense.getAmount(),
            expense.getLocation(),
            expense.getMemo()
        );
    }
}
