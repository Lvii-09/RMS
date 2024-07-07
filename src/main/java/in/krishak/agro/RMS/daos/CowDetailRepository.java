package in.krishak.agro.RMS.daos;

import in.krishak.agro.RMS.models.CattleDetailDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CowDetailRepository extends JpaRepository<CattleDetailDTO, Long> {

    List<CattleDetailDTO> findByUserId(String userId);
}
