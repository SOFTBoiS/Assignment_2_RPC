package dk.dd.rmi.dbserver;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileServer extends UnicastRemoteObject implements FileTransferServer {
    private String file = "";

    protected FileServer() throws RemoteException {
    }


    public void setFile(String f) {
        file = f;
    }

    @Override
    public boolean receiveData(String filename, byte[] data, int length) {
        try {
            File f = new File(filename);
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f, true);
            out.write(data, 0, length);
            out.flush();
            out.close();
            // TODO: Parse JSON to object

            // TODO: persist custom object in database

            // TODO: Delete file


            System.out.println("Done writing data..");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
