package rs.raf.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.raf.reservationservice.domain.Firm;
import rs.raf.reservationservice.domain.Reservation;
import rs.raf.reservationservice.domain.Review;
import rs.raf.reservationservice.domain.VehicleInFirm;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.client_user_id = :id")
    List<Review> findAllByClient_user_id(Long id);
    @Query("SELECT r FROM Review r WHERE r.firm.id = :id")
    List<Review> findAllByFirmId(Long id);


    @Query("SELECT r FROM Review r WHERE r.client_user_id = :clientUserId AND r.firm.id = :firmId")
    Review findByClient_user_idAndFirmId(
            @Param("clientUserId") Long clientUserId,
            @Param("firmId") Long firmId
    );

    @Modifying
    @Query("DELETE FROM Review r WHERE r.client_user_id = :clientUserId AND r.firm.id = :firmId")
    void deleteByClient_user_idAndFirmId(
            @Param("clientUserId") Long clientUserId,
            @Param("firmId") Long firmId
    );
}
