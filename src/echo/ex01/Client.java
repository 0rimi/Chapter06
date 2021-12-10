package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("==============================");
		
		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.0.105", 10001));
		//2. 접속시도, 연결.
		
		System.out.println("[서버에 연결 되었습니다.]");
		
		//이미 연결되어 있어서 아웃풋스트림을 new로 불러올필요 x
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//메세지 받기
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		//보내기
		bw.write("안녕하세요");
		bw.newLine();
		bw.flush();
		
		//받기
		String reMsg = br.readLine();
		System.out.println("server :["+reMsg+"]");
		
		br.close();
		bw.close();
		socket.close();
		
	}

}
