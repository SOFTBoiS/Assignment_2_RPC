package dk.dd.rmi.dbserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileTransferServer extends Remote {

    public boolean receiveData(String filename, byte[] data, int length) throws RemoteException;
}
