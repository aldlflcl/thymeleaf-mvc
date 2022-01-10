package hello.thymeleafmvc.domain.member;

public enum Gender {

    MALE("남성"), FEMALE("여성");

    private String description;

    public String getDescription() {
        return description;
    }

    Gender(String description) {
        this.description = description;
    }
}
