package rs.raf.reservationservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.raf.core.dto.reservationservice.base.FirmDto;
import rs.raf.core.dto.reservationservice.base.ReservationDto;
import rs.raf.core.dto.reservationservice.view.FirmViewDto;
import rs.raf.core.dto.reservationservice.view.ReservationViewDto;
import rs.raf.core.dto.reservationservice.view.VehicleInFirmViewDto;
import rs.raf.reservationservice.domain.Firm;
import rs.raf.reservationservice.domain.Reservation;
import rs.raf.reservationservice.domain.VehicleInFirm;
import rs.raf.reservationservice.repository.VehicleInFirmRepository;

import java.util.Optional;

@Component
public class ReservationMapper {
    @Autowired
    VehicleInFirmRepository vehicleInFirmRepository;
    @Autowired
    VehicleInFirmMapper vehicleInFirmMapper;
    public ReservationDto reservationToReservationDto(Reservation reservation){
        return ReservationDto.builder()
                .id(reservation.getId())
                .client_user_id(reservation.getClient_user_id())
                .vehicle_in_firm_id(reservation.getVehicle_in_firm().getId())
                .start_date(reservation.getStart_date())
                .end_date(reservation.getEnd_date())
                .build();
    }
    public ReservationViewDto reservationToReservationViewDto(Reservation reservation){
        VehicleInFirmViewDto vehicleInFirmViewDto = vehicleInFirmMapper.vehicleInFirmToVehicleInFirmViewDto(reservation.getVehicle_in_firm());
        return ReservationViewDto.builder()
                .id(reservation.getId())
                .client_user_id(reservation.getClient_user_id())
                .vehicle_in_firm(vehicleInFirmViewDto)
                .start_date(reservation.getStart_date())
                .end_date(reservation.getEnd_date())
                .build();
    }
    public Reservation reservationDtoToReservation(ReservationDto reservationDto){
        Optional<VehicleInFirm> optionalFirmInFirm = vehicleInFirmRepository.findById(reservationDto.getVehicle_in_firm_id());
        if(optionalFirmInFirm.isPresent()){
            VehicleInFirm vehicleInFirm = optionalFirmInFirm.get();
            return Reservation.builder()
                    .id(reservationDto.getId())
                    .client_user_id(reservationDto.getClient_user_id())
                    .vehicle_in_firm(vehicleInFirm)
                    .start_date(reservationDto.getStart_date())
                    .end_date(reservationDto.getEnd_date())
                    .build();
        }
        return null;
    }
    public Reservation reservationViewDtoToReservation(ReservationViewDto reservationViewDto){
        Optional<VehicleInFirm> optionalFirmInFirm = vehicleInFirmRepository.findById(reservationViewDto.getVehicle_in_firm().getId());
        if(optionalFirmInFirm.isPresent()){
            VehicleInFirm vehicleInFirm = optionalFirmInFirm.get();
            return Reservation.builder()
                    .id(reservationViewDto.getId())
                    .client_user_id(reservationViewDto.getClient_user_id())
                    .vehicle_in_firm(vehicleInFirm)
                    .start_date(reservationViewDto.getStart_date())
                    .end_date(reservationViewDto.getEnd_date())
                    .build();
        }
        return null;
    }
}
