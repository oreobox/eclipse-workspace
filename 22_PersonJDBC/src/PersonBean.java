// 레코드 한줄, 사용자 입력한 정보를 담을 수 있는 클래스
// 여러 데이터를 하나로 묶을 수 있는 클래스 : Bean
public class PersonBean {
	
	//1. 레코드 한줄을 담을 수 있는 변수 생성
	// 멤버변수
	private int num;
	private String name;
	private int age;
	private String gender;
		
	//3. 생성자 : 클래스와 이름이 동일	
	public PersonBean(int num, String name, int age, String gender, String birth) {
		super();
//		int a; // 지역변수
		this.num = num;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birth = birth;
				
	//2. 넣은 값 다른 클래스에서도 사용할 수 있도록 getter,setter 불러옴
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	private String birth;

}
