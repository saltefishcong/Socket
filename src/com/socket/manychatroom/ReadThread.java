package com.socket.manychatroom;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReadThread extends Thread {

	private Socket socket;

	public ReadThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream in = socket.getInputStream();
			DataInputStream input = new DataInputStream(in);
			while (true) {
				String msg = input.readUTF();
				System.out.println(msg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("服务器崩溃了 ");
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
