interface Demo
{
int sub(int a,int b);
}
class Lamda
{
public static void main(String args[])
{
Demo d=(a,b)->a-b;
int x=d.sub(100,60);
System.out.println(x);
}
}

