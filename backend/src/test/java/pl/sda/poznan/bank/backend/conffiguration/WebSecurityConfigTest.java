package pl.sda.poznan.bank.backend.conffiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class WebSecurityConfigTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testSecurityLoginSuccess() throws Exception {
        mockMvc.perform(post("/login")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .contentType("application/x-www-form-urlencoded")
                .param("username", "user")
                .param("password", "password"))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void testSecurityLoginFail() throws Exception {
        mockMvc.perform(post("/login")
                .param("username", "fail")
                .param("password", "fail"))
                .andExpect(status().is4xxClientError());
    }
}





