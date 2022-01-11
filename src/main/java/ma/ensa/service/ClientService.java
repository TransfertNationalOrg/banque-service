package ma.ensa.service;

import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client) throws DuplicatedException;
    Client update(Client client) throws NotFoundException;
    Long delete(Long id) throws NotFoundException;
    List<Client> findAll();
}
