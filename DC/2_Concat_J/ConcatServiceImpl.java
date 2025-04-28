import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ConcatServiceImpl extends UnicastRemoteObject implements ConcatService {

    protected ConcatServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String concatenate(String s1, String s2) throws RemoteException {
        return s1 + s2;
    }
}
