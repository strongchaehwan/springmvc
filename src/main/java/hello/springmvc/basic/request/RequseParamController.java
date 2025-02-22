package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@Slf4j
public class RequseParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={},age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody //@Restcontroller 같은 역할
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam(name = "username") String username, @RequestParam(name = "age") int age) {
        log.info("username={},age={}", username, age);

        return "ok"; //ResponseBody 임으로 HTTP 메세지 바디에 바로 적용
    }


    // required = ture 무조건 들어와야됌 필수로 들어와야댐 true가 기본값
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "age", required = true) int age) {
        log.info("username={},age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(name = "username", required = true, defaultValue = "guest") String username,
                                      @RequestParam(name = "age", required = false, defaultValue = "1") int age) {
        log.info("username={},age={}", username, age);

        return "ok";
    }

    /**
     * @RequestParam Map, MultiValueMap
     * Map(key=value)
     * MultiValueMap(key=[value1, value2, ...])    ex) (key=userIds, value=[id1, id2])
     * 보통은 하나만 씀
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@RequestParam(name = "username") String username, @RequestParam(name = "age") int age) {
        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);

        log.info("username={},age={}", helloData.getUsername(), helloData.getAge());
        log.info("hellodata={}", helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(@ModelAttribute HelloData helloData) {
        log.info("username={},age={}", helloData.getUsername(), helloData.getAge());
        log.info("hellodata={}", helloData);

        return "ok";
    }


}
