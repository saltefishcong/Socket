package com.socket.manychatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(8901);
			while (true) {
				Socket socket = server.accept();
				ServerThread sThread = new ServerThread(socket); // 将socket传递给管理类
				sThread.list.add(socket); // 列表添加socket
				sThread.start(); // 每一个socket都有自己的管理类线程
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
