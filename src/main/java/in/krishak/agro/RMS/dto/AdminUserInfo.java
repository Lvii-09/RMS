package in.krishak.agro.RMS.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AdminUserInfo {

    @Valid
    @NonNull
    @JsonProperty("phone_number")
    private String phoneNumber;

    private String password;

    @JsonProperty("confirm_password")
    private String confirmPassword;
}
