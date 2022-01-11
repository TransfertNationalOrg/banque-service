package ma.ensa.Transfert;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="transfert-service")
public interface TransfertFeign {
    @GetMapping("/transfert/client/{idClient}")
    List<TransfertDTO> getTransfertsByClientBanque(@PathVariable("idClient") Long idClientBanque);

    @GetMapping("/transfert/compteBancaire/{idCompteBancaire}")
    List<TransfertDTO> getTransfertsByCompteBancaire(@PathVariable("idCompteBancaire") Long idCompteBancaire);
}
