package com.socket.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class test {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 8901);
			Socket socket2 = new Socket("127.0.0.1", 8901);
			Socket socket3 = socket;
			System.out.println(socket.equals(socket2));
			System.out.println(socket == socket2);
			System.out.println(socket3.equals(socket));
			System.out.println(socket3 == socket);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
