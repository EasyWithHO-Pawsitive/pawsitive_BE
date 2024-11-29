package pawsitive.pawsitive_BE.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pawsitive.pawsitive_BE.global.apiPayload.Response;
import pawsitive.pawsitive_BE.service.ApplicationService;
import pawsitive.pawsitive_BE.web.dto.adoption.ApplicationRequestDTO;
import pawsitive.pawsitive_BE.web.dto.application.ApplicationResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping
    @Operation(summary = "봉사 신청 API", description = "봉사를 신청 합니다.")
    public Response<ApplicationResponse.ApplicationResponseDto> addApplication(@RequestBody ApplicationRequestDTO application) {
        ApplicationResponse.ApplicationResponseDto result = applicationService.addApplication(application);
        return Response.success(result);
    }
}
