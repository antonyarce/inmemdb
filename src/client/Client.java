package client;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        int res;
        int num[] = new int[2];

        try {
            String host = "localhost";
            Socket sc = new Socket(host, 2500); // Socket servidor 

            OutputStream ostream = sc.getOutputStream();
            ObjectOutput s = new ObjectOutputStream(ostream);

            num[0] = 15;
            num[1] = 15; //Prepara la petición
            s.writeObject(num);
            s.flush();

            DataInputStream istream = new DataInputStream(sc.getInputStream());
            res = istream.readInt();
            sc.close();

            System.out.println("La suma es " + res);

        } catch (Exception e) {
            System.err.println("exepcion" + e.toString());
            e.printStackTrace();
        }

    }
}
