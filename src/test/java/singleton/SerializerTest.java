package singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SerializerTest {

    private final String fileName = "test.txt";

    private void serialize(Object instance) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(instance);
        fileOutputStream.close();
        objectOutputStream.close();
    }

    private Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object instance = objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();
        return instance;
    }

    @Test
    void shouldCreateDuplicateInstanceOnDeserializing() throws IOException, ClassNotFoundException {
        serialize(SingletonWithStaticField.INSTANCE);
        SingletonWithStaticField deserializedInstance1 = (SingletonWithStaticField) deserialize();
        SingletonWithStaticField deserializedInstance2 = (SingletonWithStaticField) deserialize();
        assertNotEquals(deserializedInstance1, deserializedInstance2);
    }

    @Test
    void shouldNotCreateDuplicateInstanceOnDeserializing() throws IOException, ClassNotFoundException {
        serialize(Singleton.INSTANCE);
        Singleton deserializedInstance1 = (Singleton) deserialize();
        Singleton deserializedInstance2 = (Singleton) deserialize();
        assertEquals(deserializedInstance1, deserializedInstance2);
    }
}
