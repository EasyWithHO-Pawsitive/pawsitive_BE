package pawsitive.pawsitive_BE.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pawsitive.pawsitive_BE.global.apiPayload.Response;
import pawsitive.pawsitive_BE.service.ShelterService;
import pawsitive.pawsitive_BE.web.dto.shelter.ShelterResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shelter")
public class ShelterController {
    private final ShelterService shelterService;

    @GetMapping
    @Operation(summary = "보호소 정보 조회 API", description = "보호소 정보 조회 합니다.")
    public Response<ShelterResponse.ShelterInfoListDTO> shelterInfoList() {
       ShelterResponse.ShelterInfoListDTO result = shelterService.shelterInfoList();
        return Response.success(result);
    }

}
