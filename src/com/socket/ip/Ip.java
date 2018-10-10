package com.socket.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ip {

	private static InetAddress inetAddress;

	public Ip() {
		// TODO Auto-generated constructor stub
		init();
	}

	public void init() {
		try {
			inetAddress = InetAddress.getLocalHost();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String get() {
		return inetAddress.getHostAddress();
	}

	public InetAddress get(String hostname) {
		try {
			return InetAddress.getByName(hostname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public InetAddress get(String ip, int i) {
		try {
			return InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
