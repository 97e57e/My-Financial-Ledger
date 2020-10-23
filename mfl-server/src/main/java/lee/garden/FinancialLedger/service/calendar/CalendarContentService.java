package lee.garden.FinancialLedger.service.calendar;

import lee.garden.FinancialLedger.dto.common.CreateDTO;

public interface CalendarContentService {

    Long add(CreateDTO createDTO);
    void update();
}
