package br.com.unicuritiba.ProjetoA3.Services;

import br.com.unicuritiba.ProjetoA3.Models.Admin;
import br.com.unicuritiba.ProjetoA3.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin salvar(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> listarTodos() {
        return adminRepository.findAll();
    }

    public Optional<Admin> buscarPorId(Long id) {
        return adminRepository.findById(id);
    }

    public Admin atualizar(Long id, Admin adminAtualizado) {
        return adminRepository.findById(id).map(admin -> {
            admin.setNome(adminAtualizado.getNome());
            admin.setEmail(adminAtualizado.getEmail());
            admin.setSenha(adminAtualizado.getSenha());
            return adminRepository.save(admin);
        }).orElseThrow(() -> new RuntimeException("Admin não encontrado com o ID: " + id));
    }

    public void deletar(Long id) {
        adminRepository.deleteById(id);
    }
}
