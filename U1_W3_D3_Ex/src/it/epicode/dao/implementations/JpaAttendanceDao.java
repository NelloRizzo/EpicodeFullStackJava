package it.epicode.dao.implementations;

import it.epicode.entities.Attendance;

public class JpaAttendanceDao extends JpaDao<Attendance>{

	public JpaAttendanceDao() {
		super(Attendance.class);
	}

}
