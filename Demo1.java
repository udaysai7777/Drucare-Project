class Vehicle
{
String vtype;
String color;
int model;
int tyres;
int passengers;
float price;
Vehicle(String vtype,String color,int model,int tyres,int passengers,float price)
{
this.vtype=vtype;
this.color=color;
this.model=model;
this.tyres=tyres;
this.passengers=passengers;
this.price=price;
}
}
class Demo1
{
public static void main(String args[])
{
Vehicle v1=new Vehicle("car","red",2014,4,5,200.000f);
Vehicle v2=new Vehicle("van","blue",2016,4,8,300.000f);
System.out.println(v1.vtype+"\n"+v1.color+"\n"+v1.model+"\n"+v1.tyres+"\n"+v1.passengers+"\n"+v1.price);
System.out.println(v2.vtype+"\n"+v2.color+"\n"+v2.model+"\n"+v2.tyres+"\n"+v2.passengers+"\n"+v2.price);
}
}


