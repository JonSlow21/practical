import Pyro5.api
uri = input("Enter the server URI: ").strip()
hotel = Pyro5.api.Proxy(uri)

while True:

    choice = input("\nHotel Booking System:\1. Book Room\n2. Cancel Booking\n3. Exit\nEnter choice: ")
    if choice == "1":
        name = input("Enter guest name: ")
        print(hotel.book_room(name))

    elif choice == "2":
        name = input("Enter guest name to cancel: ")
        print(hotel.cancel_booking(name))

    elif choice == "3":
        print("Goodbye!")
        break

    else:
        print("Invalid choice. Try again.")