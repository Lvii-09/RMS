
package in.krishak.agro.RMS.mapper;


import in.krishak.agro.RMS.dto.UserDailyRecordDTO;
import in.krishak.agro.RMS.models.DailyRecord;


public class UserDailyStatRecordMapper {

    public static UserDailyRecordDTO toDTO(DailyRecord entity) {
        UserDailyRecordDTO dto = new UserDailyRecordDTO();
        dto.setDryBait(entity.getDryBait());
        dto.setGreenBait(entity.getGreenBait());
        dto.setKhal(entity.getKhal());
        dto.setChuri(entity.getChuri());
        dto.setRest(entity.getRest());
        dto.setKrishakFeed(entity.getKrishakFeed());
        dto.setMilk(entity.getMilk());
        dto.setFat(entity.getFat());
        dto.setSnf(entity.getSnf());
        dto.setGobar(entity.getGobar());
        dto.setComment(entity.getComment());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setDate(entity.getDate());
        return dto;
    }

    public static DailyRecord toEntity(UserDailyRecordDTO dto) {
        DailyRecord entity = new DailyRecord();
        entity.setUserId(dto.getUserId().intValue());
        entity.setDryBait(dto.getDryBait());
        entity.setGreenBait(dto.getGreenBait());
        entity.setKhal(dto.getKhal());
        entity.setChuri(dto.getChuri());
        entity.setRest(dto.getRest());
        entity.setKrishakFeed(dto.getKrishakFeed());
        entity.setMilk(dto.getMilk());
        entity.setFat(dto.getFat());
        entity.setSnf(dto.getSnf());
        entity.setGobar(dto.getGobar());
        entity.setComment(dto.getComment());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setDate(dto.getDate());
        entity.setCattleId(dto.getCattleId());
        return entity;
    }
}
