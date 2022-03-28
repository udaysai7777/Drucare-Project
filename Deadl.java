
public class Deadl {

	public static void main(String[] args) {
        final String s1="uday";
		final String s2="sai";
		Runnable run1= ()->{
			synchronized(s1){
				System.out.println(Thread.currentThread()+":locked "+s1);
				try {
					Thread.sleep(100);
				}catch(Exception e) {
				}
			synchronized (s2) {
				System.out.println(Thread.currentThread()+":locked"+s2);
				}
		}
};

Runnable run2=()->{
	synchronized(s2) {
		System.out.println(Thread.currentThread()+"locked" +s2);
		try {
			Thread.sleep(100);
		}catch(Exception e) {
	}
synchronized(s1) {
	System.out.println(Thread.currentThread()+":locked"+s1);
}
}
};
Thread t1=new Thread(run1);
t1.setName("First");
Thread t2=new Thread(run2);
t2.setName("second");
t1.start();
t2.start();
}
}
