package com.socket.individualChatroom;

import java.net.Socket;
import java.net.UnknownHostException;

public class Client { // 客户端

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("127.0.0.1", 8900);
			new SendThread(socket).start();
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
