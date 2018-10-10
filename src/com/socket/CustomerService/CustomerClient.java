package com.socket.CustomerService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CustomerClient { // 客户端

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("127.0.0.1", 8889);
			InputStream in = socket.getInputStream();
			DataInputStream input = new DataInputStream(in);
			OutputStream out = socket.getOutputStream();
			DataOutputStream output = new DataOutputStream(out);
			while (true) {
				Out(output);
				String msg = input.readUTF();
				System.out.println("服务端 " + msg);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void Out(DataOutputStream output) {
		try {
			Scanner in = new Scanner(System.in);
			String msg = in.next();
			output.writeUTF(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
