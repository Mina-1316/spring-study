package gdsc.edu.springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 메인 클래스

/**
 * 메인 클래스. Spring 프로그램의 시작점이 됩니다.
 */
@SpringBootApplication
@EnableJpaAuditing      // JPA의 Auditing 사용 허가
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
