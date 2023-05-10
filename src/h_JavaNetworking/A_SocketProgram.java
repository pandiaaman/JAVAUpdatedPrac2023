package h_JavaNetworking;

import java.net.ServerSocket;
import java.net.Socket;

/*
 * The client in socket programming must know two information:

	IP Address of Server, and
	Port number.
	
	A socket is simply an end point for communications between the machines. The Socket class can be used to create a socket.
 */
public class A_SocketProgram {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
