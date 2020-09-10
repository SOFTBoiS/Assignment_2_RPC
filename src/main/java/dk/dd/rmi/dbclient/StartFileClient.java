package dk.dd.rmi.dbclient;

import dk.dd.rmi.dbserver.FileTransferServer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Random;


public class StartFileClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        var pathToFile = "C:\\Users\\Adam\\testxD.json";
        Random rand = new Random();
        var fileName = rand.nextInt(1000000) + ".json";
        var server = (FileTransferServer) Naming.lookup("//localhost/FileService");
        var data = Files.readAllBytes(Paths.get(pathToFile));
        server.receiveData(fileName, data, data.length);
        System.out.println("Listening");
    }
}
