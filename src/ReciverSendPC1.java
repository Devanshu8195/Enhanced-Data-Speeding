import java.io.*;
import java.net.*;
import java.util.*;

class Consumer extends Thread {

    ReciverSendPC1 rpc;

    Consumer(ReciverSendPC1 rpc) {
        super("Consumer");
        this.rpc = rpc;
    }

    @Override
    public void run() {
        for (;;) {
//            try {
//                Thread.sleep(1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            synchronized (rpc.data) {
                Iterator it = rpc.data.iterator();
                while (it.hasNext()) {
                    try {
                        Object o = it.next();
                        rpc.sendData(o.toString());
                    } catch (Exception ex) {
                        System.out.println("Error : " + ex);
                    }
                }
            }
        }
    }
}

class Producer extends Thread {

    ReciverSendPC1 rpc;

    Producer(ReciverSendPC1 rpc) {
        super("Producer");
        this.rpc = rpc;
    }

    @Override
    public void run() {
        for (;;) {
//            try {
//                Thread.sleep(1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            String d = rpc.receiveUDPPacket();
            synchronized (rpc.data) {
                rpc.data.add(d);
                if (rpc.data.size() > 10000) {
                    rpc.data.remove(rpc.data.size() - 1);
                }
            }
        }
    }
}

public class ReciverSendPC1 {

    String protocol = "UDP";
    String pc2Ip = "localhost";
    String pc3Ip = "localhost";
    int rPCPort = 1235;
    int pc2Port = 1236;
    int pc3Port = 1237;
    int TCPServerPort = 1238;
    DatagramSocket pc1Socket;
    byte[] receiveData = new byte[1024];
    byte[] sendData = new byte[1024];
    int count = 0;

    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;

    static Vector<Object> data = new Vector<Object>();

    public static void main(String[] args) {
        ReciverSendPC1 rpc = null;
        try {
            rpc = new ReciverSendPC1();
        } catch (Exception ex) {
            System.out.println("Error : " + ex + ex.getMessage());
        }
        Producer p = new Producer(rpc);
        Consumer c = new Consumer(rpc);
        p.start();
        c.start();
        try {
            p.join();
            c.join();
        } catch (InterruptedException ex) {
        }
    }

    public ReciverSendPC1() throws IOException {
        if (protocol.equalsIgnoreCase("TCP")) {
            setUpTCPConnection();
        }
        pc1Socket = new DatagramSocket(rPCPort);
        System.out.println("PC1 Socket on : " + InetAddress.getLocalHost().getHostAddress());
    }

    String receiveUDPPacket() {
        String rdata = null;
        try {
            System.out.println("receiveUDPPacket");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            pc1Socket.receive(receivePacket);
            count++;
            rdata = new String(receivePacket.getData());
            System.out.println("RECEIVED: " + count + "  data" + rdata);
            System.out.println("Rec");
        } catch (Exception ex) {
            System.out.println("Error : " + ex + ex.getMessage());
        }
        return rdata;
    }

    void sendData(String data) {
        try {
            System.out.println("sendData");
            if (protocol.equalsIgnoreCase("UDP")) {
                sendPC2UDP(data);
            } else {
                sendPC2TCP(data);
            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex + ex.getMessage());
        }
    }

    public void setUpTCPConnection() {
        try {
            ss = new ServerSocket(TCPServerPort);
            System.out.println("Server Started on : " + InetAddress.getLocalHost().getHostAddress());
            s = ss.accept();
            System.out.println("Request Receive");
            dos = new DataOutputStream(s.getOutputStream());
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }

    void sendPC2UDP(String data) throws Exception {
        InetAddress rPC = InetAddress.getByName(pc2Ip);
        DatagramPacket sendPacket = new DatagramPacket(data.getBytes(), data.length(), rPC, pc2Port);
        pc1Socket.send(sendPacket);
    }

    public void sendPC2TCP(String data) throws Exception {
        System.out.println("sendPC2TCP: ");
        dos.writeUTF(data);
    }

//    void sendPC3(String data) throws Exception {
//        InetAddress rPC = InetAddress.getByName(pc3Ip);
//        DatagramPacket sendPacket = new DatagramPacket(data.getBytes(), data.length(), rPC, pc3Port);
//        pc1Socket.send(sendPacket);
//
//    }
    @Override
    public void finalize() {

        try {
            if (dos != null) {
                dos.close();
            }
            if (s != null) {
                s.close();
            }
            if (ss != null) {
                ss.close();
            }
        } catch (IOException ex) {
            System.out.println("Error :" + ex);
        }
    }
}
