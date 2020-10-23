package lee.garden.FinancialLedger.domain.calendar;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum AssetType {

    CASH("현금", 1),
    CARD("카드",2);

    private final String displayName;
    private final int code;

    public static AssetType ofCode(int code) {
        return Arrays.stream(AssetType.values())
                .filter(v -> code == v.code)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
