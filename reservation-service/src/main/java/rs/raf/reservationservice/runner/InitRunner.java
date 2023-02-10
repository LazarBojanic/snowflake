package rs.raf.reservationservice.runner;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rs.raf.reservationservice.domain.*;
import rs.raf.reservationservice.repository.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Profile({"default"})
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InitRunner implements CommandLineRunner {
    @Autowired
    private FirmRepository firmRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private VehicleInFirmRepository vehicleInFirmRepository;
    @Override
    public void run(String... args) throws Exception {
        /*vehicleInFirmRepository.deleteAll();
        vehicleRepository.deleteAll();
        vehicleModelRepository.deleteAll();
        vehicleTypeRepository.deleteAll();
        firmRepository.deleteAll();

        Firm firm = new Firm();
        firm.setFirm_name("firm1");
        firm.setDescription("fun vehicle firm");
        firm.setNumber_of_vehicles(10);
        firm.setCity("Paris");
        firmRepository.save(firm);

        VehicleType vehicleType = new VehicleType();
        vehicleType.setVehicle_type("car");
        vehicleTypeRepository.save(vehicleType);

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicle_Model("Mazda");
        vehicleModelRepository.save(vehicleModel);

        Vehicle vehicle = new Vehicle();
        vehicle.setName("vehicle1");
        vehicle.setVehicle_type(vehicleType);
        vehicle.setVehicle_model(vehicleModel);
        vehicle.setHorse_power(400.0);
        vehicle.setProduction_year(2001);
        vehicleRepository.save(vehicle);

        VehicleInFirm vehicleInFirm = new VehicleInFirm();

        vehicleInFirm.setFirm(firm);
        vehicleInFirm.setVehicle(vehicle);
        vehicleInFirm.setPrice(500.0);
        vehicleInFirmRepository.save(vehicleInFirm);*/
    }
}
