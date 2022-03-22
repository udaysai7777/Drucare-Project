class Member
{
	class B
	{
		void show()
		{
			System.out.println("Drucare");
			}
	}
}
class Inner1
	{
public static void main(String[] args)
{
   Member m=new Member();
 Member.B b1=m.new B();
 b1.show();
	}
}
	
