package pawsitive.pawsitive_BE.web.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDTO {
    @NotNull(message = "ID는 필수입니다.")
    private String id;

    @NotNull(message = "비밀번호는 필수입니다.")
    private String password;

    @NotNull(message = "이름은 필수입니다.")
    private String name;

    @NotNull(message = "생년월일 입력은 필수입니다.")
    private String birth;

    @NotNull(message = "전화번호 입력은 필수입니다.")
    private String phone;
}
