package in.krishak.agro.RMS.service;

import in.krishak.agro.RMS.daos.CowDetailRepository;
import in.krishak.agro.RMS.models.CattleDetailDTO;
import in.krishak.agro.RMS.models.User;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CattleService {

    @Autowired
    private CowDetailRepository cowDetailRepository;

    @Autowired
    private UserService userService;

    public void persistCowDetails(String userId, @Valid CattleDetailDTO cattleDetailDTO) throws Exception {
        try {
            User user = userService.fetchUserDetailByExternalId(userId);
            cattleDetailDTO.setUserId(user.getId().toString());
            cowDetailRepository.save(cattleDetailDTO);
        } catch (Exception e) {
            log.info("Error Persisting cow detail");
            throw new RuntimeException("Not able save cattle detail");
        }
    }

    public List<CattleDetailDTO> fetchCattleDetail(String userId) throws Exception {
        try {
            User user = userService.fetchUserDetailByExternalId(userId);
            return cowDetailRepository.findByUserId(user.getId().toString());
        } catch (Exception e) {
            log.info("Error fetching cattle detail");
            throw new RuntimeException("Error fetching cattle detail");
        }
    }

}
