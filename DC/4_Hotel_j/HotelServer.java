import java.rmi.Naming;

public class HotelServer {
    public static void main(String[] args) {
        try {
            Hotel hotel = new HotelImpl();
            Naming.rebind("rmi://localhost:1099/HotelService", hotel);
            System.out.println("Hotel Server is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
