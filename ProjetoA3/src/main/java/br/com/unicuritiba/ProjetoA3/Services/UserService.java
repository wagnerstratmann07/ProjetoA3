package br.com.unicuritiba.ProjetoA3.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicuritiba.ProjetoA3.Models.User;
import br.com.unicuritiba.ProjetoA3.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public void removeUser(Long id) {
        repository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        user.setId();
        return saveUser(user);
    }
}
