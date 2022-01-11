package ma.ensa.service.impl;

import lombok.Data;
import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.Client;
import ma.ensa.repository.ClientRepository;
import ma.ensa.service.ClientService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
public class ClientServiceImpl implements ClientService {
    final ClientRepository clientRepository;

    @Override
    public Client save(Client client) throws DuplicatedException {
        Client clientFromDB = clientRepository.findById(client.getId()).orElse(null);
        if (clientFromDB != null)
            throw new DuplicatedException(client.getId());
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) throws NotFoundException {
        Client clientFromDB = clientRepository.findById(client.getId()).orElse(null);
        if (clientFromDB == null)
            throw new NotFoundException(client.getId());
        client.setId(clientFromDB.getId());
        return clientRepository.save(client);
    }

    @Override
    public Long delete(Long id) throws NotFoundException {
        Client clientFromDB = clientRepository.findById(id).orElse(null);
        if (clientFromDB == null)
            throw new NotFoundException(id);
        clientRepository.delete(clientFromDB);
        return id;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
