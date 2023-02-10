package rs.raf.reservationservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.raf.core.dto.reservationservice.base.VehicleInFirmDto;
import rs.raf.core.dto.reservationservice.view.FirmViewDto;
import rs.raf.core.dto.reservationservice.view.VehicleInFirmViewDto;
import rs.raf.core.dto.reservationservice.view.VehicleViewDto;
import rs.raf.reservationservice.domain.Firm;
import rs.raf.reservationservice.domain.Reservation;
import rs.raf.reservationservice.domain.Vehicle;
import rs.raf.reservationservice.domain.VehicleInFirm;
import rs.raf.reservationservice.repository.FirmRepository;
import rs.raf.reservationservice.repository.ReservationRepository;
import rs.raf.reservationservice.repository.VehicleRepository;

import java.util.Optional;

@Component
public class VehicleInFirmMapper {
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private FirmMapper firmMapper;
    @Autowired
    private FirmRepository firmRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleInFirmDto vehicleInFirmToVehicleInFirmDto(VehicleInFirm vehicleInFirm){
        return VehicleInFirmDto.builder()
                .id(vehicleInFirm.getId())
                .firm_id(vehicleInFirm.getFirm().getId())
                .vehicle_id(vehicleInFirm.getVehicle().getId())
                .price(vehicleInFirm.getPrice())
                .build();
    }
    public VehicleInFirmViewDto vehicleToVehicleInFirmViewDto(VehicleInFirm vehicleInFirm){
        VehicleViewDto vehicleViewDto = vehicleMapper.vehicleToVehicleViewDto(vehicleInFirm.getVehicle());
        FirmViewDto firmViewDto = firmMapper.firmToFirmViewDto(vehicleInFirm.getFirm());
        return VehicleInFirmViewDto.builder()
                .id(vehicleInFirm.getId())
                .vehicle(vehicleViewDto)
                .firm(firmViewDto)
                .price(vehicleInFirm.getPrice()).build();
    }
    public VehicleInFirmViewDto vehicleInFirmToVehicleInFirmViewDto(VehicleInFirm vehicleInFirm){
        VehicleViewDto vehicleViewDto = vehicleMapper.vehicleToVehicleViewDto(vehicleInFirm.getVehicle());
        FirmViewDto firmViewDto = firmMapper.firmToFirmViewDto(vehicleInFirm.getFirm());
        return VehicleInFirmViewDto.builder()
                .id(vehicleInFirm.getId())
                .vehicle(vehicleViewDto)
                .firm(firmViewDto)
                .price(vehicleInFirm.getPrice()).build();
    }
    public VehicleInFirmViewDto vehicleInFirmDtoToVehicleInFirmViewDto(VehicleInFirmDto vehicleInFirmDto){
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleInFirmDto.getVehicle_id());
        Optional<Firm> optionalFirm = firmRepository.findById(vehicleInFirmDto.getFirm_id());
        if(optionalVehicle.isPresent() && optionalFirm.isPresent()){
            Vehicle vehicle = optionalVehicle.get();
            VehicleViewDto vehicleViewDto = vehicleMapper.vehicleToVehicleViewDto(vehicle);
            Firm firm = optionalFirm.get();
            FirmViewDto firmViewDto = firmMapper.firmToFirmViewDto(firm);
            return VehicleInFirmViewDto.builder()
                    .id(vehicleInFirmDto.getId())
                    .vehicle(vehicleViewDto)
                    .firm(firmViewDto)
                    .price(vehicleInFirmDto.getPrice()).build();
        }
        return null;
    }
    public VehicleInFirm vehicleInFirmDtoToVehicleInFirm(VehicleInFirmDto vehicleInFirmDto){
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleInFirmDto.getVehicle_id());
        Optional<Firm> optionalFirm = firmRepository.findById(vehicleInFirmDto.getFirm_id());
        if(optionalVehicle.isPresent() && optionalFirm.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();
            Firm firm = optionalFirm.get();
            return VehicleInFirm.builder()
                    .id(vehicleInFirmDto.getId())
                    .vehicle(vehicle)
                    .firm(firm)
                    .price(vehicleInFirmDto.getPrice()).build();
        }
        return null;
    }
}
