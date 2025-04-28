import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            ConcatServiceImpl obj = new ConcatServiceImpl();
            Registry registry = LocateRegistry.getRegistry(); // Don't create new one
            registry.rebind("ConcatService", obj);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
