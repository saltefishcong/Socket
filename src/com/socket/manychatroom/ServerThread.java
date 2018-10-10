package com.socket.manychatroom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {

	static final List<Socket> list = new ArrayList<>();

	private Socket socket;

	public ServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream in = socket.getInputStream(); // 获取的对应socket的输入流,两个不同socket不能获取对方的消息
			DataInputStream input = new DataInputStream(in);

			while (true) {
				String msg = input.readUTF(); // 获取对应socket发送的消息
				for (int i = 0; i < list.size(); i++) {
					Socket socket2 = list.get(i); // 从列表中获取socket
					if (socket != socket2) { // 找出不是发送当前消息的socket
						new DataOutputStream(socket2.getOutputStream()).writeUTF(msg);
						// 把当前消息写进其他socket的输出流,这样其他socket就能通过其对应的输入流获取消息
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			list.remove(socket); // 当用户离开时 将离开用户的socket从列表中删除
			try {
				socket.close(); // 关闭用户socket
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
