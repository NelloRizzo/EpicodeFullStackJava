package it.epicode.springdata.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.springdata.data.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

	List<ToDo> findByDone(boolean done);

	List<ToDo> findByDateTimeBetween(LocalDateTime min, LocalDateTime max);

	List<ToDo> findByUserUsernameIgnoreCase(String username);
}
