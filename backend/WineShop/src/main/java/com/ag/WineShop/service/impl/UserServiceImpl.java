package com.ag.WineShop.service.impl;

import com.ag.WineShop.dto.LoginDTO;
import com.ag.WineShop.dto.RegisteredUserDTO;
import com.ag.WineShop.dto.ResetPasswordDTO;
import com.ag.WineShop.dto.UserDTO;
import com.ag.WineShop.entity.User;
import com.ag.WineShop.enumeration.Role;
import com.ag.WineShop.mapper.UserMapper;
import com.ag.WineShop.repository.UserRepository;
import com.ag.WineShop.service.ClientService;
import com.ag.WineShop.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final ClientService clientService;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, ClientService clientService) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.clientService = clientService;
    }


    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public UserDTO register(RegisteredUserDTO userDTO) {
        User user = userMapper.toEntity(this.extractUserDTOFromRegisteredUserDTO(userDTO));
        user.setPassword((new String(Base64.encodeBase64(user.getPassword().getBytes()))));
        user = userRepository.save(user);

        if (user.getUserRole() == Role.CLIENT) {
            clientService.save(userDTO, userMapper.toDTO(user));
        }


        return userMapper.toDTO(user);
    }



    @Override
    public UserDTO login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        } else {
            if (new String(Base64.encodeBase64(loginDTO.getPassword().getBytes())).equals(user.getPassword())) {
                return userMapper.toDTO(user);
            } else {
                throw new ResourceNotFoundException("Username or password incorrect!");
            }
        }

    }

    @Override
    public UserDTO changePassword(ResetPasswordDTO resetPasswordDTO)  {
        User user = userRepository.findByEmail(resetPasswordDTO.getEmail());
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        } else {
            if (new String(Base64.encodeBase64(resetPasswordDTO.getOldPassword().getBytes())).equals(user.getPassword())) {
                user.setPassword((new String(Base64.encodeBase64(resetPasswordDTO.getNewPassword().getBytes()))));
            }

            return userMapper.toDTO(userRepository.save(user));
        }
    }

    private UserDTO extractUserDTOFromRegisteredUserDTO(RegisteredUserDTO registeredUserDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(registeredUserDTO.getEmail());
        userDTO.setPassword(registeredUserDTO.getPassword());
        userDTO.setUserRole(Role.CLIENT);

        return userDTO;
    }


}
