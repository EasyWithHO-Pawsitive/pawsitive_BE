package pawsitive.pawsitive_BE.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pawsitive.pawsitive_BE.domain.User;
import pawsitive.pawsitive_BE.global.apiPayload.code.ErrorCode;
import pawsitive.pawsitive_BE.global.apiPayload.exception.UserException;
import pawsitive.pawsitive_BE.repository.UserRepository;
import pawsitive.pawsitive_BE.web.dto.user.SignupRequestDTO;
import pawsitive.pawsitive_BE.web.dto.user.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse.LoginResultDTO login(String id, String password) {
        if (id == null || id.isEmpty() || password == null || password.isEmpty()) {
            throw new UserException(ErrorCode.INVALID_INPUT);
        }

        User user = userRepository.findByUserId(id)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));

        System.out.println("입력된 비밀번호: " + password);
        System.out.println("저장된 비밀번호: " + user.getPassword());

        if (!password.equals(user.getPassword())) {
            throw new UserException(ErrorCode.INVALID_PASSWORD);
        }

        return UserResponse.LoginResultDTO.builder()
                .id(user.getId())
                .build();
    }

    @Override
    public UserResponse.LoginResultDTO signup(SignupRequestDTO signupRequestDTO) {
        // 사용자가 입력한 ID로 이미 존재하는 사용자 확인
        if (userRepository.findByUserId(signupRequestDTO.getId()).isPresent()) {
            throw new UserException(ErrorCode.USER_ALREADY_EXISTS);
        }

        // 새 사용자 객체 생성 (set 메서드 대신 생성자 사용)
        User newUser = new User(
                signupRequestDTO.getId(),
                signupRequestDTO.getPassword(),
                signupRequestDTO.getName(),
                signupRequestDTO.getBirth(),
                signupRequestDTO.getPhone()
        );

        // 사용자 저장
        userRepository.save(newUser);

        // 회원가입 성공 응답 반환
        return UserResponse.LoginResultDTO.builder()
                .id(newUser.getId())
                .build();
    }
}
