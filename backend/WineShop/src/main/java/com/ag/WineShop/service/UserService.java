package com.ag.WineShop.service;

import com.ag.WineShop.dto.LoginDTO;
import com.ag.WineShop.dto.RegisteredUserDTO;
import com.ag.WineShop.dto.ResetPasswordDTO;
import com.ag.WineShop.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO register(RegisteredUserDTO userDTO);

    UserDTO login(LoginDTO loginDTO);

    UserDTO changePassword(ResetPasswordDTO resetPasswordDTO);

}
