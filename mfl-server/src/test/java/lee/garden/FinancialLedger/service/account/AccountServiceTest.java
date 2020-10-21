package lee.garden.FinancialLedger.service.account;

import lee.garden.FinancialLedger.common.error.exception.account.LogInFailedException;
import lee.garden.FinancialLedger.domain.account.CustomUser;
import lee.garden.FinancialLedger.dto.account.LogInDTO;
import lee.garden.FinancialLedger.dto.account.SignUpDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired AccountService accountService;

    @Test
    public void 회원가입_성공() {
        //given
        SignUpDTO signUpDTO = new SignUpDTO("khjvvv7@gmail.com", "rkemsWKd123", "가든");

        //when
        Long userId = accountService.signUp(signUpDTO);

        //then
        assertEquals(Long.valueOf(1), userId);
    }

    @Transactional
    @Test
    public void 로그인_성공 () throws Exception {
        //given
        SignUpDTO signUpDTO = new SignUpDTO("khjvvv7@gmail.com", "rkemsWKd123", "가든");
        Long userId = accountService.signUp(signUpDTO);

        //when
        LogInDTO logInDTO = new LogInDTO("khjvvv7@gmail.com", "rkemsWKd123");
        CustomUser findUser = accountService.signIn(logInDTO);

        //then
        assertEquals(userId, findUser.getId());
    }

    /**
     * Error Response 정의시까지 보류
     * */
    @Transactional
    @Test(expected = LogInFailedException.class)
    public void 로그인_실패 () throws Exception {
        //given
        SignUpDTO signUpDTO = new SignUpDTO("khjvvv7@gmail.com", "rkemsWKd123", "가든");
        Long userId = accountService.signUp(signUpDTO);

        //when
        LogInDTO logInDTO = new LogInDTO("khjvvv7@gmail.com", "1234");
        accountService.signIn(logInDTO);
    }


}