// AKS 2020 York Online Masters
// --------UDPClient-----------
// Socket Communications - UDP
import java.io.*;
import java.net.*;

class UDPClient {
public static void main(String args[]) throws Exception
{
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	DatagramSocket clientSocket = new DatagramSocket();
	InetAddress IPAddress = InetAddress.getByName("localhost");

	byte[] newData = new byte[1024];
	byte[] sendData = new byte[1024];
	byte[] receiveData = new byte[1024];
	String sentence = inFromUser.readLine();

	sendData = sentence.getBytes();
	DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress, 9876);
	clientSocket.send(sendPacket);

	DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
	clientSocket.receive(receivePacket);
	
	
	String confirm = "Data confirmation from client";
	newData = confirm.getBytes();
	DatagramPacket newPacket = new DatagramPacket(newData, newData.length,IPAddress, 9876);
	clientSocket.send(newPacket);
	
	
	String modifiedSentence = new String(receivePacket.getData());
	System.out.println("FROM SERVER:  " + modifiedSentence);
	
	

	clientSocket.close();
}

}



