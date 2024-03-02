package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}

	private String sistemaOperacional() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void callIp() {
		String os = sistemaOperacional();
		if (os.contains("Windows")) {
			String windows = "IPCONFIG";
			try {
				Process pwindows = Runtime.getRuntime().exec(windows);
				InputStream fluxowindows = pwindows.getInputStream();
				InputStreamReader leitorwindows = new InputStreamReader(fluxowindows);
				BufferedReader bufferwindows = new BufferedReader(leitorwindows);
				String linhawindows = bufferwindows.readLine();
				while (linhawindows != null) {
					if (linhawindows.contains("IPv4")) {
						String[] ipv4windows = linhawindows.split(":");
						System.out.println(ipv4windows[1]);
					}
					linhawindows = bufferwindows.readLine();
				}
				bufferwindows.close();
				leitorwindows.close();
				fluxowindows.close();
			} catch (Exception e) {

			}
		} else {
			String linux = "ipconfig";
			try {
				Process plinux = Runtime.getRuntime().exec(linux);
				InputStream fluxolinux = plinux.getInputStream();
				InputStreamReader leitorlinux = new InputStreamReader(fluxolinux);
				BufferedReader bufferlinux = new BufferedReader(leitorlinux);
				String linhalinux = bufferlinux.readLine();
				while (linhalinux != null) {
					if (linhalinux.contains("IPv4")) {
						String[] ipv4linux = linhalinux.split(":");
						System.out.println(ipv4linux[1]);
					}
				}
			} catch (IOException e) {
			}
		}
	}

	public void callPing() {
		String os = sistemaOperacional();
		if (os.contains("Windows")) {
			String windows = "ping -4 -n 10 www.google.com.br";
			try {
				Process pwindows = Runtime.getRuntime().exec(windows);
				InputStream fluxowindows = pwindows.getInputStream();
				InputStreamReader leitorwindows = new InputStreamReader(fluxowindows);
				BufferedReader bufferwindows = new BufferedReader(leitorwindows);
				String linhawindows = bufferwindows.readLine();
				while (linhawindows != null) {
					if (linhawindows.contains("M�dia")) {
						String[] pingwindows = linhawindows.split("=");
						System.out.println("A media de ms eh de: " + pingwindows[3]);
					}
					linhawindows = bufferwindows.readLine();
				}
				bufferwindows.close();
				leitorwindows.close();
				fluxowindows.close();
			} catch (Exception e) {

			}
		} else {
			String linux = "ping -4 -c 10 www.google.com.br";
			try {
				Process plinux = Runtime.getRuntime().exec(linux);
				InputStream fluxolinux = plinux.getInputStream();
				InputStreamReader leitorlinux = new InputStreamReader(fluxolinux);
				BufferedReader bufferlinux = new BufferedReader(leitorlinux);
				String linhalinux = bufferlinux.readLine();
				while (linhalinux != null) {
					if (linhalinux.contains("M�dia")) {
						String[] pinglinux = linhalinux.split("=");
						System.out.println("A media de ms eh de: " + pinglinux[3]);
					}
				}
			} catch (IOException e) {
			}
		}
	}

}
