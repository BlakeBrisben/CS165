class A{
    public A(){
       System.out.println("Inside constructor of class A!");
    }
}

public class B extends A{
    public B(){
        System.out.println("Inside constructor of class B!");
    }

    public static void main(String[]args){
        B bObj=new B();
    }
}
