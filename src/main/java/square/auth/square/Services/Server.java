package square.auth.square.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Server {
    Logger logger = LoggerFactory.getLogger(Server.class);
//    @RequestMapping(method = RequestMethod.GET, value = "/callback")
//    public String getAllTopics() {
//        System.out.println("callback was called");
//        return "tr.returnResult().toString()";
//    }
//    @RequestMapping(method = RequestMethod.GET, value = "/callback")
//    public ResponseEntity<String> getHeader(@RequestHeader("User-Agent") String userAgent) {
//        // Construct response
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Access-Control-Allow-Origin", "*");
//        headers.add("Content-Type", "application/json");
//        headers.add("Content-Type", "application/json");
//
//        String response = "Header:\nUser-Agent: " + userAgent;
//        logger.info(response);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .headers(headers)
//                .body(response);
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/callback")
    public ResponseEntity<String> getCode(@RequestParam("code") String code, @RequestParam("response_type") String responseType){
        // Construct response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Content-Type", "application/json");

        String response = "Code: " + code +"\nResponse Type: " + responseType;
        logger.info(response);
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(response);
    }
}
