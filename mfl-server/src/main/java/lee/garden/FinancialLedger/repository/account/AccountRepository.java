package lee.garden.FinancialLedger.repository.account;

import lee.garden.FinancialLedger.domain.account.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<CustomUser, Long> {
}
