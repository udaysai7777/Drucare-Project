public class Predicate {
	public static void main(String[] args) {
		Predicate<Integer> predicate =(i)-> {
		if(i%2==0)
		{
			return true;
		}
			else {
				return false;
			}
		};
		System.out.pritnln(predicate.test(20));
	}
}
