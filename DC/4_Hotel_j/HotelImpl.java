import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

public class HotelImpl extends UnicastRemoteObject implements Hotel {
    private Set<String> bookedGuests;

    protected HotelImpl() throws RemoteException {
        super();
        bookedGuests = new HashSet<>();
    }

    public synchronized String bookRoom(String guestName) throws RemoteException {
        if (bookedGuests.contains(guestName)) {
            return "Guest '" + guestName + "' already has a booking.";
        } else {
            bookedGuests.add(guestName);
            return "Room successfully booked for '" + guestName + "'.";
        }
    }

    public synchronized String cancelBooking(String guestName) throws RemoteException {
        if (bookedGuests.remove(guestName)) {
            return "Booking canceled for '" + guestName + "'.";
        } else {
            return "No booking found for '" + guestName + "'.";
        }
    }
}
