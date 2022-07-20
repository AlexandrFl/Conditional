package as.florenko.conditional;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConditionalApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @Container
    public static final GenericContainer<?> devProf = new GenericContainer<>("devapp").withExposedPorts(8080);
    @Container
    public static final GenericContainer<?> prodProf = new GenericContainer<>("prodapp").withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        devProf.start();
        prodProf.start();
    }

    @Test
    void devProfileTest() {
        String responseBodyDev = restTemplate.getForObject("http://localhost:" + devProf.getMappedPort(8080) + "/profile", String.class);
        Assertions.assertEquals("Current profile is dev", responseBodyDev);
    }

    @Test
    void productionProfileTest() {
        String responseBodyProd = restTemplate.getForObject("http://localhost:" + prodProf.getMappedPort(8081) + "/profile", String.class);
        Assertions.assertEquals("Current profile is production", responseBodyProd);
    }
}
