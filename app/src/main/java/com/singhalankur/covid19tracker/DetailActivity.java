package com.singhalankur.covid19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvCountry, tvCases, tvRecovered, tvCritical, tvActive, tvTodayCases, tvTotalDeaths, tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int positionCountry = intent.getIntExtra("position", 0);

        getSupportActionBar().setTitle("Details of " + AffectedCountries.modelCountryList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvCountry = findViewById(R.id.tvCountryName);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);

        tvCountry.setText(AffectedCountries.modelCountryList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.modelCountryList.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.modelCountryList.get(positionCountry).getRecovered());
        tvCritical.setText(AffectedCountries.modelCountryList.get(positionCountry).getCritical());
        tvActive.setText(AffectedCountries.modelCountryList.get(positionCountry).getActive());
        tvTodayCases.setText(AffectedCountries.modelCountryList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(AffectedCountries.modelCountryList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.modelCountryList.get(positionCountry).getTodayDeaths());


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}