package com.example.recyclerviewtester;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrencyApi {

//    taken from https://exchangeratesapi.io/

    @GET("latest?base=RUB")
    Call<Currency> loadRubRates();
}
