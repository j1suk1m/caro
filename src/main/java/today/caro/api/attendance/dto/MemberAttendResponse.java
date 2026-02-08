package today.caro.api.attendance.dto;

import today.caro.api.attendance.entity.MemberAttendance;

public record MemberAttendResponse(
    Long id,
    int streak,
    int points
) {
    public static MemberAttendResponse from(MemberAttendance attendance) {
        return new MemberAttendResponse(
            attendance.getId(),
            attendance.getStreak(),
            attendance.getPoints()
        );
    }
}
