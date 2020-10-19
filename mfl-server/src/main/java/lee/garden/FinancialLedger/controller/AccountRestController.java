package lee.garden.FinancialLedger.controller;

import lee.garden.FinancialLedger.dto.account.SignUpDTO;
import lee.garden.FinancialLedger.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AccountRestController {

    private final AccountService accountService;

    @PostMapping("/api/v1/signup")
    public Long signUp(@RequestBody SignUpDTO signUpDTO) {
        return accountService.signUp(signUpDTO);
    }

}
