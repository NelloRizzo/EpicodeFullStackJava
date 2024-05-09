package it.epicode.bw1.transportcompany.dao.v1;

import java.time.LocalDateTime;
import java.util.List;

import it.epicode.bw1.transportcompany.dao.UserDao;
import it.epicode.bw1.transportcompany.dao.exceptions.DaoException;
import it.epicode.bw1.transportcompany.entities.users.User;
import it.epicode.bw1.transportcompany.entities.utils.C;

public class UserDaoImpl extends DaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public void renewCard(User user, LocalDateTime issueDate) {
		try {
			var trans = em.getTransaction();
			trans.begin();
			user.getCard().setIssuedAt(issueDate);
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			log.error("Exception in renewCard()", e);
		}
	}

	@Override
	public List<User> findAll() {
		try {
			return em.createNamedQuery(C.T.User.Queries.SELECT_ALL, User.class).getResultList();
		} catch (Exception e) {
			log.error("Exception in findAll()", e);
			throw new DaoException(e);
		}
	}

}
