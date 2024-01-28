import java.util.Scanner;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Admin extends User{
    //instance fields
    Scanner sc = new Scanner(System.in);
    int choice,userID;
    String title, genre,synopsis;
    double rating;
    int duration,movieid,theaterid,showmtime_hour,showtime_min;
    Timestamp showtime;

    //Objects of different classes
    Movie m = new Movie();
    Theater t = new Theater();
    Showtime st = new Showtime();

    public int takeUserID(){
        System.out.println("Enter user id: ");
        return sc.nextInt();
    }

    public void adminMenu(){
        while(true){

            System.out.println("---------- Admin Menu ----------");
            System.out.println("Press 1 to add movies.");
            System.out.println("Press 2 to see all movies.");
            System.out.println("Press 3 to put a movie up for showtime.");
            System.out.println("Press 4 to see all showtimes.");
            System.out.println("Press 5 to add theaters.");
            System.out.println("Press 6 to see all theaters.");
            System.out.println("Press 7 to book a ticket");
            System.out.println("Press 8 to see ticket bookings");
            System.out.println("Press 9 to cancel ticket booking");
            System.out.println("Press 10 to exit.");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    //case to add movies
                    System.out.print("Enter movie title:");
                    title = sc.nextLine();
                    title = sc.nextLine();
                    System.out.print("Enter movie genre:");
                    genre = sc.next();
                    System.out.print("Enter movie rating: ");
                    rating = sc.nextDouble();
                    System.out.print("Enter movie duration(in mins): ");
                    duration = sc.nextInt();
                    System.out.print("Enter movie synopsis: ");
                    synopsis = sc.nextLine();
                    synopsis = sc.nextLine();
                    m.insertMovie(title, genre, rating, duration, synopsis);
                    break;
                case 2:
                    //case to see all movies
                    m.showMovies();
                    break;
                case 3:
                    //case to set a movie available for showtime
                    System.out.println("Enter Movie ID:");
                    movieid =sc.nextInt();
                    System.out.println("Enter Theater ID:");
                    theaterid = sc.nextInt();
                    System.out.println("Enter Showtime hour:");
                    showmtime_hour = sc.nextInt();
                    System.out.println("Enter Showtime minute:");
                    showtime_min = sc.nextInt();
                    LocalDateTime localDateTime = LocalDateTime.now().withHour(showmtime_hour).withMinute(showtime_min).withSecond(0);
                    showtime = Timestamp.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                    st.insertShowtime(movieid, theaterid, showtime);
                    break;
                case 4:
                //see all showtimes
                    st.showShowtimes();
                    break;
                case 5:
                //add theaters
                    System.out.println("Enter theater location:");
                    String address = sc.nextLine();
                    address = sc.nextLine();
                    System.out.print("Enter theater Seating capacity:");
                    int seating_capacity = sc.nextInt();
                    t.insertTheater(address, seating_capacity);
                    break;
                case 6:
                //see all theaters
                    t.showTheaters();
                    break;
                case 7:
                //book a ticket
                    userID = takeUserID();
                    b.bookTicket(userID);
                    break;

                case 8:
                //see ticket bookings
                    userID = takeUserID();
                    b.seeTicket(userID);
                    break;
                case 9:
                //cancel ticket booking
                    userID = takeUserID();
                    b.cancelTicket(userID);
                    break;
                case 10:
                //terminate the program
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice entered!Retry");
                    break;
            }
        }
    }
}
