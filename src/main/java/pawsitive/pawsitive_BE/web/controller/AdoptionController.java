package pawsitive.pawsitive_BE.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pawsitive.pawsitive_BE.global.apiPayload.Response;
import pawsitive.pawsitive_BE.service.AdoptionService;
import pawsitive.pawsitive_BE.web.dto.adoption.AdoptionResponse;
import pawsitive.pawsitive_BE.web.dto.volunteer.VolunteerResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adoption")
public class AdoptionController {
    private final AdoptionService adoptionService;

    @GetMapping
    @Operation(summary = "입양 홍보 게시판 리스트 조회 API", description = "입양 홍보 리스트를 조회 합니다.")
    public Response<AdoptionResponse.AdoptionListResultDTO> adoptionList() {
        AdoptionResponse.AdoptionListResultDTO result = adoptionService.adoptionList();
        return Response.success(result);
    }

    @GetMapping("/{postId}")
    @Operation(summary = "입양 홍보 게시판 상세 게시글 조회 API", description = "입양 홍보 상세 게시글을 조회 합니다.")
    public Response<AdoptionResponse.AdoptionDetailResultDTO> adoptionDetail(@PathVariable Integer postId) {
        AdoptionResponse.AdoptionDetailResultDTO result = adoptionService.adoptionDetail(postId);
        return Response.success(result);
    }
}
