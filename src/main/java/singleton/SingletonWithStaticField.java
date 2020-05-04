package singleton;

import java.io.Serializable;

//not a preferred way
public class SingletonWithStaticField implements Serializable {
    public static final SingletonWithStaticField INSTANCE = new SingletonWithStaticField();

    private SingletonWithStaticField() {}

}
