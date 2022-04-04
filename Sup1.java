import java.util.function.*;
public class Sup1 {

	public static void main(String[] args) {
		Supplier<String> s=()->"welcome".toUpperCase();
		Supplier<String> s4=()->"UDAY".toLowerCase();
		String s2=s.get();
		String s3=s4.get();
            System.out.println(s2);
            System.out.println(s3);
	}

}
