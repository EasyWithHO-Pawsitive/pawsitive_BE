package pawsitive.pawsitive_BE.service.user;

import pawsitive.pawsitive_BE.web.dto.user.SignupRequestDTO;
import pawsitive.pawsitive_BE.web.dto.user.UserResponse;

public interface UserService {
    UserResponse.LoginResultDTO login(String username, String password);
    UserResponse.LoginResultDTO signup(SignupRequestDTO signupRequestDTO);

}
