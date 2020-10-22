package lee.garden.FinancialLedger.controller;

import lee.garden.FinancialLedger.domain.account.CustomUser;
import lee.garden.FinancialLedger.dto.account.LogInDTO;
import lee.garden.FinancialLedger.dto.account.SignUpDTO;
import lee.garden.FinancialLedger.module.JwtProvider;
import lee.garden.FinancialLedger.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AccountRestController {

    private final JwtProvider jwtProvider;
    private final AccountService accountService;

    @GetMapping("/health-check")
    public String health_check() {
        return "check";
    }

    @PostMapping("/api/v1/signup")
    public ResponseEntity<Map<String, Boolean>> signUp(@RequestBody SignUpDTO signUpDTO) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", accountService.signUp(signUpDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/api/v1/login")
    public ResponseEntity<Map<String, String>> signIn(@RequestBody LogInDTO logInDTO) throws Exception {
        Map<String, String> response = new HashMap<>();

        CustomUser user = accountService.signIn(logInDTO);
        String token = jwtProvider.generateToken(user);

        response.put("token", token);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
