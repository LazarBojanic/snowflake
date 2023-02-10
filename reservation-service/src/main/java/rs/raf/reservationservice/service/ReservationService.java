package rs.raf.reservationservice.service;


import rs.raf.core.dto.reservationservice.base.*;
import rs.raf.core.dto.reservationservice.view.*;

import java.util.List;

public interface ReservationService {
    List<FirmViewDto> getAllFirms();
    FirmViewDto getFirmById(Long id);
    FirmViewDto getFirmByName(String firmName);
    FirmViewDto createFirm(FirmDto firmDto);
    FirmViewDto updateFirm(Long id, FirmDto firmDto);
    void deleteFirm(Long id);



    List<VehicleViewDto> getAllVehicles();
    VehicleViewDto getVehicleById(Long id);
    VehicleViewDto createVehicle(VehicleDto vehicleDto);
    VehicleViewDto updateVehicle(Long id, VehicleDto vehicleDto);
    void deleteVehicle(Long id);




    List<ReservationViewDto> getAllReservations();
    List<ReservationViewDto> getAllReservationsByClientUserId(Long id);
    List<ReservationViewDto> getAllReservationsByVehicleInFirmId(Long id);
    ReservationViewDto getReservationById(Long id);
    ReservationViewDto getReservationByClientUserIdAndVehicleInFirmId(Long clientUserId, Long vehicleInFirmId);
    ReservationViewDto createReservation(ReservationDto reservationDto);
    ReservationViewDto updateReservation(Long id, ReservationDto reservationDto);
    ReservationViewDto updateReservationByClientUserIdAndVehicleInFirmId(Long clientUserId, Long vehicleInFirmId, ReservationDto reservationDto);
    void deleteReservation(Long id);
    void deleteReservationByClientUserIdAndVehicleInFirmId(Long clientUserId, Long vehicleInFirmId);



    List<VehicleInFirmViewDto> getAllVehiclesInFirmWithFirmId(Long firmId);
    VehicleInFirmViewDto getVehicleInFirmByIdWithFirmId(Long firmId, Long vehicleInFirmId);
    VehicleInFirmViewDto createVehicleInFirmWithFirmId(Long firmId, VehicleInFirmDto vehicleInFirmDto);
    VehicleInFirmViewDto updateVehicleInFirmWithFirmId(Long firmId, Long vehicleInFirmId, VehicleInFirmDto vehicleInFirmDto);
    void deleteVehicleInFirmWithFirmId(Long firmId, Long vehicleInFirmId);




    List<VehicleModelViewDto> getAllVehicleModels();
    VehicleModelViewDto getVehicleModelById(Long id);
    VehicleModelViewDto createVehicleModel(VehicleModelDto vehicleModelDto);
    VehicleModelViewDto updateVehicleModel(Long id, VehicleModelDto vehicleModelDto);
    void deleteVehicleModel(Long id);




    List<VehicleTypeViewDto> getAllVehicleTypes();
    VehicleTypeViewDto getVehicleTypeById(Long id);
    VehicleTypeViewDto createVehicleType(VehicleTypeDto vehicleTypeDto);
    VehicleTypeViewDto updateVehicleType(Long id, VehicleTypeDto vehicleTypeDto);
    void deleteVehicleType(Long id);






    List<ReviewViewDto> getAllReviews();
    List<ReviewViewDto> getAllReviewsByClientUserId(Long id);
    List<ReviewViewDto> getAllReviewsByFirmId(Long id);
    ReviewViewDto getReviewById(Long id);
    ReviewViewDto getReviewByClientUserIdAndFirmId(Long clientUserId, Long firmId);
    ReviewViewDto createReview(ReviewDto reviewDto);
    ReviewViewDto updateReview(Long id, ReviewDto reviewDto);
    ReviewViewDto updateReviewByClientUserIdAndFirmId(Long clientUserId, Long firmId, ReviewDto reviewDto);
    void deleteReview(Long id);
    void deleteReviewByClientUserIdAndFirmId(Long clientUserId, Long firmId);
}
