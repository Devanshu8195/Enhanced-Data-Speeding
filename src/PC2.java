
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author meghalshah
 */
public class PC2 {

    String protocol = "UDP";
    int TCPServerPort = 1238;
    String pc2Ip = "localhost";
    int pc2Port = 1236;
    DatagramSocket pc2Socket;
    byte[] receiveData = new byte[1024];
    byte[] sendData = new byte[1024];

    Socket s;
    DataInputStream dis;
    DataOutputStream dos;

    Connection cn;
    PreparedStatement pst;
    int count = 1000;

    public PC2() throws IOException {

        if (protocol.equalsIgnoreCase("TCP")) {
            setUpTCP();
        }
        setUpDatabase();

        if (protocol.equalsIgnoreCase("UDP")) {
            try {
                pc2Socket = new DatagramSocket(pc2Port);
                System.out.println("Pc2 Socket on : " + InetAddress.getLocalHost().getHostAddress());
                //while (true) {
                while (count != 0) {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    pc2Socket.receive(receivePacket);
                    String rdata = new String(receivePacket.getData());
                    //rdata = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150";
//                System.out.println("RECEIVED: " + rdata);
                    insertIntoDataBase(rdata);
                    count--;
                }

            } catch (Exception ex) {
                System.out.println("Error : " + ex + ex.getMessage());
            } finally {
                if (pc2Socket != null) {
                    pc2Socket.close();
                }
            }
        } else {
            try {
                while (count != 0) {

                    String rdata = dis.readUTF();
                    //rdata = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150";
//                System.out.println("RECEIVED: " + rdata);
                    insertIntoDataBase(rdata);
                    count--;
                }

            } catch (Exception ex) {
                System.out.println("Error : " + ex + ex.getMessage());
            } finally {
                if (pc2Socket != null) {
                    pc2Socket.close();
                }
            }

        }
    }

    void setUpTCP() {

        try {
            s = new Socket(pc2Ip, TCPServerPort);
            dis = new DataInputStream(s.getInputStream());
            System.out.println("Connection established with server");
        } catch (IOException ex) {
            System.out.println("Error : " + ex + ex.getMessage());
        }

    }

    void setUpDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tempraturedb", "root", "");
//            for (double j = 0; j < 1000; j++) {
            String squery = "INSERT into temp_tb1 values (NULL,?";
            for (int i = 0; i < 150; i++) {
                squery += " , ? ";
            }
            squery += " )";
            pst = cn.prepareStatement(squery);
//            }
        } catch (Exception e) {
            System.out.println("Error : " + e + e.getMessage());
        }
    }

    void insertIntoDataBase(String data) {
        try {
            data = data.trim();
            String[] sa = data.split(",");
            int[] a = new int[sa.length];
            for (int i = 0; i < sa.length; i++) {
                a[i] = Integer.parseInt(sa[i].trim());
                // System.out.println(sa[i] + " -  a["+i+"]" + a[i] + "   ");
            }
            java.util.Date today = new java.util.Date();
//            pst.setInt(1, 1);.

            pst.setLong(1, today.getTime());
            for (int i = 0; i < 150; i++) {
                pst.setInt(i + 2, a[i]);
            }
            pst.executeUpdate();
            //cn.close();
            System.out.println("Done" + count);
        } catch (Exception ex) {
            System.out.println("Error : " + ex + ex.getMessage());
        }
    }

    @Override
    public void finalize() {

        try {
            if (dis != null) {
                dis.close();
            }
            if (s != null) {
                s.close();
            }

        } catch (IOException ex) {
            System.out.println("Error :" + ex);
        }
    }

    public static void main(String[] s) throws Exception {
        // System.out.println(InetAddress.getLocalHost().getHostAddress());
        new PC2();
    }

}
