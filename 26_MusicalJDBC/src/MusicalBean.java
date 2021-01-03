
public class MusicalBean {
	private int no;
	private String actor;
	private String mus_date;
	private String mus_day;
	private int time;
	private int price;

	// 생성자1
	public MusicalBean(int no, String actor, String mus_date, String mus_day, int time, int price) {
		super();
		this.no = no;
		this.actor = actor;
		this.mus_date = mus_date;
		this.mus_day = mus_day;
		this.time = time;
		this.price = price;
	}

	// 생성자2
	public MusicalBean() {

	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getMus_date() {
		return mus_date;
	}

	public void setMus_date(String mus_date) {
		this.mus_date = mus_date;
	}

	public String getMus_day() {
		return mus_day;
	}

	public void setMus_day(String mus_day) {
		this.mus_day = mus_day;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

} // MusicalBean