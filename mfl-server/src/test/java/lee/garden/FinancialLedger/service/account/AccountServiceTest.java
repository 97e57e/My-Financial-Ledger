package lee.garden.FinancialLedger.service.account;

import lee.garden.FinancialLedger.dto.account.SignUpDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired AccountService accountService;

    @Test
    public void 회원가입_성공() {
        SignUpDTO signUpDTO = new SignUpDTO("khjvvv7@gmail.com", "1234", "가든");
        Long userId = accountService.signUp(signUpDTO);

        assertEquals(Long.valueOf(1), userId);
    }

}