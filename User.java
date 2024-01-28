import java.util.Scanner;

public class User{
    String name,username,password,address,phone;
    int choice;
    Scanner sc = new Scanner(System.in);
    Showtime st = new Showtime();
    Booking b = new Booking();


    public void userMenu(int userID){
        while(true){

            System.out.println("---------- User Menu ----------");
            System.out.println("Press 1 to see all showtimes.");
            System.out.println("Press 2 to book a ticket");
            System.out.println("Press 3 to see ticket bookings");
            System.out.println("Press 4 to cancel ticket booking");
            System.out.println("Press 5 to exit.");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();
            switch(choice){
                //to see all movies
                case 1:
                    st.showShowtimes();
                    break;

                //book a ticket
                case 2:
                    b.bookTicket(userID);
                    break;

                //see ticket bookings
                case 3:
                    b.seeTicket(userID);
                    break;

                //cancel ticket booking
                case 4:
                    b.cancelTicket(userID);
                    break;

                //exit
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice entered!Retry");
                    break;
            }
        }
    }
}
