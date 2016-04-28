package calendar.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import calendar.model.Attendance;

public class AttendanceRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Attendance attendance = new Attendance();
		
		attendance.setAccountId(rs.getInt("accountId"));
		attendance.setEventId(rs.getInt("eventId"));
		
		return attendance;
	}

}
