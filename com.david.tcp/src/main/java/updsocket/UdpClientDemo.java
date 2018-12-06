package updsocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by sc on 2018/12/6.
 */
public class UdpClientDemo {

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("localhost");
        byte[] sendData = "hello world".getBytes();
        DatagramPacket sendPacket = new
                DatagramPacket(sendData,sendData.length,address,8080);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(sendPacket);
    }
}
