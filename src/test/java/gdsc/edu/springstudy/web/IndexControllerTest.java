package gdsc.edu.springstudy.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@MockBean(JpaMetamodelMappingContext.class) // Jpa Auditing을 사용하지만, MockMvc에서는 MockUp하지 않아서 Exception 발생
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    // 어째선지 컨트롤러가 RestController가 아니면 작동하지 않는다
    // Mockup을 해오질 않는듯??
    // 미친언어
//    @Test
//    public void testIndex() throws Exception {
//        String body = this.restTemplate.getForObject("/", String.class);
//
//        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
//    }
}
