package br.com.unicuritiba.ProjetoA3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unicuritiba.ProjetoA3.Models.User;

	public interface UserRepository extends JpaRepository<User, Long> {
}
