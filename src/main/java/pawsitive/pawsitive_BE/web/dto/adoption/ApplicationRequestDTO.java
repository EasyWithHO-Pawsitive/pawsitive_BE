package pawsitive.pawsitive_BE.web.dto.adoption;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestDTO {
    @NotNull(message = "ID는 필수입니다.")
    private Integer id;

    @NotNull(message = "게시글ID는 필수입니다.")
    private Integer postId;
}
