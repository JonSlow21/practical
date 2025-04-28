import Pyro5.api
@Pyro5.api.expose

class HotelBooking:
    def __init__(self):
        self.bookings = set()

    def book_room(self, guest_name):
        if guest_name in self.bookings:
            return f"{guest_name} already has a booking."
        self.bookings.add(guest_name)
        return f"Room booked successfully for {guest_name}."
        
    def cancel_booking(self, guest_name):
        if guest_name in self.bookings:
            self.bookings.remove(guest_name)
            return f"Booking for {guest_name} canceled."
        return f"No booking found for {guest_name}."

daemon = Pyro5.api.Daemon()
uri = daemon.register(HotelBooking)
print("Hotel Booking Server is ready.")
print(f"URI: {uri}")
daemon.requestLoop()