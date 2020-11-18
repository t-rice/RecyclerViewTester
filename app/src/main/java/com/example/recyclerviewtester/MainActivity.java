package com.example.recyclerviewtester;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);

        adapter = new ArrayAdapter<>(this, R.layout.list_xml, R.id.oyaebu);
        listView.setAdapter(adapter);

//        updateList(generateStrings());
        NetworkService.getInstance()
                .currencyApi()
                .loadRubRates()
                .enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        if (response.body() == null) {
                            Toast.makeText(getBaseContext(), "Body is empty", Toast.LENGTH_LONG).show();
                            return;
                        }

                        List<String> rates = new ArrayList<>();
                        for (Pair<String, String> pair: response.body().getRatesPair()) {
                            rates.add(pair.first + " " + pair.second);
                        }

//                        List<String> rates = response.body()
//                                .getRatesPair()
//                                .stream()
//                                .map(pair -> pair.first + " " + pair.second)
//                                .collect(Collectors.toList());
                        updateList(rates);
                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void updateList(List<String> content) {
        adapter.clear();
        adapter.addAll(content);
    }

    private List<String> generateStrings() {
        return Arrays.asList("sdfsdfsdf", "fsdfsdfs", "sdfsdfsdf", "cvcvcvcv", "cfsfcvcxv",
                "sdfsdfsdf", "fsdfsdfs", "sdfsdfsdf", "cvcvcvcv", "cfsfcvcxv", "sdfsdfsdf",
                "fsdfsdfs", "sdfsdfsdf", "cvcvcvcv", "cfsfcvcxv"
        );
    }
}