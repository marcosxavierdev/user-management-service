package com.consulting.user_management_service.service;

import com.consulting.user_management_service.dto.UserRequestVO;
import com.consulting.user_management_service.dto.UserValidationRequestDTO;
import com.consulting.user_management_service.dto.UserValidationResponseDTO;
import com.consulting.user_management_service.mappers.UserMapper;
import com.consulting.user_management_service.model.User;
import com.consulting.user_management_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserValidationResponseDTO validateUser(UserValidationRequestDTO userValidationRequestDTO){
        Optional<User> userOptional = userRepository.findByUsername(userValidationRequestDTO.getUsername());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return new UserValidationResponseDTO(user.getPassword().equals(userValidationRequestDTO.getPassword()));
        }
        else{
            return new UserValidationResponseDTO(false);
        }
    }

    public void createUser(UserRequestVO userRequestVO){
        User user = UserMapper.INSTANCE.userRequestVOtoUser(userRequestVO);
        userRepository.save(user);
    }
}
