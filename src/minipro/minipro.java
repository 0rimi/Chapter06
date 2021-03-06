package minipro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class minipro {
	
	public static void main(String[] args) throws IOException{
		
		//일단 있던 데이터 읽어오기
		InputStream is = new FileInputStream("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		
		//데이터 쓰는거 만들어주기 ^ㅡ^..
		OutputStream os = new FileOutputStream("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");		
		BufferedWriter bw = new BufferedWriter(osw);
		
		
		//일단 리스트 만들기
		List<Phone> pList = new ArrayList<Phone>();
		
		
		//시작화면
		System.out.println("*********************************");
		System.out.println("*"+"\t전화번호 관리 프로그램\t"+"\t"+"*");
		System.out.println("*********************************");
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("----------------------------------");
	
		
		//반복문 만들기(입력받은값 리스트에 추가, 데이터에 추가)
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print(">메뉴번호:");
			int num = sc.nextInt();
			
			//읽어온 데이터 리스트에 추가하기(리스트정의하고 시작.)
			while(true) {
				//한줄받고
				String str = br.readLine();
				if(str==null) {
					break;
				}
				//','단위로 쪼개서 리스트에 넣기
				String[] pinfo = str.split(",");
				Phone p = new Phone(pinfo[0],pinfo[1],pinfo[2]);
				pList.add(p);
			}
			//읽기종료
			br.close();
			
			
			//탈출조건(5번일때)
			if(num==5) {
				System.out.println("*********************************");
				System.out.println("*"+"\t"+"\t감사합니다\t"+"\t"+"*");
				System.out.println("*********************************");
				break;
			}
			
			//1번일때
			else if(num==1) {
				System.out.println("<1.리스트>");
				//출력
				//단 리스트넘버+1이 실제 출력 넘버
				for(int i=0; i<pList.size(); i++) {
					System.out.print((i+1)+". ");
					pList.get(i).print();
				}
			}
			
			//2번일때
			//값을 입력받고, 리스트에 등록한 후, 파일에 업데이트.
			else if(num==2) {
				
				System.out.println("<2.등록>");
				//입력받기
				System.out.print(">이름 : ");
				String name = sc.nextLine();
				System.out.print(">휴대전화 : ");
				String hp = sc.nextLine();
				System.out.print(">회사전화 : ");
				String company = sc.nextLine();
				
				//리스트에 등록
				Phone np  = new Phone(name,hp,company);
				pList.add(np);
				
				//파일에 업데이트(새로쓰기)
				for(int i=0; i<pList.size(); i++) {
					bw.write(pList.get(i).info());
					bw.newLine();
				}
				
				bw.close();
			}
			
			
			//3번일때
			//삭제할 번호 입력받고((번호-1)번리스트 삭제), remove, 파일 업데이트
//			else if(num==3) {
//				System.out.println("<2.삭제>");
//				//입력받기
//		
//				
//				//파일에 업데이트(새로쓰기)
//				for(int i=0; i<pList.size(); i++) {
//					bw.write(pList.get(i).info());
//					bw.newLine();
//				}
//				bw.close();
//			}
			
			//꼬릿말
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------");
		}	
		
		
		
		sc.close();
		
	}

}
