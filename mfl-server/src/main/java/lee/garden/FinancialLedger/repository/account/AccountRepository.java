package lee.garden.FinancialLedger.repository.account;

import lee.garden.FinancialLedger.domain.account.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<CustomUser, Long> {
    Optional<CustomUser> findByUsername(String username);
}
