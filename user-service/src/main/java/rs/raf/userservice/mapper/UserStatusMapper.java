package rs.raf.userservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.raf.core.dto.userservice.base.ClientUserDto;
import rs.raf.core.dto.userservice.base.RankDto;
import rs.raf.core.dto.userservice.base.UserStatusDto;
import rs.raf.core.dto.userservice.view.UserStatusViewDto;
import rs.raf.userservice.domain.ClientUser;
import rs.raf.userservice.domain.Rank;
import rs.raf.userservice.domain.ServiceUser;
import rs.raf.userservice.domain.UserStatus;
import rs.raf.userservice.repository.ClientUserRepository;
import rs.raf.userservice.repository.RankRepository;
import rs.raf.userservice.repository.UserRepository;

import java.util.Optional;

@Component
public class UserStatusMapper {
    @Autowired
    private ClientUserRepository clientUserRepository;
    @Autowired
    private ServiceUserMapper serviceUserMapper;
    @Autowired
    private RankMapper rankMapper;
    @Autowired
    private RankRepository rankRepository;
    public UserStatus userStatusDtoToUserStatus(UserStatusDto userStatusDto){
        Optional<ClientUser> optionalClientUser = clientUserRepository.findById(userStatusDto.getClient_user_id());
        Rank rank = rankRepository.findRankById(userStatusDto.getRank_id());
        if(optionalClientUser.isPresent() && rank != null){
            ClientUser clientUser = optionalClientUser.get();
            return UserStatus.builder()
                    .id(userStatusDto.getId())
                    .client_user(clientUser)
                    .rank(rank)
                    .discount_percent(userStatusDto.getDiscount_percent())
                    .number_of_days_reserved(userStatusDto.getNumber_of_days_reserved())
                    .current_number_of_reservations(userStatusDto.getCurrent_number_of_reservations()).build();
        }
        return null;
    }
    public UserStatusDto userStatusToUserStatusDto(UserStatus userStatus){
        return UserStatusDto.builder()
                .id(userStatus.getId())
                .client_user_id(userStatus.getClient_user().getId())
                .rank_id(userStatus.getRank().getId())
                .discount_percent(userStatus.getDiscount_percent())
                .number_of_days_reserved(userStatus.getNumber_of_days_reserved())
                .current_number_of_reservations(userStatus.getCurrent_number_of_reservations()).build();
    }
    public UserStatusViewDto userStatusToUserStatusViewDto(UserStatus userStatus){
        Optional<ClientUser> optionalClientUser = clientUserRepository.findById(userStatus.getClient_user().getId());
        Rank rank = rankRepository.findRankById(userStatus.getRank().getId());
        if(optionalClientUser.isPresent() && rank != null){
            ClientUser clientUser = optionalClientUser.get();
            ClientUserDto clientUserDto = serviceUserMapper.clientUserToClientUserDto(clientUser);
            RankDto rankDto = rankMapper.rankToRankDto(rank);
            return UserStatusViewDto.builder()
                    .id(userStatus.getId())
                    .client_user(clientUserDto)
                    .rank(rankDto)
                    .discount_percent(userStatus.getDiscount_percent())
                    .number_of_days_reserved(userStatus.getNumber_of_days_reserved())
                    .current_number_of_reservations(userStatus.getCurrent_number_of_reservations()).build();
        }
        return null;
    }
}