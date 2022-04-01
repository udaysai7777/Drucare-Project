
import java.util.function.Predicate;

public class Udayp{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<Integer> lessThan = a -> a>50;
		Predicate<Integer> gt = a -> a<50;
		Predicate<Integer> eq = a -> a==50;
		boolean resultLessThan = lessThan.test(20);
//		System.out.println(resultLessThan);
//		System.out.println(gt.test(20));
//		System.out.println(eq.test(20));
		// and or method, logical operator
		
		System.out.println("And" + gt.and(lessThan).test(20));
		System.out.println("And" + gt.or(lessThan).test(20));
		System.out.println("And" + gt.or(eq).test(20));
	}

}


