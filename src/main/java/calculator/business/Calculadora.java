package calculator.business;

import org.hibernate.boot.spi.InFlightMetadataCollector;

public class Calculadora {
    static public int suma(Integer x, Integer y) {
        int z = 0;

        try {
            z = x + y;
            return z;
        } catch (Exception e){
            System.out.println("Something went wrong.");
        }
        return -1;
    }

    static public int resta(Integer x, Integer y) {
        return x - y;
    }

    static public int multiplicacion(Integer x, Integer y) {
        return x * y;
    }

    static public double division(Double x, Double y) {
        return x / y;
    }

    static public int potencia(Integer x, Integer y) {
        Integer z = x;

        for (int i = 0; i < y - 1; ++i) {
            z = z*x;
        }

        return z;
    }

}
