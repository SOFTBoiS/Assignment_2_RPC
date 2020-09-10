package dk.dd.rmi.dbserver;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileServer extends UnicastRemoteObject implements FileTransferServer {
    private String file = "";
    CustomerFacade cf = new CustomerFacade();

    protected FileServer() throws RemoteException {
    }


    public void setFile(String f) {
        file = f;
    }

    @Override
    public boolean receiveData(String filename, byte[] data, int length) {
        try {
            cf.insertUser(data);
            System.out.println("User persisted");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
