import java.util.*;

public class Theater {
    private String Location;
    private int SeatingCapacity;

    private DatabaseOperation db = new DatabaseOperation();

    public void insertTheater(String location,int SeatingCapacity){
        this.Location = location;
        this.SeatingCapacity = SeatingCapacity;
        String sql = "INSERT INTO theaters (Location, SeatingCapacity) VALUES (?,?)";
        Object[] values = {Location,SeatingCapacity};
        int rowsAffected = db.executeUpdate(sql, values);
        if(rowsAffected>0)
            System.out.println("Theater inserted successfully");
        else
            System.out.println("Something went wrong.Theater not inserted.");
    }

    public void showTheaters(){
        String sql = "SELECT * from theaters";
        List<Map<String,Object>> theaters = db.getRecords(sql);
        for (Map<String, Object> theater : theaters) {
            System.out.println("Theater ID: " + theater.get("TheaterID"));
            System.out.println("Location: " + theater.get("Location"));
            System.out.println("Seating Capacity: " + theater.get("SeatingCapacity"));
            System.out.println("-----------------------------");
            
        }

    }
}
