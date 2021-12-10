package echo.ex01;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.105", 10001));
		//IP: 192.168.0.105	port번호: 10001
		//1. 켜놓고 클라이언트의 연결요청 기다리는 상태
		
		System.out.println("<서버시작>");
		System.out.println("=================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		Socket socket = serverSocket.accept();
		//3. 수락~~ 소켓으로 받을게~~
		System.out.println("[클라이언트가 연결되었습니다.]");
		
		//메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//받기
		String msg = br.readLine();
		System.out.println("받은메세지 : "+msg);
		
		//보내기
		bw.write(msg);
		bw.newLine();
		bw.flush();
		
		bw.close();
		br.close();
		socket.close();
		
		serverSocket.close();
		//4. 서버소켓 역할끝!
		
		
	}

}
