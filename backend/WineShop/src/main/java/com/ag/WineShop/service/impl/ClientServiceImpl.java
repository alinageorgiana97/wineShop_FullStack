package com.ag.WineShop.service.impl;

import com.ag.WineShop.dto.ClientDTO;
import com.ag.WineShop.dto.RegisteredUserDTO;
import com.ag.WineShop.dto.UserDTO;
import com.ag.WineShop.entity.Client;
import com.ag.WineShop.mapper.ClientMapper;
import com.ag.WineShop.repository.ClientRepository;
import com.ag.WineShop.repository.UserRepository;
import com.ag.WineShop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private UserRepository userRepository;
    private ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, UserRepository userRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
        this.clientMapper = clientMapper;
    }


    @Override
    public Integer save(RegisteredUserDTO registeredUserDTO, UserDTO userDTO) {

        ClientDTO clientDTO = this.extractClientDTOFromRegisteredUserDTO(registeredUserDTO);
        clientDTO.setUser(userDTO);
        Client client = clientMapper.toEntity(clientDTO);

        return clientRepository.save(client).getId();

    }

    private ClientDTO extractClientDTOFromRegisteredUserDTO(RegisteredUserDTO registeredUserDTO) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName(registeredUserDTO.getFirstName());
        clientDTO.setLastName(registeredUserDTO.getLastName());
        return clientDTO;

    }

    @Override
    public Client findEntityById(Integer id) {
        return null;
    }
}
