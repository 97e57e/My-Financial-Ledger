package lee.garden.FinancialLedger.domain.calendar;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum FinancialActionType {

    INCOME("수입", 1),
    EXPENDITURE("지출", 2);

    private final String displayName;
    private final int code;

    public static FinancialActionType ofCode(int code) {
        return Arrays.stream(FinancialActionType.values())
                .filter(v -> code == v.code)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}
