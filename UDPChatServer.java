import java.net.*;
import java.util.Scanner;

public class UDPChatServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);  // Create a DatagramSocket on port 9876
            System.out.println("Server is waiting for messages...");

            byte[] receiveData = new byte[1024];
            byte[] sendData;
            DatagramPacket receivePacket;
            DatagramPacket sendPacket;
            
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Receive message from client
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client: " + clientMessage);

                // Send message to client
                System.out.print("Server: ");
                String serverMessage = scanner.nextLine();
                sendData = serverMessage.getBytes();
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
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

