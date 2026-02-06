package today.caro.api.expense.dto;

import jakarta.validation.constraints.NotNull;
import today.caro.api.expense.entity.ExpenseCategory;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseUpdateRequest(

    @NotNull
    LocalDate expenseDate,

    @NotNull
    ExpenseCategory category,

    @NotNull
    BigDecimal amount,

    @NotNull
    String location,

    String memo

) {
}
