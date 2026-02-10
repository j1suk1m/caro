package today.caro.api.drivingrecord.dto;

import java.util.List;

public record DrivingRecordTodayGetResponse(
    List<DrivingRecordGetResponse> records,
    long totalCount
) {
    public static DrivingRecordTodayGetResponse of(List<DrivingRecordGetResponse> records) {
        return new DrivingRecordTodayGetResponse(records, records.size());
    }
}
