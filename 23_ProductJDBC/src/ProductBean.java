// 레코드 한줄, 사용자 입력한 정보를 담을 수 있는 클래스
// 여러 데이터를 하나로 묶을 수 있는 클래스 : Bean = DTO = VO
public class ProductBean {

	private int id;
	private String name;
	private int stock;
	private int price;
	private String category;
	private String inputdate;

	//방법①  생성자 통해서 주입 - 6개 항목을 매개변수로 받는 생성자
	public ProductBean(int id, String name, int stock, int price, String category, String inputdate) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.category = category;
		this.inputdate = inputdate;
	}
	
	// 방법②  setter,getter 통해서 주입
	public ProductBean () {
	}
	
	
	// getter & setter 설정
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

} // ProductBean
