package lee.garden.FinancialLedger.repository.calendar;

import lee.garden.FinancialLedger.domain.calendar.FinancialHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialHistoryRepository extends JpaRepository<FinancialHistory, Long> {
}
