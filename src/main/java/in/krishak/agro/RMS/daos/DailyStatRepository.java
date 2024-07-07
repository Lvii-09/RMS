package in.krishak.agro.RMS.daos;

import in.krishak.agro.RMS.models.DailyRecord;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyStatRepository extends JpaRepository<DailyRecord, Long> {

    Optional<List<DailyRecord>> findByUserIdAndCattleId(Integer userId, Long cattleId);
}
