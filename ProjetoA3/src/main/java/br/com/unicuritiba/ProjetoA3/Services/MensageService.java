package br.com.unicuritiba.ProjetoA3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.unicuritiba.ProjetoA3.Models.Mensage;
import br.com.unicuritiba.ProjetoA3.Repository.MensageRepository;

@Service
public class MensageService {

    @Autowired
    private MensageRepository repository;

    public List<Mensage> getAllMensages() {
        return repository.findAll();
    }

    public Optional<Mensage> getMensageById(Long id) {
        return repository.findById(id);
    }

    public Mensage saveMensage(Mensage mensage) {
        return repository.save(mensage);
    }

    public void removeMensage(Long id) {
        repository.deleteById(id);
    }

    public Mensage updateMensage(Long id, Mensage mensage) {
        mensage.setIdMensagem(id);
        return repository.save(mensage);
    }
}
