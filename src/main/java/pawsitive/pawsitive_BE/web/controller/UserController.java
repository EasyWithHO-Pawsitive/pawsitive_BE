package pawsitive.pawsitive_BE.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pawsitive.pawsitive_BE.global.apiPayload.Response;
import pawsitive.pawsitive_BE.service.user.UserService;
import pawsitive.pawsitive_BE.web.dto.user.LoginRequestDTO;
import pawsitive.pawsitive_BE.web.dto.user.SignupRequestDTO;
import pawsitive.pawsitive_BE.web.dto.user.UserResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/")
public class UserController {
    private final UserService userService;


    @Operation(summary = "로그인 API", description = "사용자의 ID와 비밀번호를 이용해 로그인합니다.")
    @PostMapping("login")
    public Response<UserResponse.LoginResultDTO> login(@Valid @RequestBody LoginRequestDTO loginRequest) {
        UserResponse.LoginResultDTO result = userService.login(loginRequest.getId(), loginRequest.getPassword());
        return Response.success(result);
    }

    @Operation(summary = "회원가입 API", description = "사용자 회원가입 API입니다.")
    @PostMapping("signup")
    public Response<UserResponse.LoginResultDTO> signup(@Valid @RequestBody SignupRequestDTO signupRequestDTO) {
        System.out.println("Received signup request: " + signupRequestDTO);
        UserResponse.LoginResultDTO result = userService.signup(signupRequestDTO);
        return Response.success(result);
    }
}
