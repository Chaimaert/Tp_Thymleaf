package com.chai.thymleaf.services;


import com.chai.thymleaf.models.Client;
import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client saveClient(Client client);
    void deleteClient(Long id);
    Client updateClient(Long id, Client updatedClient);
}

