package lee.garden.FinancialLedger.dto.calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import lee.garden.FinancialLedger.domain.calendar.AssetType;
import lee.garden.FinancialLedger.domain.calendar.FinancialActionType;
import lee.garden.FinancialLedger.dto.common.CreateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FinancialHistoryCreateDTO implements CreateDTO {

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime date;
    private FinancialActionType actionType;
    private AssetType assetType;
    private String category;
    private int amount;

}
