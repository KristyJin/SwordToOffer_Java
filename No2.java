package JianzhiOffer;

/**
 * 实现单例模式，即Singleton
 */
public class No2 {
    //饿汉式线程安全
    static class A {
        //使用final，保证安全，类不能被继承
        private static final A a = new A();

        public static A getInstance() {
            return a;
        }
    }

    //懒汉式线程安全写法
    static class B {
        private B() {
        }

        private static B B = null;

        public static B getInstance() {
            if (B == null) {
                synchronized (B.class) {
                    if (B == null)
                        B = new B();
                }
            }
            return B;
        }
    }

    // 静态内部类方式 线程安全
    static class C {
        private C() {}

        private static class CHolder {
            private static final C INSTANCE = new C();
        }

        public static C getInstance() {
            return CHolder.INSTANCE;
        }
    }
}
