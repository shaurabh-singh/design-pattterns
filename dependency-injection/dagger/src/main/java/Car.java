import javax.inject.Inject;

public class Car {
    private Engine engine;
    private Brand brand;

    @Inject
    public Car(Engine engine, Brand brand) {
        this.engine = engine;
        this.brand = brand;
    }
    public Engine getEngine() {
        return engine;
    }

    public Brand getBrand() {
        return brand;
    }
}