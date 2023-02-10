package rs.raf.reservationservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.raf.core.dto.reservationservice.base.VehicleDto;
import rs.raf.core.dto.reservationservice.base.VehicleModelDto;
import rs.raf.core.dto.reservationservice.base.VehicleTypeDto;
import rs.raf.core.dto.reservationservice.view.VehicleTypeViewDto;
import rs.raf.core.dto.reservationservice.view.VehicleViewDto;
import rs.raf.reservationservice.domain.Vehicle;
import rs.raf.reservationservice.domain.VehicleModel;
import rs.raf.reservationservice.domain.VehicleType;
import rs.raf.reservationservice.repository.VehicleModelRepository;
import rs.raf.reservationservice.repository.VehicleTypeRepository;

import java.util.Optional;

@Component
public class VehicleMapper {
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    VehicleModelRepository vehicleModelRepository;

    @Autowired
    VehicleTypeMapper vehicleTypeMapper;
    @Autowired
    VehicleModelMapper vehicleModelMapper;
    public VehicleDto vehicleToVehicleDto(Vehicle vehicle){
        return VehicleDto.builder()
                .vehicle_type_id(vehicle.getVehicle_type().getId())
                .vehicle_model_id(vehicle.getVehicle_model().getId())
                .vehicle_name(vehicle.getVehicle_name())
                .production_year(vehicle.getProduction_year())
                .horse_power(vehicle.getHorse_power())
                .build();
    }
    public VehicleViewDto vehicleToVehicleViewDto(Vehicle vehicle){
        VehicleTypeDto vehicleTypeDto = vehicleTypeMapper.vehicleTypeToVehicleTypeDto(vehicle.getVehicle_type());
        VehicleModelDto vehicleModelDto = vehicleModelMapper.vehicleModelToVehicleModelDto(vehicle.getVehicle_model());
        return VehicleViewDto.builder()
                .id(vehicle.getId())
                .vehicle_type(vehicleTypeDto)
                .vehicle_model(vehicleModelDto)
                .vehicle_name(vehicle.getVehicle_name())
                .production_year(vehicle.getProduction_year())
                .horse_power(vehicle.getHorse_power())
                .build();
    }
    public Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto){
        Optional<VehicleType> vehicleType = vehicleTypeRepository.findById(vehicleDto.getVehicle_type_id());
        Optional<VehicleModel> vehicleModel = vehicleModelRepository.findById(vehicleDto.getVehicle_model_id());
        if(vehicleType.isPresent() && vehicleModel.isPresent()){
            return Vehicle.builder()
                    .vehicle_type(vehicleType.get())
                    .vehicle_model(vehicleModel.get())
                    .vehicle_name(vehicleDto.getVehicle_name())
                    .production_year(vehicleDto.getProduction_year())
                    .horse_power(vehicleDto.getHorse_power())
                    .build();
        }
        return null;
    }
}
