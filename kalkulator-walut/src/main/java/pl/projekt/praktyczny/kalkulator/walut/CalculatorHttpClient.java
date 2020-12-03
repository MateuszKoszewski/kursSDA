package pl.projekt.praktyczny.kalkulator.walut;

import HibernateUtils.CalculatorHttpDb;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalculatorHttpClient {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public CalculatorHttpClient() {
        this.httpClient = HttpClient.newBuilder().build();
        this.objectMapper = new ObjectMapper();
    }

    public double getEuroExchange(String currency){
        return getEuroExchange(    "latest", currency);
    }

    public double getEuroExchange(LocalDate localDate, String currency){
        return getEuroExchange(localDate.format(DateTimeFormatter.BASIC_ISO_DATE), currency);
    }
    public double getEuroExchange(String date, String currency) {
        CalculatorHttpDb calculatorHttpDb = new CalculatorHttpDb();
        Currency searchedCurrency = calculatorHttpDb.findByDate(date, currency);
        if (searchedCurrency == null) {

            String requestUrl = "https://api.exchangeratesapi.io/" + date + "?base=EUR";
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(requestUrl))
                    .build();
            double pln = 0;
            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());  /// zaznaczyc wyrazenie i uzyc skrotu ctrl+alt+v
                String body = response.body();
                CalculatorResponse asObject = objectMapper.readValue(body, CalculatorResponse.class);
                pln = asObject.getRates().get(currency.toUpperCase());
                System.out.println(body);
                Currency value = new Currency(null, asObject.getBase(), currency, pln, date);
                calculatorHttpDb.addCurrency(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return pln;
        } else {
            return searchedCurrency.getRate();
        }
    }


    public static void main(String[] args) {

CalculatorHttpClient calculatorHttpClient = new CalculatorHttpClient();
        System.out.println(calculatorHttpClient.getEuroExchange("usd"));

    }
}
