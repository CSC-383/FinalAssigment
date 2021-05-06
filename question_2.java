package finalassignment;

abstract class Parent {

    static void m1() {
        System.out.println("from parent " + "static m1()");
    }

    abstract void m2();   // abstarct method has no body and also small letter

}

class Child extends Parent {

    static void m1() {
        System.out.println("from child static m1()");
    }

    public void m2() {   // no need abstract keyword to declare abstract method
        System.out.println("from child " + "non-static(instance) m2()");
    }

}

public class question_2 {

    public static void main(String[] args) {
        Parent obj1 = new Child();
        obj1.m1();
        obj1.m2();//we don't create obj2 
    }

}
