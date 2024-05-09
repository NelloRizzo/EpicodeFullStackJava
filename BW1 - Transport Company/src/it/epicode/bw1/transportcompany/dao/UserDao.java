package it.epicode.bw1.transportcompany.dao;

import java.time.LocalDateTime;

import it.epicode.bw1.transportcompany.entities.users.User;

public interface UserDao extends Dao<User> {
	void renewCard(User user, LocalDateTime issueDate);
}
