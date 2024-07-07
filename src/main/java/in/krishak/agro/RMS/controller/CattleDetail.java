package in.krishak.agro.RMS.controller;

import in.krishak.agro.RMS.models.CattleDetailDTO;
import in.krishak.agro.RMS.service.CattleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CattleDetail {

    @Autowired
    private CattleService cattleService;

    @PostMapping("/info/cattle")
    public ResponseEntity<Void> persistCattleDetail(
            @RequestHeader("X-User-Id") String userId,
            @RequestBody CattleDetailDTO cattleDetailDTO) throws Exception {
        cattleService.persistCowDetails(userId, cattleDetailDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/info/cattle")
    public ResponseEntity<List<CattleDetailDTO>> fetchCattleInfo(@RequestParam String userId) throws Exception {
        List<CattleDetailDTO> cattleDetailDTOList = cattleService.fetchCattleDetail(userId);
        return new ResponseEntity<>(cattleDetailDTOList, HttpStatus.OK);

    }
}
