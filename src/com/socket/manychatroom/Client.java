package com.socket.manychatroom;

import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static String[] names = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d",
			"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("127.0.0.1", 8901);
			new SendThread(socket, "用户 " + names[(int) (Math.random() * 27)] + names[(int) (Math.random() * 27)])
					.start();
			new ReadThread(socket).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
