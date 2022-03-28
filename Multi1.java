public class Multi1 extends Thread
{
	public void run()
	{
		try{for(int i=1;i<=10;i++)
		{
			System.out.println("child thread");
			Thread.sleep(1000);
		}
		}
		catch(Exception e) {
	System.err.println(e);
		}
		}
	public static void main(String[] args) {
		Multi1 m=new Multi1();
		m.start();
		for(int i=1;i<=10;i++)
		{
			try {
			System.out.println("main thread");
			Thread.sleep(2000);
			if(i==5)
		m.suspend();
			if(i==10)
				m.resume();
	
			}catch(Exception e)
		{
System.err.println(e);
}
	}
}
}