package unibe.edu.ec.matricula.resources;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class PrerequirementResourceTest {


    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Autowired
    private RestService restService;

    @Test
    public void listPrerequirementForSubject() {
        String json= restService.restBuilder(new RestBuilder<String>())
                .clazz(String.class).path(PrerequirementResource.PREREQUIREMENT)
                .path(PrerequirementResource.ID).expand(1).get().build();
        System.out.println("---------->"+json);
    }
}
