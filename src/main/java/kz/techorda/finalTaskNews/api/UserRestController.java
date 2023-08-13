package kz.techorda.finalTaskNews.api;

import kz.techorda.finalTaskNews.dto.UserDTO;
import kz.techorda.finalTaskNews.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;



    @GetMapping(value = "{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long id){
        return userService.getUser(id);
    }


    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }


    @PutMapping
    public UserDTO changeDeleteApplication(@RequestBody UserDTO userDTO){
        return userService.changeDeleteApplication(userDTO);
    }



    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
    }






}
