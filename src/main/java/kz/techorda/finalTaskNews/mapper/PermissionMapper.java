package kz.techorda.finalTaskNews.mapper;

import kz.techorda.finalTaskNews.dto.PermissionDTO;
import kz.techorda.finalTaskNews.models.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionDTO toPermissionDto(Permission permission);

    Permission toPermissionModel(PermissionDTO permissionDTO);

    List<PermissionDTO> toPermissionDtoList(List<Permission> permissionList);

    List<Permission> toPermissionModelList(List<PermissionDTO> permissionDTOList);

}
