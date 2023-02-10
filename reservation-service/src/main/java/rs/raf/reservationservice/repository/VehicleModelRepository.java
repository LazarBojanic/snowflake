package rs.raf.reservationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.raf.reservationservice.domain.VehicleModel;

@Repository
public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {

}