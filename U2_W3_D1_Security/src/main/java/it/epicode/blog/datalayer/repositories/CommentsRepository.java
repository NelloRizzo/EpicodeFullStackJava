package it.epicode.blog.datalayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.blog.datalayer.entities.CommentEntity;

public interface CommentsRepository extends JpaRepository<CommentEntity, Long> {

}
