package hello.thymeleafmvc.domain.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Member {

    private Long id;

    private String name;

    private String address;

    private Gender gender;

    private Boolean adult;

    private String hobby;

    public Member() {
    }

    public Member(String name, String address, Gender gender, Boolean adult, String hobby) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.adult = adult;
        this.hobby = hobby;
    }
}
