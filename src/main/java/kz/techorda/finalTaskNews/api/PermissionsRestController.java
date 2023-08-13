package kz.techorda.finalTaskNews.api;

import kz.techorda.finalTaskNews.dto.PermissionDTO;
import kz.techorda.finalTaskNews.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/permissions")
@RequiredArgsConstructor
public class PermissionsRestController {

    private final PermissionService permissionService;

   @GetMapping
    private List<PermissionDTO> getPermissions(){
        return permissionService.getAllPermissions();
    }


}
