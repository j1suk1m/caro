package today.caro.api.drivingrecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import today.caro.api.drivingrecord.entity.DrivingRecord;

import java.time.LocalDateTime;
import java.util.List;

public interface DrivingRecordRepository extends JpaRepository<DrivingRecord, Long>, DrivingRecordRepositoryCustom {

    @Query("""
        SELECT dr FROM DrivingRecord dr
        JOIN FETCH dr.memberCar mc
        JOIN FETCH mc.model m
        WHERE dr.member.id = :memberId
        AND dr.startDateTime >= :startDateTime
        AND dr.startDateTime <= :endDateTime
        AND dr.id < :cursor
        ORDER BY dr.id DESC
        LIMIT :size
    """)
    List<DrivingRecord> findByMemberIdAndMonth(
        @Param("memberId") Long memberId,
        @Param("startDateTime") LocalDateTime startDateTime,
        @Param("endDateTime") LocalDateTime endDateTime,
        @Param("cursor") Long cursor,
        @Param("size") int size
    );

    @Query("""
        SELECT dr FROM DrivingRecord dr
        JOIN FETCH dr.memberCar mc
        JOIN FETCH mc.model m
        WHERE dr.member.id = :memberId
        AND dr.startDateTime >= :startDateTime
        AND dr.startDateTime <= :endDateTime
        ORDER BY dr.id DESC
        LIMIT :size
    """)
    List<DrivingRecord> findByMemberIdAndMonthNoCursor(
        @Param("memberId") Long memberId,
        @Param("startDateTime") LocalDateTime startDateTime,
        @Param("endDateTime") LocalDateTime endDateTime,
        @Param("size") int size
    );

}
