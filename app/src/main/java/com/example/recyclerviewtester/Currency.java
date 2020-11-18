package com.example.recyclerviewtester;

import androidx.core.util.Pair;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Currency {

    @SerializedName("base")
    private String base;
    @SerializedName("date")
    private String date;
    @SerializedName("rates")
    private Rates rates;

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Rates getRates() {
        return rates;
    }

    public List<Pair<String, String>> getRatesPair() {
        return Arrays.asList(
                Pair.create("USD", rates.getUsdValue()),
                Pair.create("EUR", rates.getEurValue()),
                Pair.create("RUB", rates.getRubValue())
        );
    }

    public class Rates {

        @SerializedName("USD")
        private String usdValue;
        @SerializedName("EUR")
        private String eurValue;
        @SerializedName("RUB")
        private String rubValue;

        public String getUsdValue() {
            return usdValue;
        }

        public String getEurValue() {
            return eurValue;
        }

        public String getRubValue() {
            return rubValue;
        }
    }
}
