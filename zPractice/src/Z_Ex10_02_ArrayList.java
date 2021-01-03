import java.util.ArrayList;

public class Z_Ex10_02_ArrayList {
	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.size();
		System.out.println("size:"+list.size());
		
		list.add("태연");
		list.add("수영");
		list.add("윤아");
		list.add("수영");
		list.add("써니");

		list.size();
		System.out.println("size:" + list.size());
		System.out.println("list:" + list);
		System.out.println("list:" + list.toString());
		System.out.println("get1:"+ list.get(1));
		
		list.add(1, "유리");
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.remove("윤아");
		System.out.println(list.toString());
		
		int pos1 = list.indexOf("수영");
		System.out.println("pos1:"+pos1);
		
		System.out.println(list.indexOf("효리"));
		System.out.println(list.contains("수영"));
		
		list.set(1, "티파니");
		System.out.println(list);
		
		
		
	}

}
