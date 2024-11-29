package pawsitive.pawsitive_BE.web.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    @NotNull(message = "ID는 필수입니다.")
    private String id;

    @NotNull(message = "비밀번호는 필수입니다.")
    private String password;
}
