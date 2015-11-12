package com.avinea.currentweatherdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avinea.currentweatherdemo.api.ApiClient;
import com.avinea.currentweatherdemo.model.CurrentWeather;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.edittext_city) EditText edittext_city;
    @Bind(R.id.button_get_weather) Button button_get_weather;
    @Bind(R.id.textview_city) TextView textview_city;
    @Bind(R.id.textview_speed) TextView textview_speed;
    @Bind(R.id.textview_temperature) TextView textview_temperature;
    @Bind(R.id.textview_humidity) TextView textview_humidity;
    @Bind(R.id.textview_sunrise) TextView textview_sunrise;
    @Bind(R.id.textview_sunset) TextView textview_sunset;
    @Bind(R.id.textview_degrees) TextView textview_degrees;

    @Bind(R.id.linearlayout_details)
    LinearLayout linearlayout_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_get_weather)
    public void getWeather(Button button) {

        if (edittext_city.getText().length() == 0 ){
            Toast.makeText(getApplicationContext(), "Please enter city.", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiClient.getOpenWeatherApiClient().getCityCurrentWeather(edittext_city.getText().toString().trim(), ApiClient.API_KEY, new Callback<CurrentWeather>() {

            @Override
            public void success(CurrentWeather currentWeather, Response response) {

                CurrentWeather weather = currentWeather;

                textview_city.setText("Location: "+ weather.getName() + " , " + weather.getSys().getCountry());
                textview_speed.setText("Speed: "+ weather.getWind().getSpeed());
                textview_temperature.setText("Temperature: "+ weather.getMain().getTemp());
                textview_humidity.setText("Humidity: "+ weather.getMain().getHumidity());

                long sunrise = Long.valueOf(weather.getSys().getSunrise());
                long sunset = Long.valueOf(weather.getSys().getSunset());

                textview_sunrise.setText("Sunrise: "+ new Date(sunrise * 1000));
                textview_sunset.setText("Sunset: "+ new Date(sunset * 1000));
                textview_degrees.setText("Degree: "+ weather.getWind().getDeg());

                linearlayout_details.setVisibility(View.VISIBLE);
            }

            @Override
            public void failure(RetrofitError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                linearlayout_details.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}