package pawsitive.pawsitive_BE.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pawsitive.pawsitive_BE.global.apiPayload.Response;
import pawsitive.pawsitive_BE.service.VolunteerService;
import pawsitive.pawsitive_BE.web.dto.main.MainResponse;
import pawsitive.pawsitive_BE.web.dto.volunteer.VolunteerPostRequestDTO;
import pawsitive.pawsitive_BE.web.dto.volunteer.VolunteerResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/volunteer")
public class VolunteerController {
    private final VolunteerService volunteerService;

    @GetMapping
    @Operation(summary = "보호소 봉사 요청 조회 API", description = "봉사 리스트를 조회 합니다.")
    public Response<VolunteerResponse.VolunteerListResultDTO> volunteerList() {
        VolunteerResponse.VolunteerListResultDTO result = volunteerService.volunteerList();
        return Response.success(result);
    }

    @GetMapping("/{postId}")
    @Operation(summary = "보호소 봉사 요청 상세 게시글 조회 API", description = "봉사 상세 게시글을 조회 합니다.")
    public Response<VolunteerResponse.VolunteerDetailResultDTO> volunteerDetail(@PathVariable Integer postId) {
        VolunteerResponse.VolunteerDetailResultDTO result = volunteerService.volunteerDetail(postId);
        return Response.success(result);
    }

    @PostMapping("/post")
    @Operation(summary = "보호소 봉사 게시글 등록 API", description = "보호소 봉사 게시글을 등록 합니다.")
    public Response<VolunteerResponse.VolunteerPostResultDTO> volunteerPost(@Valid @RequestBody VolunteerPostRequestDTO volunteerPostRequestDTO) {
        VolunteerResponse.VolunteerPostResultDTO result = volunteerService.volunteerPost(volunteerPostRequestDTO);
        return Response.success(result);
    }

}
