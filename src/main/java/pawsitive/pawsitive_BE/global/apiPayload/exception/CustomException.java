package pawsitive.pawsitive_BE.global.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pawsitive.pawsitive_BE.global.apiPayload.code.ErrorCode;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}