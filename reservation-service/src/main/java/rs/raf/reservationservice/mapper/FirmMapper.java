package rs.raf.reservationservice.mapper;

import org.springframework.stereotype.Component;
import rs.raf.core.dto.reservationservice.base.FirmDto;
import rs.raf.core.dto.reservationservice.view.FirmViewDto;
import rs.raf.reservationservice.domain.Firm;

@Component
public class FirmMapper {
    public FirmDto firmToFirmDto(Firm firm){
        return FirmDto.builder()
                .id(firm.getId())
                .firm_name(firm.getFirm_name())
                .description(firm.getDescription())
                .number_of_vehicles(firm.getNumber_of_vehicles())
                .city(firm.getCity())
                .build();
    }
    public FirmViewDto firmToFirmViewDto(Firm firm){
        return FirmViewDto.builder()
                .id(firm.getId())
                .firm_name(firm.getFirm_name())
                .description(firm.getDescription())
                .number_of_vehicles(firm.getNumber_of_vehicles())
                .city(firm.getCity())
                .build();
    }
    public Firm firmDtoToFirm(FirmDto firmDto){
        return Firm.builder()
                .id(firmDto.getId())
                .firm_name(firmDto.getFirm_name())
                .description(firmDto.getDescription())
                .number_of_vehicles(firmDto.getNumber_of_vehicles())
                .city(firmDto.getCity())
                .build();
    }
    public Firm firmViewDtoToFirm(FirmViewDto firmViewDto){
        return Firm.builder()
                .id(firmViewDto.getId())
                .firm_name(firmViewDto.getFirm_name())
                .description(firmViewDto.getDescription())
                .number_of_vehicles(firmViewDto.getNumber_of_vehicles())
                .city(firmViewDto.getCity())
                .build();
    }
}
