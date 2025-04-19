package BehaviouralDesign.DecoratorPattern;

public class DecoratorClient {

    public static void main(String[] arg) {
        BasePizza pizza = new ExtraCheese(new Farmhouse());
        System.out.println(pizza.cost());
    }
}
