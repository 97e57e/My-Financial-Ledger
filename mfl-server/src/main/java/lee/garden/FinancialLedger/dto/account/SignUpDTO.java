package lee.garden.FinancialLedger.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpDTO {

    private String username;
    private String password;
    private String nickname;

}
