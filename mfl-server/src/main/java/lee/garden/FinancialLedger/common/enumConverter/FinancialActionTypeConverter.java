package lee.garden.FinancialLedger.common.enumConverter;

import lee.garden.FinancialLedger.domain.calendar.FinancialActionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FinancialActionTypeConverter implements AttributeConverter<FinancialActionType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(FinancialActionType attribute) {
        return attribute.getCode();
    }

    @Override
    public FinancialActionType convertToEntityAttribute(Integer dbData) {
        return FinancialActionType.ofCode(dbData);
    }
}
