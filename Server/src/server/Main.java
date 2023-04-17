package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws SocketException, IOException, JSONException {
        InetAddress srvIP = InetAddress.getByName(args[0]);
        int port = 50000;
        JSONObject jObj = new JSONObject();
        DatagramSocket serverSock = new DatagramSocket(port);
        byte[] rxData = new byte[65507];
        byte[] txData = new byte[65507];
        Status status = new Status();
        status.list();
        while (true) {
            DatagramPacket rxPkt = new DatagramPacket(rxData, rxData.length);
            serverSock.receive(rxPkt);
            String msg = new String(rxPkt.getData(), 0, rxPkt.getLength());
            jObj = new JSONObject(msg);
            jObj = status.statusAtt(jObj);
            
            //jObj.put("status", status.statusAtt(jObj));
            System.out.println(jObj.get("command").toString());
            System.out.println("\nSERVER\nMessage received: \n\t" + msg + "\n");
            txData = jObj.toString().getBytes(StandardCharsets.UTF_8);
            DatagramPacket txPkt = new DatagramPacket(txData, jObj.toString().length(), rxPkt.getAddress(), rxPkt.getPort());
            serverSock.send(txPkt);
        }
    }

}
