package dependency_injection.dagger;

import javax.inject.Inject;

public class Thermosiphon extends Pump {
    private final Heater heater;

    @Inject
    Thermosiphon(Heater heater) {
        this.heater = heater;
    }
}
