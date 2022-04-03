interface Demo
{
default void show()
{
	System.out.println("Drucare 1");
}
static void display()
{
	System.out.println("Drucare 2");
}
class Uday1 implements Demo
{
	public static void mian(String args[])
	{
		Uday1 d=new Uday1();
		d.show();
		Demo.display();
	}
}
}



