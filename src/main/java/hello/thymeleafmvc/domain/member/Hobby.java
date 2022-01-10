package hello.thymeleafmvc.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GAME: 게임
 * SPORT: 운동
 * MOVIE: 영화
 */

@Data
@AllArgsConstructor
public class Hobby {

    private String code;

    private String displayName;

    public static List<Hobby> hobbyList() {
        List<Hobby> hobbyList = new ArrayList<>();
        hobbyList.add(new Hobby("GAME", "게임"));
        hobbyList.add(new Hobby("SPORT", "운동"));
        hobbyList.add(new Hobby("MOVIE", "영화"));
        return hobbyList;
    }
}
