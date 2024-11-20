import java.net.*;
import java.util.Scanner;

public class UDPChatClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();  // DatagramSocket on a random port
            InetAddress serverAddress = InetAddress.getByName("localhost");  // Server address
            int serverPort = 9876;  // Server port

            byte[] sendData;
            byte[] receiveData = new byte[1024];
            DatagramPacket sendPacket;
            DatagramPacket receivePacket;

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Send message to server
                System.out.print("Client: ");
                String clientMessage = scanner.nextLine();
                sendData = clientMessage.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                socket.send(sendPacket);

                // Receive message from server
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String serverMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server: " + serverMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}

