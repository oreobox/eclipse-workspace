import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11_07_InputStreamReader {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 입력받지만, 문자로도 입력받을수 있음. 제일 안에것부터 해석하기
																				
		String str;
		try {
			System.out.print("파일의 이름을 입력하세요-> "); // 밖에있어도되고 안에있어도됨
			String fileName = br.readLine(); // c:\\sun\\abc.txt

			System.out.println("파일에 저장할 내용을 입력하세요.");
			FileWriter fw = new FileWriter(fileName); // 연결다리 fw 생성되면서 c:\\sun\\abc.txt 파일이 자동으로 생김
													  // c드라이브에 미리 sun이라는 파일은 생성해줘야함
			BufferedWriter bw = new BufferedWriter(fw); // 사이즈 지정 해도되고 안해도됨 예): (fw,5)
						
			while ((str = br.readLine()) != null) { // ctrl+z (ctrl+z 대신 (q)다른 것 써도됨-임의지정)를 입력하면 str에 null값 입력됨 // null이 되면 반복작업 마침
				bw.write(str); // bw자리 타고가서 써라 // 가나다, 마바사 등등 값 입력을 null 될때까지 반복
//				bw.write("\r\n");//출력화면에 엔터 기능 삽입하고 싶을 때(맨 앞줄로 가서 한칸 밑으로 떨어지라는 뜻)
				bw.newLine(); // 엔터 치라는 메소드
				
			}
			System.out.println("여기까지 입력은 끝");
			bw.close(); // bw닫으면 fw도 연결되어있어서 닫아짐
			// bw.close();를 주석처리 해놓으면 8192 기본 갯수 채워질때까지 Buffer에 보관되어있기 때문에 콘솔에 출려안됨
			br.close(); // 키보드에 입력되는 br도 닫기
			
			
//			FileReader fr = new FileReader(fileName);
//			BufferedReader br2 = new BufferedReader(fr);
			BufferedReader br2 = new BufferedReader(new FileReader(fileName));
			
			String str2;
			while ( (str2 = br2.readLine()) != null) { // EOF를 만나면 null이 들어감.
				System.out.println(str2);
			}
			
			br2.close();
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // main

} // class
