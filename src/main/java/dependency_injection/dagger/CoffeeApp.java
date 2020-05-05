package dependency_injection.dagger;

import dagger.ObjectGraph;

import javax.inject.Inject;

//this class generate a graph which shows the relation between the dependencies
public class CoffeeApp implements Runnable {
    @Inject
    CoffeeMaker coffeeMaker;
    public static void main(String[] args) {
        ObjectGraph objectGraph = ObjectGraph.create(new DripCoffeeModule());
        CoffeeApp coffeeApp = objectGraph.get(CoffeeApp.class);
    }

    @Override
    public void run() {
        coffeeMaker.brew();
    }
}
