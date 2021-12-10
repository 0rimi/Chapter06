package minipro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class minipro {
	
	public static void main(String[] args) throws IOException{
		
		//일단 있던 데이터 읽어오기
		InputStream is = new FileInputStream("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		
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
			
			//탈출조건
			if(num==5) {
				System.out.println("*********************************");
				System.out.println("*"+"\t"+"\t감사합니다\t"+"\t"+"*");
				System.out.println("*********************************");
				break;
			}
			
			//1번일때
			//읽어온 데이터 리스트에 추가하기+리스트만들기
			else if(num==1) {
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
				System.out.println("<1.리스트>");
				//출력
				//단 리스트넘버+1이 실제 출력 넘버
				for(int i=0; i<pList.size(); i++) {
					System.out.print((i+1)+". ");
					pList.get(i).print();
				}

				br.close();
			}
			
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------");
			
			
		}		

		sc.close();
		
	}

}
