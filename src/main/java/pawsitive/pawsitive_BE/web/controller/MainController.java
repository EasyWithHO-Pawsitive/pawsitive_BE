package pawsitive.pawsitive_BE.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pawsitive.pawsitive_BE.global.apiPayload.Response;
import pawsitive.pawsitive_BE.service.MainService;
import pawsitive.pawsitive_BE.web.dto.main.MainResponse;
import pawsitive.pawsitive_BE.web.dto.user.UserResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {
    private final MainService mainService;

    @GetMapping
    @Operation(summary = "홈 화면 조회 API", description = "홈 화면 조회 합니다.")
    public Response<MainResponse.MainResponseDTO> main() {
        MainResponse.MainResponseDTO result = mainService.main();
        return Response.success(result);
    }

}
