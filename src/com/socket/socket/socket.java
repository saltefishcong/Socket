package com.socket.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class socket {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("监听在端口号:8888");
			Socket s = ss.accept();

			InputStream is = s.getInputStream();

			OutputStream out = s.getOutputStream();

			DataInputStream input = input = new DataInputStream(is);

			DataOutputStream output = output = new DataOutputStream(out);
			int i = 0;
			while (i < 100) {
				Iut(input);
				Out(output);
				i++;
			}
			output.close();
			input.close();
			is.close();
			out.close();

			s.close();
			ss.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Out(DataOutputStream output) {
		try {
			Scanner in = new Scanner(System.in);
			String msg = in.next();
			System.out.println("服务器发送消息: " + msg);
			output.writeUTF(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Iut(DataInputStream input) {
		try {
			String b = input.readUTF();
			System.out.println("服务器接受信息:  " + b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
