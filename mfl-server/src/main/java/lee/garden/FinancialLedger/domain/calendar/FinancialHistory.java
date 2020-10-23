package lee.garden.FinancialLedger.domain.calendar;

import lee.garden.FinancialLedger.common.enumConverter.AssetTypeConverter;
import lee.garden.FinancialLedger.common.enumConverter.FinancialActionTypeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class FinancialHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Convert(converter = FinancialActionTypeConverter.class)
    private FinancialActionType actionType;

    @Convert(converter = AssetTypeConverter.class)
    private AssetType assetType;

    private String category;

    private int amount;

    /**
     * 생성 메서드
     * */
    public static FinancialHistory createHistory(LocalDateTime date, FinancialActionType action, AssetType asset,
                                                 String category, int amount) {
        return FinancialHistory.builder()
                .date(date)
                .actionType(action)
                .assetType(asset)
                .category(category)
                .amount(amount)
                .build();
    }

}
