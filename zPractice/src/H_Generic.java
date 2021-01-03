import java.util.ArrayList;

class LandAnimal {
	public void crying() {
		System.out.println("육지동물");
	}
}

class Cat extends LandAnimal {
	public void crying() {
		System.out.println("냐옹냐옹");
	}
}

class Dog extends LandAnimal {
	public void crying() {
		System.out.println("멍멍");
	}
}

class Bird{
	public void crying() {
		System.out.println("짹짹");
	}
}

class AnimalList<T> {
	ArrayList<T> al = new ArrayList<T>();

	void add(T animal) {
		al.add(animal);
	}

	T get(int index) {
		return al.get(index);
	}

	boolean remove(T animal) {
		return al.remove(animal);
	}

	int size() {
		return al.size();
	}
} // AnimalList

public class H_Generic {

	public static void main(String[] args) {

		AnimalList<LandAnimal> landAnimal = new AnimalList<>();
		landAnimal.add(new LandAnimal());
		landAnimal.add(new Cat());
		landAnimal.add(new Dog());
//		landAnimal.add(new Bird()); // LandAnimal을 상속받지 않았기 때문에 오류남
		
		for(int i = 0; i< landAnimal.size(); i++) {
			landAnimal.get(i).crying();
		}
		

	} // main

} // class
