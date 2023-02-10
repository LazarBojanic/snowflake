package rs.raf.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.raf.reservationservice.domain.Firm;
import rs.raf.reservationservice.domain.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r WHERE r.client_user_id = :clientUserId")
    List<Reservation> findAllByClient_user_id(
            @Param("clientUserId") Long clientUserId
    );

    @Query("SELECT r FROM Reservation r WHERE r.vehicle_in_firm.id = :vehicleInFirmId")
    List<Reservation> findAllByVehicle_in_firmId(
            @Param("vehicleInFirmId") Long vehicleInFirmId
    );

    @Query("SELECT r FROM Reservation r WHERE r.client_user_id = :clientUserId AND r.vehicle_in_firm.id = :vehicleInFirmId")
    Reservation findByClient_user_idAndVehicle_in_firmId(
            @Param("clientUserId") Long clientUserId,
            @Param("vehicleInFirmId") Long vehicleInFirmId
    );

    @Modifying
    @Query("DELETE FROM Reservation r WHERE r.client_user_id = :clientUserId AND r.vehicle_in_firm.id = :vehicleInFirmId")
    void deleteByClient_user_idAndVehicle_in_firmId(
            @Param("clientUserId") Long clientUserId,
            @Param("vehicleInFirmId") Long vehicleInFirmId
    );
}
