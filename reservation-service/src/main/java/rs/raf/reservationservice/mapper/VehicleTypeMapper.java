package rs.raf.reservationservice.mapper;

import org.springframework.stereotype.Component;
import rs.raf.core.dto.reservationservice.base.VehicleInFirmDto;
import rs.raf.core.dto.reservationservice.base.VehicleTypeDto;
import rs.raf.core.dto.reservationservice.view.FirmViewDto;
import rs.raf.core.dto.reservationservice.view.VehicleInFirmViewDto;
import rs.raf.core.dto.reservationservice.view.VehicleViewDto;
import rs.raf.reservationservice.domain.Firm;
import rs.raf.reservationservice.domain.Vehicle;
import rs.raf.reservationservice.domain.VehicleInFirm;
import rs.raf.reservationservice.domain.VehicleType;

import java.util.Optional;

@Component
public class VehicleTypeMapper {
    public VehicleTypeDto vehicleTypeToVehicleTypeDto(VehicleType vehicleType){
        return VehicleTypeDto.builder()
                .id(vehicleType.getId())
                .vehicle_type(vehicleType.getVehicle_type()).build();
    }
    public VehicleType vehicleTypeDtoToVehicle(VehicleTypeDto vehicleTypeDto){
        return VehicleType.builder()
                .id(vehicleTypeDto.getId())
                .vehicle_type(vehicleTypeDto.getVehicle_type()).build();
    }
}
