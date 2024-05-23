package it.epicode.w2d4.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.w2d4.data.Message;

public interface MessagesRepository extends JpaRepository<Message, Long>, PagingAndSortingRepository<Message, Long>{

	Page<Message> findAllByToEmail(String email, Pageable p);
	Page<Message> findAllByFromEmail(String email, Pageable p);
}
