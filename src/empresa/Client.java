package empresa;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

public class Client {

    private InetAddress clientIP;
    private int clientPort;
    private JSONObject jObj;
    private DatagramSocket clientSock;

    public Client(InetAddress clientIP, int clientPort) throws SocketException {
        jObj = new JSONObject();
        this.clientIP = clientIP;
        this.clientPort = clientPort;
        clientSock = new DatagramSocket(clientPort);
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

    public void sendMsg(String command, String locate, String value) throws SocketException, IOException, JSONException {
        byte[] txData = new byte[65507];
        byte[] rxData = new byte[65507];

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
    }
}
