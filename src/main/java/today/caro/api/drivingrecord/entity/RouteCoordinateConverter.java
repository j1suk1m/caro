package today.caro.api.drivingrecord.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter
public class RouteCoordinateConverter implements AttributeConverter<List<RouteCoordinate>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<RouteCoordinate> attribute) {
        if (attribute == null) return null;

        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("경로 좌표를 JSON으로 변환할 수 없습니다.", e);
        }
    }

    @Override
    public List<RouteCoordinate> convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;

        try {
            return objectMapper.readValue(dbData, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("JSON을 경로 좌표로 변환할 수 없습니다.", e);
        }
    }

}
