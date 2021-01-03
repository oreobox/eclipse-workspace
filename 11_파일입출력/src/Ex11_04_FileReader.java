// FileWriter&FileReader 문자스트림 사용해 한글 데이터 입출력하기

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex11_04_FileReader {

	public static void main(String[] args) {

		try {
//			FileReader와 write.txt의 연결다리는 fw라는 다리를 타고감
			FileWriter fw = new FileWriter("write.txt"); // FileWriter라는 객체 만듬
			fw.write("즐거운 자바수업~"); // write.txt에 해당 내용 출력하기 // try괄호 밖에다 사용하면 IOException 발생
			fw.close(); // 더이상 쓸 것이 없을 때  // try괄호 밖에다 사용하면 IOException 발생
			
			// write.txt 파일이 없으면 FileNotFoundException 발생될 수 있음 
			FileReader fr = new FileReader("write.txt"); //한글 읽어올때는 FileReader라는 클래스 사용 // fr 다리 타고는 읽기만 가능
			// new FileNotFoundException() 가 만들어짐
			
			int i;
			// 몇글자 읽을지 모르니까 한글짜씩 읽어서 while로 반복 
			while( (i=fr.read()) != -1) { // -1이 아닐 경우 true ↓ 아래 출력
				System.out.print((char)i); //문자로 바꿔서 콘솔에 입력하기
				
			}
			fr.close(); // try괄호 밖에다 사용하면 IOException 발생
			
			
			
			//IOException e = new FileNotFoundException() - FileNotFoundException이 IOException을 상속받기 때문에 두번 안써줘도됨 : 다형성
		} catch (IOException e) {
			e.printStackTrace();
		} 

	} // main

} // class


//파일에 '즐거운 자바 수업' 출력하고 
//파일에 써놓은 '즐거운 자바 수업'을 읽어와서
//콘솔에 출력하는 예제다