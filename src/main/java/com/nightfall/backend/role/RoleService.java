package com.nightfall.backend.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRoleById(UUID id) {
        return roleRepository.findById(id).orElse(null);
    }

    // public Role updateRole(UUID id, Role role) {
    //     if (roleRepository.existsById(id)) {
    //         role.setId(id);
    //         return roleRepository.save(role);
    //     }
    //     return null;
    // }

    public void deleteRole(UUID id) {
        roleRepository.deleteById(id);
    }
}
