package square.auth.square.Services;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Server {
    @RequestMapping("/callback")
    public String getAllTopics() {
        System.out.println("callback was called");
        return "tr.returnResult().toString()";
    }

    @RequestMapping("/callback")
    public String getAllTopics2(@RequestBody String payload) {
        System.out.println("callback was called");
        return "return with param" + payload;
    }
}
