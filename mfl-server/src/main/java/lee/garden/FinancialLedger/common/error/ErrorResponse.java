package lee.garden.FinancialLedger.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private String message;
    private LocalDateTime current;

}
