package boot.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import boot.helloboot.HelloRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    HelloRepository helloRepository;

//    @BeforeEach
//    void init() {
//        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
//    }
    @Test
    void findHelloFailed() {
        Assertions.assertThat(helloRepository.findHello("Spring")).isNull();
    }

    @Test
    void increaseCount() {
        Assertions.assertThat(helloRepository.countOf("Spring")).isEqualTo(0);

        helloRepository.increaseCount("Spring");
        Assertions.assertThat(helloRepository.countOf("Spring")).isEqualTo(1);

        helloRepository.increaseCount("Spring");
        Assertions.assertThat(helloRepository.countOf("Spring")).isEqualTo(2);
    }
}
