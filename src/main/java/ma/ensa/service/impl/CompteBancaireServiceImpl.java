package ma.ensa.service.impl;

import lombok.Data;
import ma.ensa.dto.CompteBancaireDTO;
import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.CompteBancaire;
import ma.ensa.repository.CompteBancaireRepository;
import ma.ensa.service.CompteBancaireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CompteBancaireServiceImpl implements CompteBancaireService {
    final CompteBancaireRepository compteBancaireRepository;

    @Override
    public CompteBancaire save(CompteBancaire compteBancaire) throws DuplicatedException {
        CompteBancaire compteBancaireFromDB = compteBancaireRepository.findById(compteBancaire.getId()).orElse(null);
        if (compteBancaireFromDB != null)
            throw new DuplicatedException(compteBancaire.getId());
        return compteBancaireRepository.save(compteBancaire);
    }

    @Override
    public CompteBancaire update(CompteBancaire compteBancaire) throws NotFoundException {
        CompteBancaire compteBancaireFromDB = compteBancaireRepository.findById(compteBancaire.getId()).orElse(null);
        if (compteBancaireFromDB == null)
            throw new NotFoundException(compteBancaire.getId());
        compteBancaire.setId(compteBancaireFromDB.getId());
        return compteBancaireRepository.save(compteBancaire);
    }

    @Override
    public Long delete(Long id) throws NotFoundException {
        CompteBancaire compteBancaireFromDB = compteBancaireRepository.findById(id).orElse(null);
        if (compteBancaireFromDB == null)
            throw new NotFoundException(id);
        compteBancaireRepository.delete(compteBancaireFromDB);
        return id;
    }

    @Override
    public List<CompteBancaire> findAll() {
        return compteBancaireRepository.findAll();
    }

    @Override
    public CompteBancaireDTO findByIdClient(Long idClient) {
        return compteBancaireRepository.findByIdclient(idClient);
    }
}
