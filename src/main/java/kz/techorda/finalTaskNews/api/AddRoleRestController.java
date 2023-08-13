package kz.techorda.finalTaskNews.api;

import kz.techorda.finalTaskNews.dto.UserDTO;
import kz.techorda.finalTaskNews.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "add_role")
@RequiredArgsConstructor
public class AddRoleRestController {

    private  final UserService userService;

    @PutMapping
    public UserDTO addPermissions(@RequestBody UserDTO userDTO){
        return userService.addPermissions(userDTO);
    }
}
