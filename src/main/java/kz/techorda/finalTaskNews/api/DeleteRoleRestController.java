package kz.techorda.finalTaskNews.api;

import kz.techorda.finalTaskNews.dto.UserDTO;
import kz.techorda.finalTaskNews.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/delete_role")
@RequiredArgsConstructor
public class DeleteRoleRestController {

    private final UserService userService;

    @PutMapping
    public UserDTO deletePermissions(@RequestBody UserDTO userDTO){
        return userService.deletePermissions(userDTO);
    }

}