import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Stream
{
public static void main(String[] args) 
	{
	//	List<String> cityList = Arrays.asList("hyderabad","bangalore" , "",
				//"delhi","tokyo","chicago","","jammukashmir","Chennai","bombay","guwahati","secunderabad");
		
		List<Integer> citynos = Arrays.asList(13,56,72,45,58,62,19,21,46,28);
//		List<String> result = cityList.stream().filter(n -> n.startsWith("c")).sorted().collect(Collectors.toList());
//		System.out.println(result);
	//	List<String> result = cityList.stream().filter(n -> !n.isEmpty()).sorted().collect(Collectors.toList());
		//System.out.println(result);
	//	List<String> result = cityList.stream().filter(n -> n.length()>9).sorted().collect(Collectors.toList());
		//System.out.println(result);
		//List<String> result = cityList.stream().filter(n -> n.endsWith("i")).sorted().collect(Collectors.toList());
		//System.out.println(result);
	//	List<String> result = cityList.stream().map(n -> n.concat("India")).collect(Collectors.toList());
		//System.out.println(result);
		//List<String> result = cityList.stream().filter(n -> n.charAt()).sorted().collect(Collectors.toList());
		//System.out.println(result);
		//List<Integer> result = citynos.stream().filter(n -> n%2==0).sorted().collect(Collectors.toList());
			//	System.out.println(result);
			//	List<Integer> result= citynos.stream().filter(n -> n>30).sorted().collect(Collectors.toList());
				//System.out.println(result);
	//	List<Integer> result = citynos.stream().map(n -> n+8).sorted().collect(Collectors.toList());
		//System.out.println(result);
		List<Integer> result = citynos.stream().map(n->n.MAX_VALUE).collect(Collectors.toList());
		System.out.println(result);


	
	

	
	
	
	
	
	
	
	
	
	}
}


