package lee.garden.FinancialLedger.service.calendar;

import lee.garden.FinancialLedger.dto.calendar.FinancialHistoryCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CalendarService {

    private final HistoryService historyService;

    public Long createFinancialHistory(FinancialHistoryCreateDTO createDTO) {
        Long historyId = historyService.add(createDTO);
        return historyId;
    }
}
