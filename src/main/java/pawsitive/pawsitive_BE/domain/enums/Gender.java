package pawsitive.pawsitive_BE.domain.enums;

public enum Gender {
    MALE("수컷"), FEMALE("암컷");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
