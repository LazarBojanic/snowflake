package rs.raf.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.raf.userservice.domain.ClientUser;
import rs.raf.userservice.domain.Rank;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    Rank findRankById(Integer id);
    Rank findRankByRank(String rank);
}