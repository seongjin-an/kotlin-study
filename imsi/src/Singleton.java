public class Singleton {
    private static Singleton instance = null;
    private String s;
    private Singleton(String str){
        s = str;
    }
    public static Singleton getInstance(String str){
        if(instance == null) {
            instance = new Singleton(str);
        }
        return instance;
    }
    public String getS() { return s; }
    public void setS(String s) { this.s = s; }
}