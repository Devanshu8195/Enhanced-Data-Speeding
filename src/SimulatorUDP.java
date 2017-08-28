
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author meghalshah
 */
public class SimulatorUDP {
    String rPCIP="localhost";
    int rPCPort = 1235;
    int myPort = 1234;
    String temps = "3,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150";
    DatagramSocket simulatorSocket;
    byte[] receiveData = new byte[1024];
    byte[] sendData = new byte[1024];
    public SimulatorUDP() throws IOException
    {
        try {
            simulatorSocket = new DatagramSocket(myPort);
            System.out.println("Server Socket on : "+InetAddress.getLocalHost().getHostAddress());
            InetAddress rPC = InetAddress.getByName(rPCIP);
                     
            System.out.println("send start ");            
            for (int i = 0; i < 1000; i++) {
                System.out.println("send start " + i); 
                DatagramPacket sendPacket = new DatagramPacket(temps.getBytes(), temps.length(), rPC, rPCPort); 
                
                simulatorSocket.send(sendPacket);                
               Thread.sleep(2);
            }   
          
        } catch (Exception ex) {
            System.out.println("Error : "+ex + ex.getMessage());
        }finally
        {
            if(simulatorSocket != null)
                    simulatorSocket.close();            
        }
        
    }
    public static void main(String [] s) throws Exception
   {
   
  // System.out.println(InetAddress.getLocalHost().getHostAddress());
       Thread.sleep(2000);
       new SimulatorUDP();
   }
    
}
