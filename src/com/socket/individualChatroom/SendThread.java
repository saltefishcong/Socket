package com.socket.individualChatroom;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread { // 发送消息线程,使用了多线程实现了多次发送功能

	private Socket socket;

	public SendThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
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
				output.writeUTF(msg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
