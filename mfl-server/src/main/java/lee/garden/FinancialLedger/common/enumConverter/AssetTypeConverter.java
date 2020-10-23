package lee.garden.FinancialLedger.common.enumConverter;

import lee.garden.FinancialLedger.domain.calendar.AssetType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AssetTypeConverter implements AttributeConverter<AssetType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AssetType attribute) {
        return attribute.getCode();
    }

    @Override
    public AssetType convertToEntityAttribute(Integer dbData) {
        return AssetType.ofCode(dbData);
    }
}
