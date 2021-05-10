package finalAssignment;
interface A {

    void a();

    void b();

    void c();

}

abstract class B implements A {

    public void c() {
        System.out.println("This is C");
    }
}

class D extends B {

    public void a() {
        System.out.println("This is  A");
    }

    public void b() {
        System.out.println("This is  B");
    }
}

class Test {

    public static void main(String args[]) {
        A a = new D();
        a.a();
        a.b();
        a.c();
    }
}
