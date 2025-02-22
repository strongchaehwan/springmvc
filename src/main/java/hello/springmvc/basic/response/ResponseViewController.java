package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @GetMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView modelAndView = new ModelAndView("response/hello");
        modelAndView.addObject("data", "hello!");
        return modelAndView;
    }

    @GetMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "love!");
        return "response/hello";
    }

}
