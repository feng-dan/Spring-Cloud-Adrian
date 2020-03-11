package kim.adrian.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdrianAuthApplicationTests {

    @Test
    public void contextLoads() {
        String password = "123456";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(password));
        System.out.println(encoder.encode(password));
    }
}
