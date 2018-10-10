package com.socket.manychatroom;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {

	private Socket socket;

	private String name;

	public SendThread(Socket socket, String name) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			OutputStream out = socket.getOutputStream();
			DataOutputStream output = new DataOutputStream(out);
			while (true) {
				Scanner in = new Scanner(System.in);
				String msg = in.next();
				msg = name + " : " + msg;
				output.writeUTF(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
