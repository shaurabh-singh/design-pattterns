package dependency_injection.dagger;

import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;

@Module(
        injects = CoffeeApp.class
)
public class DripCoffeeModule {
    @Provides Heater provideHeater() {
        return new ElectricHeater();
    }

    @Inject Pump pump;
}
