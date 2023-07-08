import java.util.ArrayList;

public class basics {
	
	public static void main(String[] args) {
//		int age = 26;
//		String name = "Kowal";
//		
//		String[] auta = {"audi", "opel"};
//		
//		int[] numbers = new int[10];
//		
//		for(int i = 0; i <numbers.length; i++) {
//			numbers[i] = i+1;
//		}
//		
//		
//		System.out.println(name + " ma " + age + " lat");
//		for(String auto : auta) {
//		System.out.print(auto + ", ");
//		}
//		System.out.println();
//		
//		for(int number : numbers) {
//			System.out.println(number);
//		}
//		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		
//		for(int i = 1; i <34; i+=3) {
//			list.add(i*3);
//		}
//		
//		for(int i = 0; i<list.size(); i++) {
//			if(i < list.size()-1) {
//				System.out.print(list.get(i) + ", ");
//			}
//			else {
//				System.out.println(list.get(i));
//			}
//			
//		}
//		
//		for(int i : list) {
//			System.out.println(i);
//		}
		
		String valToBeSplitted = "Practice extracting 'this' word from text";
		String[] splitted = valToBeSplitted.split("'");
		System.out.print(splitted[1]);		
		
	}

}
