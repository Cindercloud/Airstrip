package cloud.cinder.airstrip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Airstrip.class)
public class AirstripIT {

    @Autowired
    private Environment env;

    @Test
    public void airstripCorrectlyStarts() throws Exception {
        assertThat(env.getProperty("spring.application.name")).isEqualTo("airstrip");
    }
}
