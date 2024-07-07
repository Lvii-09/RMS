package in.krishak.agro.RMS.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserInfo {

    @Valid
    @NonNull
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Valid
    @NonNull
    private String name;

    private String status;

    private String address;

    private String externalId;

}
