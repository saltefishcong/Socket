package com.socket.individualChatroom;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ReadThread extends Thread { // 读取消息线程,使用了多线程实现了多次读取功能

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
				System.out.println("收到  " + socket + "  消息  " + msg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
