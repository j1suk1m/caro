package today.caro.api.point.dto;

public record PointClaimResponse(
    int claimedPoints,
    int remainingPendingCount
) {
}
