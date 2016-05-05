package calendar.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import calendar.DAL.AccountDAO;
import calendar.DAL.AttendanceDAO;
import calendar.DAL.EventDAO;
import calendar.helper.PasswordUtility;
import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;
import calendar.model.viewmodel.EventListing;

@Controller
public class EventController {

	private AccountDAO accountDAO;
	private EventDAO eventDAO;
	private AttendanceDAO attendanceDAO;
	
	public EventController(AccountDAO accountDAO, EventDAO eventDAO, AttendanceDAO attendanceDAO)
	{
		this.accountDAO = accountDAO;
		this.eventDAO = eventDAO;
		this.attendanceDAO = attendanceDAO;
		
		//Check to see if scaffolding has taken place
		Account testAccount = accountDAO.selectAccountByName("andrew");
				
		if (testAccount == null)
			scaffoldAccountsAndEvents();
	}
	
	private void scaffoldAccountsAndEvents()
	{
		//Get current LocalDateTime instance
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		//Create Dummy Data
		byte[] salt = PasswordUtility.generateSalt();
		byte[] passwordHash = PasswordUtility.generatePasswordHash(salt, "test");
		
		Account accountOne = new Account("andrew", "andrew@gmail.com", passwordHash, salt, dateTime);
		Account accountTwo = new Account("bob", "bobson@gmail.com", passwordHash, salt, dateTime);
		Account accountThree = new Account("chang", "chang@gmail.com", passwordHash, salt, dateTime);
		
		//Add Dummy Data
		accountDAO.insertAccount(accountOne);
		accountDAO.insertAccount(accountTwo);
		accountDAO.insertAccount(accountThree);
		
		//Create some dummy event data
		Event eventOne = new Event(1, "Cowboy Hat Sale", "12345 Cactus Dr.", "Palm Springs", "CA", LocalDateTime.now());
		Event eventTwo = new Event( 1, "Whiskey Tasting", "666 Canyon Ave.", "Dallas", "TX", LocalDateTime.now().minusHours(1));
		Event eventThree = new Event(2, "Pure Country Music Show", "854 Main Street", "Tombstone", "AZ", LocalDateTime.now().minusHours(2));
		
		//Add dummy event data
		eventDAO.insertEvent(eventOne);
		eventDAO.insertEvent(eventTwo);
		eventDAO.insertEvent(eventThree);
	}
	
	@RequestMapping(value={"events", "", "/"}, method=RequestMethod.GET)
	private String showListings(HttpServletRequest request) 
	{	
		HttpSession session = request.getSession();
		
		List<EventListing> eventsWithAttendance = new ArrayList<EventListing>();
		
		if (session.getAttribute("username") != null)
		{
			request.setAttribute("loggedIn", true);
		}
		
		deleteOldEvents();
		
		//Create our "view model"
		List<Event> tempList = eventDAO.selectAllEvents(); 
		
		for (Event e : tempList)
		{
			EventListing eventListing = new EventListing();
			eventListing.setEvent(e);
			
			Account temp = accountDAO.selectAccountById(e.getCreatorAccountId());
			eventListing.setAccountCreatorName(temp.getAccountName());

			List<String> attendees = attendanceDAO.getAttendeeNamesViaEventId(e.getEventId());
			eventListing.setAttendees(attendees);
			eventsWithAttendance.add(eventListing);	
		}
		//End Create
		
		request.setAttribute("eventsList", eventsWithAttendance);
		
        return "event/eventslist";
		
	}
	
	private void deleteOldEvents() {
		LocalDateTime beforefourHours = LocalDateTime.now().minusHours(4);
		
		List<Event> events = eventDAO.selectAllEvents();
		
		for (Event event : events){
			if(event.getEventTime().isBefore(beforefourHours)){
					boolean result = eventDAO.deleteEvent(event.getEventId());
			}
		}
	}
	
	@RequestMapping(value="events/create", method=RequestMethod.GET)
	private String showCreateEventForm(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		
		//If user reaches this page without begin logged in, redirect them to login servlet
		if (session.getAttribute("username") == null)
		{
			return "redirect:/login";
		}
		else
		{		
			return "event/eventcreate";
		}
	}
	
