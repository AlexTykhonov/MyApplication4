package com.tae.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tae.myapplication.dagger2.Component.MyComponent;
import com.tae.myapplication.entity.ApiRetrofit;
import com.tae.myapplication.entity.MotoPojo;

import java.lang.annotation.Inherited;
import java.util.List;

import javax.inject.Inject;
import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inUsername, inNumber;
    Button btnSave, btnGet;
    private MyComponent myComponent;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    ApiRetrofit apiRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);

        initViews();
//        myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
//        myComponent.inject(this);

    apiRetrofit.getMotos().enqueue(new Callback<List<MotoPojo>>() {
        @Override
        public void onResponse(Call<List<MotoPojo>> call, Response<List<MotoPojo>> response) {
            System.out.println("------------->>>  "+response.body());
        }

        @Override
        public void onFailure(Call<List<MotoPojo>> call, Throwable t) {

        }
    });
    }


    private void initViews() {
        btnGet = findViewById(R.id.btnGet);
        btnSave = findViewById(R.id.btnSave);
        inUsername = findViewById(R.id.inUsername);
        inNumber = findViewById(R.id.inNumber);
        btnSave.setOnClickListener(this);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnGet:
                inUsername.setText(sharedPreferences.getString("username", "default"));
                inNumber.setText(sharedPreferences.getString("number", "12345"));
                break;
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", inUsername.getText().toString().trim());
                editor.putString("number", inNumber.getText().toString().trim());
                editor.apply();
                break;

        }
    }
}