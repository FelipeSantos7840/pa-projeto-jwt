package com.felipesantos.projetosecurity.service;

import com.felipesantos.projetosecurity.dto.UserDTO;
import com.felipesantos.projetosecurity.model.Role;
import com.felipesantos.projetosecurity.model.User;
import com.felipesantos.projetosecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO create(UserDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());

        userRepository.save(user);
        return dto;
    }

    public UserDTO update(Long id, UserDTO dto) {
        User currentUser = getAuthenticatedUser();

        if (!isAdmin(currentUser) && !currentUser.getId().equals(id)) {
            return null;
        }

        User entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        entity.setName(dto.getName());
        if (dto.getPassword() != null){
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        entity.setUsername(dto.getUsername());

        userRepository.save(entity);
        return dto;
    }

    private User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(auth.getName());
    }

    private boolean isAdmin(User user) {
        return user.getRole() == Role.ADMIN;
    }
}
