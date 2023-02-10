package rs.raf.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.raf.reservationservice.domain.VehicleInFirm;

import java.util.List;

@Repository
public interface VehicleInFirmRepository extends JpaRepository<VehicleInFirm, Long> {

    @Query("SELECT v FROM VehicleInFirm v WHERE v.firm.id = :firmId")
    List<VehicleInFirm> findAllByFirmId(
            @Param("firmId") Long firmId
    );
}
