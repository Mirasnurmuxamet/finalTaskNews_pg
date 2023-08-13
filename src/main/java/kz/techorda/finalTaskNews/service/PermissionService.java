package kz.techorda.finalTaskNews.service;

import kz.techorda.finalTaskNews.dto.PermissionDTO;
import kz.techorda.finalTaskNews.mapper.PermissionMapper;
import kz.techorda.finalTaskNews.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    private final PermissionMapper permissionMapper;

    public List<PermissionDTO> getAllPermissions(){
        return permissionMapper.toPermissionDtoList(permissionRepository.findAll());
    }

}
