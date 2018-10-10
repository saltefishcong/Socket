package com.socket.individualChatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server { // 服务器,这个版本是上个客服版本的加强版,实现了不用等待别人回复就能发送下一条消息的功能

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket socket = new ServerSocket(8900);
			Socket soc = socket.accept();
			new SendThread(soc).start();
			new ReadThread(soc).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
