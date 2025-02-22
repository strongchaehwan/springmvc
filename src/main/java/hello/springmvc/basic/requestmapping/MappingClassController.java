package hello.springmvc.basic.requestmapping;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {


    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    @GetMapping("{userId}")
    public String findUser(@PathVariable(name = "userId") String id) {
        return "get userId=" + id;
    }

    @PatchMapping("{userId}")
    public String updateUser(@PathVariable(name = "userId") String id) {
        return "update userId=" + id;
    }

    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable(name = "userId") String id) {
        return "delete userId=" + id;
    }
}
