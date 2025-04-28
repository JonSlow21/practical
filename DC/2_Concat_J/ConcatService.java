import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConcatService extends Remote {
    String concatenate(String s1, String s2) throws RemoteException;
}
