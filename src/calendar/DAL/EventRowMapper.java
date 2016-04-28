package calendar.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import calendar.model.Event;

public class EventRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Event event = new Event();
		
		event.setEventId(rs.getInt("eventId"));
		event.setCreatorAccountId(rs.getInt("creatorAccountId"));
		event.setEventName(rs.getString("eventName"));
		event.setEventStreetAddress(rs.getString("eventStreetAddress"));
		event.setEventCity(rs.getString("eventCity"));
		event.setEventState(rs.getString("eventState"));
		event.setEventTime(rs.getTimestamp("eventTime").toLocalDateTime());

		return event;
	}

	
}
