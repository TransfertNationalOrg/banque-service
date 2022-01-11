package ma.ensa.converter;

import ma.ensa.dto.CompteBancaireDTO;
import ma.ensa.model.CompteBancaire;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CompteBancaireConverter extends AbstractConverter<CompteBancaire, CompteBancaireDTO>{
    private final ModelMapper modelMapper;

    public CompteBancaireConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public CompteBancaire convertToDM(CompteBancaireDTO compteBancaireDTO) {
        return modelMapper.map(compteBancaireDTO, CompteBancaire.class);
    }

    @Override
    public CompteBancaireDTO convertToDTO(CompteBancaire compteBancaire) {
        return modelMapper.map(compteBancaire, CompteBancaireDTO.class);
    }
}
