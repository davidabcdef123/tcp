package updsocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by sc on 2018/12/6.
 */
public class UdpServiceDemo {

    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(8080);
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        datagramSocket.receive(receivePacket);

        System.out.println(new String(receiveData,0,receivePacket.getLength()));

    }
}
