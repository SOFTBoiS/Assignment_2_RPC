package dk.dd.rmi.dbserver;

import com.google.gson.Gson;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

public class CustomerFacade {

    BankImplementation BI = new BankImplementation();

    public CustomerFacade() throws RemoteException {
    }

    public void insertUser(byte[] incomingBytes) throws UnsupportedEncodingException {
        Gson gson = new Gson();

        String decoded = new String(incomingBytes, "utf-8");

        try {
            Customer customer = gson.fromJson(decoded, Customer.class);
            BI.insertUser(customer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
