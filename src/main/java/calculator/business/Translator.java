package calculator.business;

import calculator.entities.Language;

import java.io.IOException;

public interface Translator {

    public String translate(Language from, Language to, String text) throws IOException;

}
