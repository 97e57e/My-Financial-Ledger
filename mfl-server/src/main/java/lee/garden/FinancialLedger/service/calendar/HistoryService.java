package lee.garden.FinancialLedger.service.calendar;

import lee.garden.FinancialLedger.domain.calendar.FinancialHistory;
import lee.garden.FinancialLedger.dto.calendar.FinancialHistoryCreateDTO;
import lee.garden.FinancialLedger.dto.common.CreateDTO;
import lee.garden.FinancialLedger.repository.calendar.FinancialHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HistoryService implements CalendarContentService{

    private final FinancialHistoryRepository historyRepository;

    @Override
    public Long add(CreateDTO createDTO) {
        FinancialHistoryCreateDTO historyCreateDTO = (FinancialHistoryCreateDTO) createDTO;
        FinancialHistory history = FinancialHistory.createHistory(
                historyCreateDTO.getDate(),
                historyCreateDTO.getActionType(),
                historyCreateDTO.getAssetType(),
                historyCreateDTO.getCategory(),
                historyCreateDTO.getAmount()
        );
        Long createId = historyRepository.save(history).getId();
        return createId;
    }

    @Override
    public void update() {

    }
}
