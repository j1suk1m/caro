package today.caro.api.expense.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExpenseCategory {

    FUEL("주유비"),
    MAINTENANCE("정비·수리비"),
    PARKING("주차비"),
    TOLL("통행료"),
    CAR_WASH("세차비");

    private final String description;

}
