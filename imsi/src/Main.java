public class Main {
    public static void main(String[] args){
        Singleton singleton1 = Singleton.getInstance("singleton1");
        Singleton singleton2 = Singleton.getInstance("singleton2");
        Singleton singleton3 = Singleton.getInstance("singleton3");
        System.out.println(singleton1.getS());
        System.out.println(singleton2.getS());
        System.out.println(singleton3.getS());
        singleton1.setS("ChangeString");
        System.out.println(singleton1.getS());
        singleton1.setS("ChangeString2");
        System.out.println(singleton2.getS());
        singleton1.setS("ChangeString3");
        System.out.println(singleton3.getS());
        Scope person = Scope.Companion.getInstance();
    }
}
