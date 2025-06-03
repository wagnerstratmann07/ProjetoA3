package br.com.unicuritiba.ProjetoA3.Controller;

import br.com.unicuritiba.ProjetoA3.Models.Admin;
import br.com.unicuritiba.ProjetoA3.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> criarAdmin(@RequestBody Admin admin) {
        Admin novoAdmin = adminService.salvar(admin);
        return ResponseEntity.ok(novoAdmin);
    }
    
    @GetMapping
    public ResponseEntity<List<Admin>> listarTodos() {
        List<Admin> admins = adminService.listarTodos();
        return ResponseEntity.ok(admins);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Admin> buscarPorId(@PathVariable Long id) {
        return adminService.buscarPorId(id)
                .map(admin -> ResponseEntity.ok(admin))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> atualizarAdmin(@PathVariable Long id, @RequestBody Admin adminAtualizado) {
        try {
            Admin admin = adminService.atualizar(id, adminAtualizado);
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdmin(@PathVariable Long id) {
        try {
            adminService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
