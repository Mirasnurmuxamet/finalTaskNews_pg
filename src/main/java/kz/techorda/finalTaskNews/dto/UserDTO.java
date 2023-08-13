package kz.techorda.finalTaskNews.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String email;

    private String fullName;

    private String birthdate ;

    private String bio;

    private Boolean deleteApplication;

    private List<PermissionDTO> permissions;




}
