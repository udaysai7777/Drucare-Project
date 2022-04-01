import java.util.function.Predicate;
public class Demo4 implements Predicate<Integer>
{
		public boolean test(Integer t) {
				if(t>100){				
					return true;
				}else
{
					return false;
				}
				}
public static void main(String args[]) 
{
		Predicate<Integer> predicate= new Demo4();
		System.out.println(predicate.test(200));
		}
}


