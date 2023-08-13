package kz.techorda.finalTaskNews.service;


import kz.techorda.finalTaskNews.dto.UserDTO;
import kz.techorda.finalTaskNews.mapper.UserMapper;
import kz.techorda.finalTaskNews.models.Permission;
import kz.techorda.finalTaskNews.models.User;
import kz.techorda.finalTaskNews.repository.PermissionRepository;
import kz.techorda.finalTaskNews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user!=null){
            return user;
        }
        else {
            throw new UsernameNotFoundException("User Not Found");
        }
    }

    public User addUser(User user){
        List<Permission> permissionList = new ArrayList<>();
        Permission permission  = permissionRepository.findPermissionByRole("ROLE_USER");
        if(permission!=null){
            permissionList.add(permission);
            user.setPermissions(permissionList);
            User checkUser = userRepository.findByEmail(user.getEmail());
            if(checkUser==null){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepository.save(user);

            }
        }
        return null;
    }

    public User updatePassword(String oldPassword, String newPassword){
        User currentUser = getCurrentSessionUser();
        if(currentUser!=null) {
            if (passwordEncoder.matches(oldPassword, currentUser.getPassword())) {
                currentUser.setPassword(passwordEncoder.encode(newPassword));
                return userRepository.save(currentUser);
            }
        }
        return null;
    }


    private  User getCurrentSessionUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User user = (User) authentication.getPrincipal();
            if(user!=null){
                return user;
            }
        }
        return null;
    }


    public User updateUser(User user){
        User currentUser = userRepository.findById(user.getId()).orElseThrow();
        User checkUser = userRepository.findByEmail(user.getEmail());
        if(checkUser==null ||(checkUser!=null && checkUser.getId()==currentUser.getId())){
            currentUser.setId(user.getId());
            currentUser.setEmail(user.getEmail());
            currentUser.setFullName(user.getFullName());
            currentUser.setBirthdate(user.getBirthdate());
            currentUser.setBio(user.getBio());
            return userRepository.save(currentUser);
        }
        else  {
            return null;
        }

    }

    public UserDTO getUser(Long id){
        return userMapper.toUserDto(userRepository.findById(id).orElseThrow());
    }

    public List<UserDTO> getAllUsers(){
        return userMapper.toUserDtoList(userRepository.findAll());
    }


    public UserDTO changeDeleteApplication(UserDTO userDTO){
        User user = userMapper.toUserModel(userDTO);
        User  correctUser = userRepository.findById(user.getId()).orElseThrow();
        correctUser.setDeleteApplication(user.getDeleteApplication());
        return userMapper.toUserDto(userRepository.save(correctUser));
    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


    public UserDTO addPermissions(UserDTO userDTO){
        User user = userMapper.toUserModel(userDTO);
        Permission permission = permissionRepository.findById(user.getPermissions().get(0).getId()).orElseThrow();
        User correctUser = userRepository.findById(user.getId()).orElseThrow();
        if(correctUser.getPermissions()!=null && correctUser.getPermissions().size()>0){
            if(!correctUser.getPermissions().contains(permission)) {
                correctUser.getPermissions().add(permission);
            }
        }
        else {
            List<Permission> newPermissions = new ArrayList<>();
            newPermissions.add(permission);
            correctUser.setPermissions(newPermissions);
        }
        return userMapper.toUserDto(userRepository.save(correctUser));


    }

    public UserDTO deletePermissions(UserDTO userDTO){
        User user = userMapper.toUserModel(userDTO);
        Permission permission = permissionRepository.findById(user.getPermissions().get(0).getId()).orElseThrow();
        User correctUser = userRepository.findById(user.getId()).orElseThrow();
        if(correctUser.getPermissions()!=null && correctUser.getPermissions().size()>0){
            if(correctUser.getPermissions().contains(permission)) {

                correctUser.getPermissions().remove(permission);
            }
        }

        return userMapper.toUserDto(userRepository.save(correctUser));

    }

}
