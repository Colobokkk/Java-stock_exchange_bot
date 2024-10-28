package ru.colobokkk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class CBRExchangeRateFetcher {
    private static final String URL = "https://www.cbr.ru/currency_base/daily/";


    protected static double getDollarRate() throws IOException{
        Document doc = Jsoup.connect(URL).get();
        Element rateElement = doc.select("td:contains(USD) + td + td + td").first();
        return  Double.parseDouble(rateElement.text().replace(',', '.'));
    }
    protected static double getEuroRate() throws IOException{
        Document doc = Jsoup.connect(URL).get();
        Element rateElement = doc.select("td:contains(EUR) + td + td + td").first();
        return Double.parseDouble(rateElement.text().replace(',', '.'));
    }
}
