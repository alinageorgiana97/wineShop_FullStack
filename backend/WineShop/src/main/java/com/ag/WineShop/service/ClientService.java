package com.ag.WineShop.service;

import com.ag.WineShop.dto.RegisteredUserDTO;
import com.ag.WineShop.dto.UserDTO;
import com.ag.WineShop.entity.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    /**
     * Inserts a new Client.
     * This is the save that is used only for registration.
     *
     * @param registeredUserDTO
     * @param userDTO
     * @return
     */
    public Integer save(RegisteredUserDTO registeredUserDTO, UserDTO userDTO);

    public Client findEntityById(Integer id);



}
