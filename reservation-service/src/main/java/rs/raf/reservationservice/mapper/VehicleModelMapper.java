package rs.raf.reservationservice.mapper;

import org.springframework.stereotype.Component;
import rs.raf.core.dto.reservationservice.base.VehicleModelDto;
import rs.raf.reservationservice.domain.VehicleModel;

@Component
public class VehicleModelMapper {
    public VehicleModelDto vehicleModelToVehicleModelDto(VehicleModel vehicleModel){
        return VehicleModelDto.builder()
                .id(vehicleModel.getId())
                .vehicle_model(vehicleModel.getVehicle_Model()).build();
    }
    public VehicleModel vehicleModelDtoToVehicle(VehicleModelDto vehicleModelDto){
        return VehicleModel.builder()
                .id(vehicleModelDto.getId())
                .vehicle_Model(vehicleModelDto.getVehicle_model()).build();
    }
}
