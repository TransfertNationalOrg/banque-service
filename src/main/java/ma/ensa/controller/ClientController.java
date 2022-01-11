package ma.ensa.controller;

import lombok.Data;
import ma.ensa.converter.ClientConverter;
import ma.ensa.dto.ClientDTO;
import ma.ensa.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cmi")
@Data
public class ClientController {
    final ClientService clientService;
    final ClientConverter clientConverter;

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
}
