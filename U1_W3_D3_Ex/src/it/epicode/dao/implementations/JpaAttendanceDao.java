package it.epicode.dao.implementations;

import it.epicode.dao.AttendanceDao;
import it.epicode.entities.Attendance;

public class JpaAttendanceDao extends JpaDao<Attendance> implements AttendanceDao {

	public JpaAttendanceDao() {
		super(Attendance.class);
	}

}
