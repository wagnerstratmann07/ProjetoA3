package br.com.unicuritiba.ProjetoA3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.unicuritiba.ProjetoA3.Models.Mensage;
import br.com.unicuritiba.ProjetoA3.Services.MensageService;

@RestController
@RequestMapping("/api/mensages")
public class MensageController {

    @Autowired
    private MensageService service;

    @GetMapping
    public ResponseEntity<List<Mensage>> getMensages() {
        return ResponseEntity.ok(service.getAllMensages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensage> getMensage(@PathVariable Long id) {
        return service.getMensageById(id)
                .map(mensage -> ResponseEntity.ok(mensage))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mensage> saveMensage(@RequestBody Mensage mensage) {
        return ResponseEntity.ok(service.saveMensage(mensage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensage> updateMensage(@PathVariable Long id, @RequestBody Mensage mensage) {
        return ResponseEntity.ok(service.updateMensage(id, mensage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMensage(@PathVariable Long id) {
        service.removeMensage(id);
        return ResponseEntity.noContent().build();
    }
}
