package ma.ensa.service;


import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.CompteBancaire;

import java.util.List;

public interface CompteBancaireService {
    CompteBancaire save(CompteBancaire compteBancaire) throws DuplicatedException;
    CompteBancaire update(CompteBancaire compteBancaire) throws NotFoundException;
    Long delete(Long id) throws NotFoundException;
    List<CompteBancaire> findAll();
}
