package singleton;

//not a preferred way
public class SingletonUsingStaticMethod {
    private static final SingletonUsingStaticMethod INSTANCE = new SingletonUsingStaticMethod();

    private SingletonUsingStaticMethod() {}

    public static SingletonUsingStaticMethod getInstance() {
        return INSTANCE;
    }
}
