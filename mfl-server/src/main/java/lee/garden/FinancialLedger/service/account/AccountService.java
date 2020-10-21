package lee.garden.FinancialLedger.service.account;

import lee.garden.FinancialLedger.common.error.exception.account.LogInFailedException;
import lee.garden.FinancialLedger.domain.account.CustomUser;
import lee.garden.FinancialLedger.dto.account.LogInDTO;
import lee.garden.FinancialLedger.dto.account.SignUpDTO;
import lee.garden.FinancialLedger.repository.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class AccountService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    public Long signUp(SignUpDTO signUpDTO) {

        CustomUser user = CustomUser.createUser(
                signUpDTO.getUsername(),
                passwordEncoder.encode(signUpDTO.getPassword()),
                signUpDTO.getNickname()
        );

        return accountRepository.save(user).getId();
    }


    public CustomUser signIn(LogInDTO logInDTO) throws Exception {
        CustomUser user = accountRepository.findByUsername(logInDTO.getUsername()).orElseThrow(EntityNotFoundException::new);

        if(!passwordEncoder.matches(logInDTO.getPassword(), user.getPassword())) {
            throw new LogInFailedException("로그인에 실패했습니다.");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return accountRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
}
