package lee.garden.FinancialLedger.service.account;

import lee.garden.FinancialLedger.domain.account.CustomUser;
import lee.garden.FinancialLedger.dto.account.SignUpDTO;
import lee.garden.FinancialLedger.repository.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


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

    @Override
    public UserDetails loadUserByUsername(String userId) {
        return accountRepository.findById(Long.valueOf(userId)).orElseThrow(EntityNotFoundException::new);
    }
}
