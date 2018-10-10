package com.socket.CustomerService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomerServiceSocket { // 客服,这个版本有缺陷,只能等别人回复才能发送一下个消息

	private static final String[] msg = new String[] { "你好!", "你的问题是:", "好的", "正在处理", "Goodbye" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(8889);
			Socket socket = server.accept();
			InputStream in = socket.getInputStream();
			DataInputStream input = new DataInputStream(in);
			OutputStream out = socket.getOutputStream();
			DataOutputStream output = new DataOutputStream(out);
			while (true) {
				String msgs = input.readUTF();
				System.out.println("客户端: " + msgs);
				Out(output, msgs);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Out(DataOutputStream output, String msgs) {
		String mg = null;
		if (msgs.equals("你好")) {
			mg = msg[0];
		} else if (msgs.equals("我的问题处理好没有")) {
			mg = msg[3];
		} else if (msgs.equals("我的问题处理好了")) {
			mg = msg[2];
		} else if (msgs.equals("88")) {
			mg = msg[4];
		} else {
			mg = msg[1];
		}
		try {
			output.writeUTF(mg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
