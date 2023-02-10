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
public class RankMapper {
    @Autowired
    private ClientUserRepository clientUserRepository;
    @Autowired
    private ServiceUserMapper serviceUserMapper;
    @Autowired
    private RankRepository rankRepository;
    public Rank rankDtoToRank(RankDto rankDto){
        Rank rank = rankRepository.findRankById(rankDto.getId());
        if(rank != null){
            return Rank.builder()
                    .id(rankDto.getId())
                    .rank(rankDto.getRank())
                    .min_number_of_days(rankDto.getMin_number_of_days())
                    .max_number_of_days(rankDto.getMax_number_of_days()).build();
        }
        return null;
    }
    public RankDto rankToRankDto(Rank rank){
        return RankDto.builder()
                .id(rank.getId())
                .rank(rank.getRank())
                .min_number_of_days(rank.getMin_number_of_days())
                .max_number_of_days(rank.getMax_number_of_days()).build();
    }
}