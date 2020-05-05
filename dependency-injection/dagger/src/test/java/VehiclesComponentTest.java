import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehiclesComponentTest {

    @Test
    public void givenGeneratedComponent_whenBuildingCar_thenDependenciesInjected() {
        VehiclesComponent component = DaggerVehiclesComponent.create();

        Car carOne = component.buildCar();
        Car carTwo = component.buildCar();

        assertNotNull(carOne);
        assertNotNull(carTwo);
        assertNotNull(carOne.getEngine());
        assertNotNull(carTwo.getEngine());
        assertNotNull(carOne.getBrand());
        assertNotNull(carTwo.getBrand());
        assertNotEquals(carOne.getEngine(), carTwo.getEngine());
        assertEquals(carOne.getBrand(), carTwo.getBrand());
    }
}