package ma.ensa.controller;

import lombok.Data;
import ma.ensa.converter.CompteBancaireConverter;
import ma.ensa.dto.CompteBancaireDTO;
import ma.ensa.service.CompteBancaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compteBancaire")
@Data
public class CompteBancaireController {
    final CompteBancaireService compteBancaireService;
    final CompteBancaireConverter compteBancaireConverter;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody CompteBancaireDTO compteBancaireDTO) throws Exception {
        if (compteBancaireDTO == null)
            return ResponseEntity.badRequest().body("The provided compteBancaire is not valid");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(compteBancaireConverter.convertToDTO(compteBancaireService.save(compteBancaireConverter.convertToDM(compteBancaireDTO))));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody CompteBancaireDTO compteBancaireDTO) throws Exception {
        if (compteBancaireDTO == null)
            return ResponseEntity.badRequest().body("The provided compteBancaire is not valid");
        return ResponseEntity
                .ok().body(compteBancaireConverter.convertToDTO(compteBancaireService.update(compteBancaireConverter.convertToDM(compteBancaireDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        if(id == null)
            return ResponseEntity.badRequest().body("The provided compteBancaire's id is not valid");
        return ResponseEntity.ok().body("CompteBancaire [" + compteBancaireService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<List<CompteBancaireDTO>> findAll() {
        return ResponseEntity.ok().body(compteBancaireConverter.convertToDTOs(compteBancaireService.findAll()));
    }
}
