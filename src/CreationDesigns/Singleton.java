package CreationDesigns;

public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}
    public static Singleton getInstance() {
        return INSTANCE;
    }
}

class Singleton1 {
    private static Singleton1 INSTANCE;

    private Singleton1() {}

    public static Singleton1 getINSTANCE() {
        if (INSTANCE==null) {
            INSTANCE = new Singleton1();
        }
        return INSTANCE;
    }
}

class Singleton2 {
    private static Singleton2 INSTANCE;

    private Singleton2() {}

    private static synchronized Singleton2 getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }
}

class Singleton3 {
     private static Singleton3 instance;

     private Singleton3() {}

    public static Singleton3 getInstance() {
         if (null == instance){
             synchronized (Singleton3.class) {
                 if(null == instance) {
                     instance = new Singleton3();
                 }
             }
         }
         return instance;
    }
}

class Singleton4 {
    private Singleton4 () {}

    private static class SingleHelper {
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingleHelper.instance;
    }
}
