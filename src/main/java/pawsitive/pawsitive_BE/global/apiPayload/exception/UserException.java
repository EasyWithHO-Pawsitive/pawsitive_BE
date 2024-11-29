package pawsitive.pawsitive_BE.global.apiPayload.exception;

import pawsitive.pawsitive_BE.global.apiPayload.code.ErrorCode;

public class UserException extends CustomException {
    public UserException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