	@RequestMapping(value="events/accountevents", method=RequestMethod.GET)
	private String showAccountEvents(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		
		if (session.getAttribute("username") == null)
        {
            return "redirect:/account/login";
        }
		else 
		{
			String username = (String) session.getAttribute("username");
			
			//Get the user's accountId
			Account tempAccount = accountDAO.selectAccountByName(username);
			int accountId = tempAccount.getAccountId();
			
			//Get all events created by the user
			List<Event> createdEvents = eventDAO.selectEventsByCreatorId(accountId);
			
			//Get all events the user has "liked"
			List<Event> likedEvents = attendanceDAO.selectCorrespondingLikedEventsByAccountId(accountId);
			
			if(createdEvents != null && createdEvents.size() != 0) 
			{
				request.setAttribute("emptyCreatedEvents", false);
				request.setAttribute("createdEvents", createdEvents);
			}
			else
			{
				request.setAttribute("emptyCreatedEvents", true);
			}
			
			if(likedEvents != null && likedEvents.size() != 0)
			{
				request.setAttribute("emptyLikedEvents", false);
				request.setAttribute("likedEvents", likedEvents);
			}
			else
			{
				request.setAttribute("emptyLikedEvents", true);
			}
			
			return "account/accountevents";	
		}
	}
	
	@RequestMapping(value="events/create", method=RequestMethod.POST)
	private String createEvent(HttpServletRequest request) 
	{	
		HttpSession session = request.getSession();
		
		if (session.getAttribute("username") == null)
        {
            return "redirect:/account/login";
        }
		
		String eventname = request.getParameter("eventName");
		String eventcity = request.getParameter("eventCity");
		String eventstate = request.getParameter("eventState");
		String eventaddress = request.getParameter("eventStreetAddress");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String hour = request.getParameter("hour");
		String minute = request.getParameter("minute");

		if (eventname.equals("") || eventcity.equals("")
				|| eventstate.equals("") || eventaddress.equals("")
				|| year.equals("") || month.equals("") 
				|| day.equals("") || hour.equals("")
				|| minute.equals(""))
		{
			request.setAttribute("createFailed", true);
		    
			return "event/eventcreate";
		}
		
		String eventcreator = (String) session.getAttribute("username");
		
		int eventyear = Integer.parseInt(year);
		int eventmonth = Integer.parseInt(month);
		int eventday = Integer.parseInt(day);
		int eventhour = Integer.parseInt(hour);
		int eventminute = Integer.parseInt(minute);
		
		LocalTime time = LocalTime.of(eventhour, eventminute);
		LocalDate date = LocalDate.of(eventyear, eventmonth, eventday);
		LocalDateTime eventDateTime = LocalDateTime.of(date, time);
		
		int dateTimeCheckerForPastEvent = eventDateTime.compareTo(LocalDateTime.now());
		
		if( dateTimeCheckerForPastEvent < 0) {
			request.setAttribute("dateInPast", true);
			
			return "event/eventcreate";
		}
		
		else {	
			Account userAccount = accountDAO.selectAccountByName(eventcreator);
			int accountId = userAccount.getAccountId();
			
			//Create the new Event object and persist to data structure
			Event event = new Event(accountId, eventname, eventaddress, eventcity, eventstate, eventDateTime);
			
			boolean eventInserted = eventDAO.insertEvent(event);
			
			if (eventInserted == true)
				return "redirect:/events";
			else
				//Redirect to error page
				return "redirect:/events";
		}
	}
	
	@RequestMapping(value="events/like", method=RequestMethod.POST)
	private String subscribeToEvent(HttpSession session, @RequestParam("eventId") String eventIdNumber)
	{	
		Boolean error = false;
		
		if (session.getAttribute("username") == null)
        {
			return "redirect:/account/login";
        }
		else
		{
			Boolean duplicateAttendee = false;
			
			String username = (String) session.getAttribute("username");
			Integer accountId = accountDAO.selectAccountByName(username).getAccountId();
			
			String trimmed = eventIdNumber.trim();
			Integer eventId = Integer.parseInt(trimmed);
			
			//Check if event is already "liked" by the user
			Attendance attendance = attendanceDAO.selectAttendanceByIds(accountId, eventId);
			if (attendance != null)
			{
				duplicateAttendee = true;
				System.out.println("attendance is not null");
			}
			
			//If not already registered, get the user's accountId and put it and eventId in Attendance table
			if (duplicateAttendee == false)
			{
				Attendance tempAttendance = new Attendance(accountId, eventId);
				Boolean result = attendanceDAO.insertAttendance(tempAttendance);
				
				//If Attendance addition failed, redirect to error page
				if (result == false)
					error = true;
			}
			
			//If no errors, redirect back to events list
			if (error == false)
				return "redirect:/events";
			else
			{
				//TODO
				//set error message request attribute
				//redirect to error page
				return "redirect:/events";
			}
		}	
	}
	
}