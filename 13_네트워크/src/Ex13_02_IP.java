import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Ex13_02_IP {
	public static void main(String[] args) {


		System.out.println("웹 사이트 주소를 입력하세요 -> ");
//		www.naver.com/223.130.195.95
//		www.naver.com/125.209.222.141
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
//		String url = br.readLine(); // 한줄만 입력하면 오류 날 수 있기 때문에 try/catch로 묶어줌
		try {
			String url = br.readLine(); // www.naver.com
			
			// getAllByName : 입력한 url을 주소로 바꿔주는 메소드
			InetAddress[] adress = InetAddress.getAllByName(url);
			
			for(int i=0;i<adress.length;i++) {
				System.out.println(adress[i]); // address 각 방에 어느 주소가 들어가있까?
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

//출력화면 : 
//웹 사이트 주소를 입력하세요 -> 
//www.naver.com
//www.naver.com/223.130.195.95
//www.naver.com/125.209.222.141
