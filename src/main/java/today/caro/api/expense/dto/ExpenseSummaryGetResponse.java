package today.caro.api.expense.dto;

import jakarta.annotation.Nullable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ExpenseSummaryGetResponse(
    Period period,
    TotalAmount totalAmount,
    List<CategorySummary> categories
) {

    public record Period(
        LocalDate startDate,
        LocalDate endDate
    ) {}

    public record TotalAmount(
        BigDecimal amount,
        @Nullable Comparison comparison
    ) {}

    public record Comparison(
        BigDecimal previousAmount,
        BigDecimal difference
    ) {}

    public record CategorySummary(
        String category,
        String categoryLabel,
        BigDecimal amount
    ) {}

}
