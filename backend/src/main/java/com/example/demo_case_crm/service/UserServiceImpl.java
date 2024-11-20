package com.example.demo_case_crm.service;

import com.example.demo_case_crm.dto.UserDTO;
import com.example.demo_case_crm.entity.User;
import com.example.demo_case_crm.exception.ResourceNotFoundException;
import com.example.demo_case_crm.mapper.UserMapper;
import com.example.demo_case_crm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = UserMapper.toDTO(user, new UserDTO());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public UserDTO getById(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User","id",Integer.toString(id)));
        return UserMapper.toDTO(user, new UserDTO());
    }

}
