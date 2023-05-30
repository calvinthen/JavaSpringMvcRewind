package calvinthen.testspringmvc.Controller;

import calvinthen.testspringmvc.Service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.io.IOException;

@Controller
public class HelloController {


    @Autowired
    private HelloService helloService;
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public void helloWorld(@RequestParam(name = "name",required = false)
                               String name, HttpServletResponse response) throws IOException{
        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }
}
