package StructuralDesign;

class FahrenheitTemp {
    public double getTempInFahrenheit() {
        return 98.6;
    }
}

interface CelsiusTemp {
    public double getTempInCelsius();
}


class TemperatureAdapter implements CelsiusTemp {

    private final FahrenheitTemp fahrenheitTemp;

    public TemperatureAdapter(FahrenheitTemp fahrenheitTemp) {
        this.fahrenheitTemp = fahrenheitTemp;
    }
    @Override
    public double getTempInCelsius() {
        double fahrenheitT = fahrenheitTemp.getTempInFahrenheit();
        return (fahrenheitT-32) * 5/9;
    }
}
public class AdapterDesign {
    public static void main(String[] arg) {
        FahrenheitTemp fahrenheitTemp = new FahrenheitTemp();
        CelsiusTemp celsiusTemp = new TemperatureAdapter(fahrenheitTemp);
        System.out.println(celsiusTemp.getTempInCelsius());
    }
}
