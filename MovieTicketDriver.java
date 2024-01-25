import java.time.*;
import java.sql.*;

public class MovieTicketDriver {
    public static void main(String[] args) {
        //Movie m = new Movie("Race 3","Action",4.9,120,"Its a good movie of racing");
        //m.insertMovie();

        //Movie m = new Movie();
        //m.showMovies();

        //Theater t = new Theater();
        //t.insertTheater("IMAX",40);
        //t.showTheaters();

        Showtime s = new Showtime();
        // Create a LocalDateTime object for today at 4 PM
        LocalDateTime localDateTime = LocalDateTime.now().withHour(16).withMinute(0).withSecond(0);

        // Convert the LocalDateTime to a Timestamp
        Timestamp showtime = Timestamp.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());


        // Call the insertShowtime method
        //s.insertShowtime(1, 2, showtime);
        //s.showShowtimes();

        Admin a = new Admin();
        //a.adminMenu();

        Booking b = new Booking();
        b.bookTicket(1);
    }
}
