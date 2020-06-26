package calculator;

import calculator.business.Calculadora;
import calculator.business.Translator;
import calculator.business.TranslatorImpl;
import calculator.entities.Language;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TranslatorImplTest {
    Translator translator;
    Language from;
    Language to;

    @BeforeMethod
    public void setUp() throws Exception {
        translator = new TranslatorImpl();
        from = new Language("EN", "English");
        to = new Language("ES", "Spanish");
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testTranslateDummy() throws Exception {
        String response = translator.translate(from, to, "Hello World");
        System.out.println(response);
        Assert.assertEquals(response, "Hola Mundo");

        to.setId("FR");
        to.setName("Frances");
        String response2 = translator.translate(from, to, "Hello World");
        System.out.println(response2);
        Assert.assertEquals(response2, "Bonjour le monde");

        to.setId("RU");
        to.setName("Ruso");
        String response3 = translator.translate(from, to, "Hello World");
        System.out.println(response3);
        Assert.assertEquals(response3, "Привет мир");

    }

    @Test(invocationCount = 10, threadPoolSize = 5)
    public void testCalculadora() throws Exception{
        int response;
        double response2;

        response = Calculadora.suma(Integer.MAX_VALUE, 2);
        System.out.println(response);
        Assert.assertEquals(response, 5);

        response = Calculadora.resta(3, 2);
        System.out.println(response);
        Assert.assertEquals(response, 1);

        response = Calculadora.multiplicacion(3, 2);
        System.out.println(response);
        Assert.assertEquals(response, 6);

        response2 = Calculadora.division(3.0, 2.0);
        System.out.println(response2);
        Assert.assertEquals(response2, 1.5);

        response = Calculadora.potencia(3, 2);
        System.out.println(response);
        Assert.assertEquals(response, 9);
    }

}