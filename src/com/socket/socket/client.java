package com.socket.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("127.0.0.1", 8888);

			InputStream is = s.getInputStream();
			OutputStream out = s.getOutputStream();
			DataInputStream input = input = new DataInputStream(is);
			DataOutputStream output = output = new DataOutputStream(out);

			int i = 0;
			while (i < 100) {

				Out(output);
				Iut(input);
				i++;
			}
			output.close();
			input.close();
			is.close();
			out.close();

			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Out(DataOutputStream output) {
		try {
			Scanner in = new Scanner(System.in);
			String msg = in.next();
			System.out.println("客户端发送消息: " + msg);
			output.writeUTF(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Iut(DataInputStream input) {
		try {
			String b = input.readUTF();
			System.out.println("客户端接受信息:  " + b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
