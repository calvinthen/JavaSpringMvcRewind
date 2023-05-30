package calvinthen.testspringmvc.Controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void invalidRequestFormHello() throws Exception {
        mockMvc.perform(
                post("/form/hello")
                        .param("name", "calvin")
        ).andExpect(status().isUnsupportedMediaType());
    }

    @Test
    void validRequestFormHello() throws Exception {
        mockMvc.perform(
                        post("/form/hello")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("name", "calvin")
                ).andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE,Matchers.containsString(MediaType.TEXT_HTML_VALUE)))
                .andExpect(content().string(Matchers.containsString("Hello calvin")));
    }



}