package rs.raf.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.raf.reservationservice.domain.Firm;
import rs.raf.reservationservice.domain.VehicleInFirm;

import java.util.List;

@Repository
public interface FirmRepository extends JpaRepository<Firm, Long> {
    @Query("SELECT f FROM Firm f WHERE f.firm_name = :firmName")
    Firm findFirmByFirm_name(
            @Param("firmName") String firmName
    );
}
