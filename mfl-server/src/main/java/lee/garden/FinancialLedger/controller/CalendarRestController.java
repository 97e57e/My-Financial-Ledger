package lee.garden.FinancialLedger.controller;

import lee.garden.FinancialLedger.dto.calendar.FinancialHistoryCreateDTO;
import lee.garden.FinancialLedger.service.calendar.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CalendarRestController {

    private final CalendarService calendarService;

    @PostMapping("/api/v1/history")
    public Long createFinancialHistory(@RequestBody FinancialHistoryCreateDTO createDTO) {
        Long historyId = calendarService.createFinancialHistory(createDTO);
        return historyId;
    }
}
