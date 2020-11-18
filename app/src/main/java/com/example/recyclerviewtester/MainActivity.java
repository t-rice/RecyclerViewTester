package com.example.recyclerviewtester;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

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
                        adapter.updateStrings(rates);
                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }


    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }
}