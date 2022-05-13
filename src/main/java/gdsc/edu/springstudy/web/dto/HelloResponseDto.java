package gdsc.edu.springstudy.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor  // Final 필드를 전부 초기화하는 생성자 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
