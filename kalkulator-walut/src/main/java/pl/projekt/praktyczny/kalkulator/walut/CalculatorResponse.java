package pl.projekt.praktyczny.kalkulator.walut;


import java.util.Map;



public class CalculatorResponse {

    private Integer Id;


    private Map<String, Double> rates;


    private String base;

    private String date;


    public Map<String, Double> getRates() {
        return rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


//{
//        "rates": {
//        "CAD": 1.5619,
//        "HKD": 9.3535,
//        "ISK": 155.4,
//        "PHP": 57.984,
//        "DKK": 7.4438,
//        "HUF": 357.4,
//        "CZK": 26.411,
//        "AUD": 1.6384,
//        "RON": 4.8714,
//        "SEK": 10.2813,
//        "IDR": 17145.18,
//        "INR": 88.9695,
//        "BRL": 6.2962,
//        "RUB": 91.3194,
//        "HRK": 7.552,
//        "JPY": 126.13,
//        "THB": 36.5,
//        "CHF": 1.0819,
//        "SGD": 1.6176,
//        "PLN": 4.4783,
//        "BGN": 1.9558,
//        "TRY": 9.457,
//        "CNY": 7.9203,
//        "NOK": 10.7003,
//        "NZD": 1.7137,
//        "ZAR": 18.5579,
//        "USD": 1.2066,
//        "MXN": 24.2499,
//        "ILS": 3.9705,
//        "GBP": 0.9049,
//        "KRW": 1330.2,
//        "MYR": 4.9199
//        },
//        "base": "EUR",
//        "date": "2020-12-02"
//        }