package ma.ensa.controller;

import lombok.Data;
import ma.ensa.Transfert.TransfertDTO;
import ma.ensa.Transfert.TransfertFeign;
import ma.ensa.converter.ClientConverter;
import ma.ensa.dto.ClientDTO;
import ma.ensa.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientBanque")
@Data
public class ClientController {
    private final ClientService clientService;
    private final ClientConverter clientConverter;
    private final TransfertFeign transfertFeign;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody ClientDTO clientDTO) throws Exception {
        if (clientDTO == null)
            return ResponseEntity.badRequest().body("The provided client is not valid");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientConverter.convertToDTO(clientService.save(clientConverter.convertToDM(clientDTO))));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody ClientDTO clientDTO) throws Exception {
        if (clientDTO == null)
            return ResponseEntity.badRequest().body("The provided client is not valid");
        return ResponseEntity
                .ok().body(clientConverter.convertToDTO(clientService.update(clientConverter.convertToDM(clientDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        if(id == null)
            return ResponseEntity.badRequest().body("The provided client's id is not valid");
        return ResponseEntity.ok().body("Client [" + clientService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.ok().body(clientConverter.convertToDTOs(clientService.findAll()));
    }

    //Get all transferts by clientBanque from transfert-service
    @GetMapping("/allTransferts/idClientBanque")
    public List<TransfertDTO> getAllTransfertsByClientBanque(@PathVariable("idClientBanque") Long idClientBanque){
        return transfertFeign.getTransfertsByClientBanque(idClientBanque);
    }

}
