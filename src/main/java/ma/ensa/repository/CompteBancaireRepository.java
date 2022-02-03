package ma.ensa.repository;
import ma.ensa.dto.CompteBancaireDTO;
import ma.ensa.model.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {

    @Query("SELECT compteBancaire from CompteBancaire compteBancaire where compteBancaire.idClient=:x")
    CompteBancaireDTO findByIdclient(@Param("x") Long idClient);
}