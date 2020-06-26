package calculator.business;

import calculator.entities.Language;
import org.springframework.web.client.RestOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TranslatorImpl implements Translator {

    @Override
    public String translate(Language from, Language to, String text) throws IOException {

        //Gracias google
        String transURL = "https://script.google.com/macros/s/AKfycbzoGmBCwj4oNo_LvwCWHRP5lwGy3znqtAypAcsVmiKw6G79dFLR/exec?q=";

        String requestURL = transURL + URLEncoder.encode(text, "UTF-8") +
                "&target=" + to.getId() +
                "&source=" + from.getId();

        URL url = new URL(requestURL);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
