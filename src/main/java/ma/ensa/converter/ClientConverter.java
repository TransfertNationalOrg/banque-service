package ma.ensa.converter;

import ma.ensa.dto.ClientDTO;
import ma.ensa.model.Client;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientDTO> {
    private final ModelMapper modelMapper;

    public ClientConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public Client convertToDM(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    @Override
    public ClientDTO convertToDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

}
