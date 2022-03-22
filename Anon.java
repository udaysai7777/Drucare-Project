interface A 
{
	void uday();
}
class Anon
{
	public static void main(String[] args)
	{
		A a =new A()
		{
			public void uday()
			{
				System.out.println("which has no name");
			}
				};
	       a.uday();
	}
}
