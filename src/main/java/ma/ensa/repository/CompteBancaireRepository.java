package ma.ensa.repository;
import ma.ensa.model.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {

}