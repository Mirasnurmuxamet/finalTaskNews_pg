package kz.techorda.finalTaskNews.controller;


import kz.techorda.finalTaskNews.models.User;
import kz.techorda.finalTaskNews.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @GetMapping(value = "/sign-in-page")
    public String signinPage(){
        return "signin";
    }



    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile(){
        return "profile";
    }



    @GetMapping(value = "/403_page")
    public String accessDenied(){
        return "403page";
    }



    @GetMapping(value = "/sign_up_page")
    public String signupPage(){
        return "signup";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/update_password_page")
    public String updatePasswordPage(){
        return "updatePassword";
    }



    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/update_profile_page/{id}")
    public String updateProfilePage(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("profileUserId", id);
        return "updateProfile";
    }



    @PostMapping(value = "/to_sign_up")
    public String signUp(@RequestParam(name = "user_email") String email,
                         @RequestParam(name = "user_password") String password,
                         @RequestParam(name = "user_repeat_password") String repeatPassword,
                         @RequestParam(name = "user_fullName") String fullName,
                         @RequestParam(name = "user_birthdate") String birthdate,
                         @RequestParam(name = "user_bio") String bio){


        if(password.equals(repeatPassword)){
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setFullName(fullName);
            user.setBirthdate(birthdate);
            user.setBio(bio);
            User newUser = userService.addUser(user);
            if(newUser!=null){
                return "redirect:/sign_up_page?success";
            }
            else {

                return "redirect:/sign_up_page?emailerror";
            }
        }

        else{

            return "redirect:/sign_up_page?passworderror";
        }

    }




    @PreAuthorize("isAuthenticated()")
    @PostMapping (value = "/to_update_password")
    public String signUp(@RequestParam(name = "user_password") String oldPassword,
                         @RequestParam(name = "user_new_password") String newPassword,
                         @RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {

        if (newPassword.equals(repeatNewPassword)) {
            User user = userService.updatePassword(oldPassword, newPassword);
            if (user != null) {
                return "redirect:/update_password_page?success";
            } else {
                return "redirect:/update_password_page?oldpassworderror";
            }

        } else {

            return "redirect:/update_password_page?passwordmismatch";
        }

    }





    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/to_update_profile")
    public String updateProfile(@RequestParam(name = "user_id") Long id,
                                @RequestParam(name = "user_email") String email,
                                @RequestParam(name = "user_fullName") String fullName,
                                @RequestParam(name = "user_birthdate") String birthdate,
                                @RequestParam(name = "user_bio") String bio ) {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setFullName(fullName);
        user.setBirthdate(birthdate);
        user.setBio(bio);
        if(userService.updateUser(user)!=null){
            return "redirect:/update_profile_page/"+ id +"?success";
        }
        else {
            return "redirect:/update_profile_page/"+ id +"?emailerror";
        }

    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/user_details/{id}")
    public String userDetails(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("userId", id);
        return "userDetails";
    }



}
