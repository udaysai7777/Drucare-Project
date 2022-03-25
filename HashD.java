import java.util.HashMap;

public class HashD {

	public static void main(String[] args) {
String s="English Telugu Hindi Marati Telugu English Tamil";
HashMap<String, Integer> hm=new HashMap<>();
String[] sp= s.split(" ");
for(String n:sp)
{
if(hm.get(n)!=null)
{
	hm.put(n, hm.get(n)+1);
}
else
{
	hm.put(n, 1);
}
	}
	System.out.println(hm);
}
}