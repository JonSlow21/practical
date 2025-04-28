import java.rmi.Naming;
import java.util.Scanner;

public class HotelClient {
    public static void main(String[] args) {
        try {
            Hotel hotel = (Hotel) Naming.lookup("rmi://localhost:1099/HotelService");
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Book Room\n2. Cancel Booking\n3. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.print("Enter guest name: ");
                    String name = sc.nextLine();
                    System.out.println(hotel.bookRoom(name));
                } else if (choice == 2) {
                    System.out.print("Enter guest name to cancel: ");
                    String name = sc.nextLine();
                    System.out.println(hotel.cancelBooking(name));
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
