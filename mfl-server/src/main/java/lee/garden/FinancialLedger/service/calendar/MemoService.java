package lee.garden.FinancialLedger.service.calendar;

import lee.garden.FinancialLedger.dto.common.CreateDTO;
import org.springframework.stereotype.Service;

@Service
public class MemoService implements CalendarContentService{

    @Override
    public Long add(CreateDTO createDTO) {
        return 0L;
    }

    @Override
    public void update() {

    }
}
