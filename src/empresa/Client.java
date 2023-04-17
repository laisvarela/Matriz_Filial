package empresa;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Client extends Thread {

    private final InetAddress clientIP = InetAddress.getByName("127.0.0.1");
    private final int clientPort = 12334;
    private final DatagramSocket clientSock;
    private final LinkedList<JSONArray> list;
    private JSONObject jObj;
    private Window w = null;

    public Client() throws SocketException, JSONException, UnknownHostException {
        this.list = new LinkedList<>();
        jObj = new JSONObject();
        clientSock = new DatagramSocket(clientPort);
        w = new Window(this);
    }

    public InetAddress getclientIP() {
        return clientIP;
    }

    public int getclientPort() {
        return clientPort;
    }

    public JSONObject getjObj() {
        return jObj;
    }

    public JSONObject serverMsg(String command, String locate, String value) throws SocketException, IOException, JSONException {
        // enviar e receber mensagem
        byte[] txData = new byte[65507];
        byte[] rxData = new byte[65507];
        //jObj = new JSONObject();
        if (command.equalsIgnoreCase("get")) {
            jObj.put("command", command);
            jObj.put("locate", locate);
        } else if (command.equalsIgnoreCase("set")) {
            jObj.put("command", command);
            jObj.put("locate", locate);
            jObj.put("value", value);

        }
        txData = jObj.toString().getBytes(StandardCharsets.UTF_8);
        System.out.println("CLIENT\nMessage sent:\n\t" + jObj.toString());
        DatagramPacket txPkt = new DatagramPacket(txData, jObj.toString().length(), clientIP, 50000);
        clientSock.send(txPkt);

        DatagramPacket rxPkt = new DatagramPacket(rxData, rxData.length);
        clientSock.receive(rxPkt);
        String rxMsg = new String(rxPkt.getData(), StandardCharsets.UTF_8);
        rxMsg = rxMsg.substring(0, rxPkt.getLength());
        jObj = new JSONObject(rxMsg);
        System.out.println("RESPOSTA DO SERVIDOR\nMessage sent:\n\t" + jObj.toString());
        return jObj;
    }

    public void run() {
        try {
            byte[] txData = new byte[65507];
            byte[] rxData = new byte[65507];
            while (true) {
                Thread.sleep(5000);
                jObj.put("command", "status");
                txData = jObj.toString().getBytes(StandardCharsets.UTF_8);
                System.out.println("CLIENT STATUS\nMessage sent:\n\t" + jObj.toString());
                DatagramPacket txPkt = new DatagramPacket(txData, jObj.toString().length(), clientIP, 50000);
                clientSock.send(txPkt);
                DatagramPacket statusPkt = new DatagramPacket(rxData, rxData.length);
                clientSock.receive(statusPkt);
                String statusMsg = new String(statusPkt.getData(), StandardCharsets.UTF_8);
                statusMsg = statusMsg.substring(0, statusPkt.getLength());
                jObj = new JSONObject(statusMsg);
                System.out.println("RESPOSTA DO SERVIDOR STATUS \nMessage sent:\n\t" + jObj.toString());
                w.run();

            }
        } catch (InterruptedException | JSONException | IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
