package lee.garden.FinancialLedger.domain.calendar;

import lee.garden.FinancialLedger.common.enumConverter.FinancialActionTypeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class FinancialHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Convert(converter = FinancialActionTypeConverter.class)
    private FinancialActionType actionType;

    @Convert(converter = AssetType.class)
    private AssetType assetType;

    private String category;

    private int amount;

}
