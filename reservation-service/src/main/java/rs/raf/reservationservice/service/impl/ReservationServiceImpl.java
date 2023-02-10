package rs.raf.reservationservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.raf.core.dto.reservationservice.base.*;
import rs.raf.core.dto.reservationservice.view.*;
import rs.raf.reservationservice.domain.*;
import rs.raf.reservationservice.mapper.*;
import rs.raf.reservationservice.repository.*;
import rs.raf.reservationservice.service.ReservationService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private FirmRepository firmRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleInFirmRepository vehicleInFirmRepository;
    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private FirmMapper firmMapper;
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private VehicleInFirmMapper vehicleInFirmMapper;
    @Autowired
    private VehicleModelMapper vehicleModelMapper;
    @Autowired
    private VehicleTypeMapper vehicleTypeMapper;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewMapper reviewMapper;


    @Override
    public List<FirmViewDto> getAllFirms() {
        List<FirmViewDto> firmViewDtoList = new ArrayList<>();
        List<Firm> firmList = firmRepository.findAll();
        for(Firm firm : firmList){
            firmViewDtoList.add(firmMapper.firmToFirmViewDto(firm));
        }
        return firmViewDtoList;
    }

    @Override
    public FirmViewDto getFirmById(Long id) {
        FirmViewDto firmViewDto = null;
        Optional<Firm> optionalFirm = firmRepository.findById(id);
        if(optionalFirm.isPresent()){
            firmViewDto = firmMapper.firmToFirmViewDto(optionalFirm.get());
        }
        return firmViewDto;
    }

    @Override
    public FirmViewDto getFirmByName(String firmName) {
        return firmMapper.firmToFirmViewDto(firmRepository.findFirmByFirm_name(firmName));
    }

    @Override
    public FirmViewDto createFirm(FirmDto firmDto) {
        return firmMapper.firmToFirmViewDto(firmRepository.save(firmMapper.firmDtoToFirm(firmDto)));
    }

    @Override
    public FirmViewDto updateFirm(Long id, FirmDto firmDto) {
        FirmViewDto firmViewDto = null;
        Optional<Firm> optionalFirm = firmRepository.findById(id);
        if(optionalFirm.isPresent()){
            Firm firm = optionalFirm.get();
            if(firmDto.getFirm_name() != null){
                firm.setFirm_name(firmDto.getFirm_name());
            }
            if(firmDto.getDescription() != null){
                firm.setDescription(firmDto.getDescription());
            }
            if(firmDto.getNumber_of_vehicles() != null){
                firm.setNumber_of_vehicles(firmDto.getNumber_of_vehicles());
            }
            firmRepository.save(firm);
            firmViewDto = firmMapper.firmToFirmViewDto(firm);
        }
        return firmViewDto;
    }

    @Override
    public void deleteFirm(Long id) {
        firmRepository.deleteById(id);
    }


    @Override
    public List<VehicleViewDto> getAllVehicles() {
        return null;
    }

    @Override
    public VehicleViewDto getVehicleById(Long id) {
        return null;
    }

    @Override
    public VehicleViewDto createVehicle(VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public VehicleViewDto updateVehicle(Long id, VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public void deleteVehicle(Long id) {

    }


    @Override
    public List<ReservationViewDto> getAllReservations() {
        List<ReservationViewDto> reservationViewDtoList = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findAll();
        for(Reservation reservation : reservationList){
            reservationViewDtoList.add(reservationMapper.reservationToReservationViewDto(reservation));
        }
        return reservationViewDtoList;
    }

    @Override
    public List<ReservationViewDto> getAllReservationsByClientUserId(Long id) {
        List<ReservationViewDto> reservationViewDtoList = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findAllByClient_user_id(id);
        for(Reservation reservation : reservationList){
            reservationViewDtoList.add(reservationMapper.reservationToReservationViewDto(reservation));
        }
        return reservationViewDtoList;
    }

    @Override
    public List<ReservationViewDto> getAllReservationsByVehicleInFirmId(Long id) {
        List<ReservationViewDto> reservationViewDtoList = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findAllByVehicle_in_firmId(id);
        for(Reservation reservation : reservationList){
            reservationViewDtoList.add(reservationMapper.reservationToReservationViewDto(reservation));
        }
        return reservationViewDtoList;
    }

    @Override
    public ReservationViewDto getReservationById(Long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if(optionalReservation.isPresent()){
            Reservation reservation = optionalReservation.get();
            return reservationMapper.reservationToReservationViewDto(reservation);
        }
        return null;
    }

    @Override
    public ReservationViewDto getReservationByClientUserIdAndVehicleInFirmId(Long clientUserId, Long vehicleInFirmId) {
        return reservationMapper.reservationToReservationViewDto(reservationRepository.findByClient_user_idAndVehicle_in_firmId(clientUserId, vehicleInFirmId));

    }

    @Override
    public ReservationViewDto createReservation(ReservationDto reservationDto) {
        return reservationMapper.reservationToReservationViewDto(reservationRepository.save(reservationMapper.reservationDtoToReservation(reservationDto)));
    }

    @Override
    public ReservationViewDto updateReservation(Long id, ReservationDto reservationDto) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        Optional<VehicleInFirm> optionalVehicleInFirm = vehicleInFirmRepository.findById(reservationDto.getVehicle_in_firm_id());
        if(optionalReservation.isPresent() && optionalVehicleInFirm.isPresent()){
            Reservation reservation = optionalReservation.get();
            VehicleInFirm vehicleInFirm = optionalVehicleInFirm.get();

            if(reservationDto.getId() != null){
                reservation.setId(reservationDto.getId());
            }
            if(reservationDto.getClient_user_id() != null){
                reservation.setClient_user_id(reservationDto.getClient_user_id());
            }
            if(reservationDto.getVehicle_in_firm_id() != null){
                reservation.setVehicle_in_firm(vehicleInFirm);
            }
            if(reservationDto.getStart_date() != null){
                reservation.setStart_date(reservationDto.getStart_date());
            }
            if(reservationDto.getEnd_date() != null){
                reservation.setEnd_date(reservationDto.getEnd_date());
            }
            return reservationMapper.reservationToReservationViewDto(reservationRepository.save(reservation));
        }
        return null;
    }

    @Override
    public ReservationViewDto updateReservationByClientUserIdAndVehicleInFirmId(Long clientUserId, Long vehicleInFirmId, ReservationDto reservationDto) {
        Reservation reservation= reservationRepository.findByClient_user_idAndVehicle_in_firmId(clientUserId, vehicleInFirmId);
        Optional<VehicleInFirm> optionalVehicleInFirm = vehicleInFirmRepository.findById(reservationDto.getVehicle_in_firm_id());
        if(optionalVehicleInFirm.isPresent()){
            VehicleInFirm vehicleInFirm = optionalVehicleInFirm.get();
            if(reservationDto.getId() != null){
                reservation.setId(reservationDto.getId());
            }
            if(reservationDto.getClient_user_id() != null){
                reservation.setClient_user_id(reservationDto.getClient_user_id());
            }
            if(reservationDto.getVehicle_in_firm_id() != null){
                reservation.setVehicle_in_firm(vehicleInFirm);
            }
            if(reservationDto.getStart_date() != null){
                reservation.setStart_date(reservationDto.getStart_date());
            }
            if(reservationDto.getEnd_date() != null){
                reservation.setEnd_date(reservationDto.getEnd_date());
            }
            return reservationMapper.reservationToReservationViewDto(reservationRepository.save(reservation));
        }
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void deleteReservationByClientUserIdAndVehicleInFirmId(Long clientUserId, Long vehicleInFirmId) {
        reservationRepository.deleteByClient_user_idAndVehicle_in_firmId(clientUserId, clientUserId);
    }

    @Override
    public List<VehicleInFirmViewDto> getAllVehiclesInFirmWithFirmId(Long firmId) {
        return null;
    }

    @Override
    public VehicleInFirmViewDto getVehicleInFirmByIdWithFirmId(Long firmId, Long vehicleInFirmId) {
        return null;
    }

    @Override
    public VehicleInFirmViewDto createVehicleInFirmWithFirmId(Long firmId, VehicleInFirmDto vehicleInFirmDto) {
        return null;
    }

    @Override
    public VehicleInFirmViewDto updateVehicleInFirmWithFirmId(Long firmId, Long vehicleInFirmId, VehicleInFirmDto vehicleInFirmDto) {
        return null;
    }

    @Override
    public void deleteVehicleInFirmWithFirmId(Long firmId, Long vehicleInFirmId) {

    }


    @Override
    public List<VehicleModelViewDto> getAllVehicleModels() {
        return null;
    }

    @Override
    public VehicleModelViewDto getVehicleModelById(Long id) {
        return null;
    }

    @Override
    public VehicleModelViewDto createVehicleModel(VehicleModelDto vehicleModelDto) {
        return null;
    }

    @Override
    public VehicleModelViewDto updateVehicleModel(Long id, VehicleModelDto vehicleModelDto) {
        return null;
    }

    @Override
    public void deleteVehicleModel(Long id) {

    }


    @Override
    public List<VehicleTypeViewDto> getAllVehicleTypes() {
        return null;
    }

    @Override
    public VehicleTypeViewDto getVehicleTypeById(Long id) {
        return null;
    }

    @Override
    public VehicleTypeViewDto createVehicleType(VehicleTypeDto vehicleTypeDto) {
        return null;
    }

    @Override
    public VehicleTypeViewDto updateVehicleType(Long id, VehicleTypeDto vehicleTypeDto) {
        return null;
    }

    @Override
    public void deleteVehicleType(Long id) {

    }


    @Override
    public List<ReviewViewDto> getAllReviews() {
        List<Review> reviewList = reviewRepository.findAll();
        List<ReviewViewDto> reviewViewDtoList = new ArrayList<>();
        for(Review review : reviewList){
            reviewViewDtoList.add(reviewMapper.reviewToReviewViewDto(review));
        }
        return reviewViewDtoList;
    }

    @Override
    public List<ReviewViewDto> getAllReviewsByClientUserId(Long id) {
        List<Review> reviewList = reviewRepository.findAllByClient_user_id(id);
        List<ReviewViewDto> reviewViewDtoList = new ArrayList<>();
        for(Review review : reviewList){
            reviewViewDtoList.add(reviewMapper.reviewToReviewViewDto(review));
        }
        return reviewViewDtoList;
    }

    @Override
    public List<ReviewViewDto> getAllReviewsByFirmId(Long id) {
        List<Review> reviewList = reviewRepository.findAllByFirmId(id);
        List<ReviewViewDto> reviewViewDtoList = new ArrayList<>();
        for(Review review : reviewList){
            reviewViewDtoList.add(reviewMapper.reviewToReviewViewDto(review));
        }
        return reviewViewDtoList;
    }

    @Override
    public ReviewViewDto getReviewById(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent()){
            Review review = optionalReview.get();
            return reviewMapper.reviewToReviewViewDto(review);
        }
        return null;
    }

    @Override
    public ReviewViewDto getReviewByClientUserIdAndFirmId(Long clientUserId, Long firmId) {
        return reviewMapper.reviewToReviewViewDto(reviewRepository.findByClient_user_idAndFirmId(clientUserId, firmId));
    }

    @Override
    public ReviewViewDto createReview(ReviewDto reviewDto) {
        return reviewMapper.reviewToReviewViewDto(reviewRepository.save(reviewMapper.reviewDtoToReview(reviewDto)));
    }

    @Override
    public ReviewViewDto updateReview(Long id, ReviewDto reviewDto) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        Optional<Firm> optionalFirm = firmRepository.findById(reviewDto.getFirm_id());
        if(optionalReview.isPresent() && optionalFirm.isPresent()){
            Review review = optionalReview.get();
            Firm firm = optionalFirm.get();
            if(reviewDto.getClient_user_id() != null){
                review.setClient_user_id(reviewDto.getClient_user_id());
            }
            if(reviewDto.getFirm_id() != null){
                review.setFirm(firm);
            }
            if(reviewDto.getText() != null){
                review.setText(reviewDto.getText());
            }
            if(reviewDto.getGrade() != null){
                review.setGrade(reviewDto.getGrade());
            }
            return reviewMapper.reviewToReviewViewDto(reviewRepository.save(review));
        }
        return null;
    }

    @Override
    public ReviewViewDto updateReviewByClientUserIdAndFirmId(Long clientUserId, Long firmId, ReviewDto reviewDto) {
        Review review = reviewRepository.findByClient_user_idAndFirmId(clientUserId, firmId);
        Optional<Firm> optionalFirm = firmRepository.findById(reviewDto.getFirm_id());
        if(review != null && optionalFirm.isPresent()){
            Firm firm = optionalFirm.get();
            if(reviewDto.getClient_user_id() != null){
                review.setClient_user_id(reviewDto.getClient_user_id());
            }
            if(reviewDto.getFirm_id() != null){
                review.setFirm(firm);
            }
            if(reviewDto.getText() != null){
                review.setText(reviewDto.getText());
            }
            if(reviewDto.getGrade() != null){
                review.setGrade(reviewDto.getGrade());
            }
            return reviewMapper.reviewToReviewViewDto(reviewRepository.save(review));
        }
        return null;
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public void deleteReviewByClientUserIdAndFirmId(Long clientUserId, Long firmId) {
        reviewRepository.deleteByClient_user_idAndFirmId(clientUserId, firmId);
    }
}
