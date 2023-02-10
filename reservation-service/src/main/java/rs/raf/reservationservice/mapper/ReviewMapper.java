package rs.raf.reservationservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.raf.core.dto.reservationservice.base.FirmDto;
import rs.raf.core.dto.reservationservice.base.ReviewDto;
import rs.raf.core.dto.reservationservice.view.FirmViewDto;
import rs.raf.core.dto.reservationservice.view.ReviewViewDto;
import rs.raf.reservationservice.domain.*;
import rs.raf.reservationservice.repository.FirmRepository;

import java.util.Optional;

@Component
public class ReviewMapper {
    @Autowired
    FirmRepository firmRepository;
    @Autowired
    FirmMapper firmMapper;

    public ReviewDto reviewToReviewDto(Review review){
        return ReviewDto.builder()
                .id(review.getId())
                .client_user_id(review.getClient_user_id())
                .firm_id(review.getFirm().getId())
                .text(review.getText())
                .grade(review.getGrade()).build();
    }
    public ReviewViewDto reviewToReviewViewDto(Review review){
        FirmDto firmDto = firmMapper.firmToFirmDto(review.getFirm());
        return ReviewViewDto.builder()
                .id(review.getId())
                .client_user_id(review.getClient_user_id())
                .firm(firmDto)
                .text(review.getText())
                .grade(review.getGrade()).build();
    }
    public Review reviewDtoToReview(ReviewDto reviewDto){
        Optional<Firm> optionalFirm = firmRepository.findById(reviewDto.getFirm_id());
        if(optionalFirm.isPresent()){
            Firm firm = optionalFirm.get();
            return Review.builder()
                    .id(reviewDto.getId())
                    .client_user_id(reviewDto.getClient_user_id())
                    .firm(firm)
                    .text(reviewDto.getText())
                    .grade(reviewDto.getGrade()).build();
        }
        return null;
    }
    public Review reviewViewDtoToReview(ReviewViewDto reviewViewDto){
        Firm firm = firmMapper.firmDtoToFirm(reviewViewDto.getFirm());
        return Review.builder()
                .id(reviewViewDto.getId())
                .client_user_id(reviewViewDto.getClient_user_id())
                .firm(firm)
                .text(reviewViewDto.getText())
                .grade(reviewViewDto.getGrade()).build();
    }
}
