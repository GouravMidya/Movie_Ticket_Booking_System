import java.sql.Timestamp;
import java.util.*;

public class Showtime {

    DatabaseOperation db = new DatabaseOperation();
    public void insertShowtime(int MovieID,int TheaterID,Timestamp showtime){
        String sql = "INSERT INTO Showtimes(MovieID,TheaterID,Showtime) VALUES(?,?,?)";
        Object[] values = {MovieID,TheaterID,showtime};
        int rowsAffected = db.executeUpdate(sql, values);
        if(rowsAffected>0)
            System.out.println("Showtime added successfully");
        else
            System.out.println("Something went wrong.Showtime not inserted.");
    
    }

    public void showShowtimes(){
        String sql = "SELECT * from Showtimes";
        List<Map<String,Object>> showtimes = db.getRecords(sql);
        for (Map<String, Object> showtime : showtimes) {
            System.out.println("Showtime ID: " + showtime.get("ShowtimeID"));
            System.out.println("Movie ID: " + showtime.get("MovieID"));
            System.out.println("Theater ID: " + showtime.get("TheaterID"));
            System.out.println("Showtime: " + showtime.get("Showtime"));
            System.out.println("-----------------------------"); 
        }
    }

    public void showShowtimesDetails(int showtimeID){
        String sql = "SELECT s.ShowtimeID, m.Title,m.Duration,s.Showtime from Showtimes s, Movies m where s.MovieID = m.MovieID and s.ShowtimeID = ? ";
        db.getShowtimeDetails(sql, showtimeID);
    }
    public int getTheaterCapacity(int showtime){
        String sql = "SELECT SeatingCapacity from theaters where TheaterID = (SELECT TheaterID from showtimes where ShowtimeID = ?)";
        return db.getSeatingCapacity(sql, showtime);
    }

}
