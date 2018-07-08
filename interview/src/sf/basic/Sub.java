package sf.basic;
class Sup{
    public long getLength()
    {
        return new Integer(4);
    }
}
public class Sub extends Sup{
    public long getLength()
    {
        return new Integer(5);
    }

    public static void main(String[] args) {
        Sup sup = new Sup();
        Sub sub = new Sub();
        System.out.println("sub.getLength() = " + sub.getLength());
        System.out.println("sup.getLength() = " + sup.getLength());
    }
}
