package in.krishak.agro.RMS.controller;

import in.krishak.agro.RMS.dto.PaginatedResponseDTO;
import in.krishak.agro.RMS.dto.UserDailyRecordDTO;
import in.krishak.agro.RMS.dto.UserStatRequestDTO;
import in.krishak.agro.RMS.mapper.UserDailyStatRecordMapper;
import in.krishak.agro.RMS.models.DailyRecord;
import in.krishak.agro.RMS.service.DailyStatService;
import jakarta.validation.Valid;
import jakarta.ws.rs.QueryParam;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stat/daily")
public class DailyStat {

    @Autowired
    private DailyStatService dailyStatService;

    @GetMapping("/fetch")
    public ResponseEntity<PaginatedResponseDTO<DailyRecord>> fetchDailyStat(
            @RequestHeader(name = "USER_EXTERNAL_ID") @NonNull String userExternalId,
        @QueryParam("CATTLE_ID") Long cattleId) {

        PaginatedResponseDTO<DailyRecord> responseDTO = dailyStatService.fetchStatDetail(userExternalId, cattleId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> persistDailyStat(
            @RequestHeader(name = "USER_EXTERNAL_ID") @NonNull String userExternalId,
            @QueryParam("CATTLE_ID") Long cattleId,
            @RequestBody @Valid UserDailyRecordDTO userDailyRecordDTO) {

        dailyStatService.persistDailyStatDetail(userExternalId, cattleId, userDailyRecordDTO);
        DailyRecord dailyStat = UserDailyStatRecordMapper.toEntity(userDailyRecordDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


