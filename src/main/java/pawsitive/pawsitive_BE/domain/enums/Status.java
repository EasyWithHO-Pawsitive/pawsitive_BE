package pawsitive.pawsitive_BE.domain.enums;

public enum Status {
    OPEN("모집 중"),
    CLOSED("모집 종료");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
