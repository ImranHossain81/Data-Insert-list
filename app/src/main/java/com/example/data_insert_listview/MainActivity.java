package com.example.data_insert_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.data_insert_listview.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //connect interface class to call the api..

        Retrofit instance = ApiClient.getClient();
        apiInterface = instance.create(ApiInterface.class);

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Modelperson modelStd=new Modelperson();
                modelStd.setName(binding.etName.getText().toString());
                modelStd.setStudent_id(binding.etStudentId.getText().toString());
                modelStd.setSection(binding.etSection.getText().toString());
                modelStd.setResult(binding .etResult.getText().toString());

                apiInterface.insertperson(modelStd).enqueue(new Callback<Modelperson>() {
                    @Override
                    public void onResponse(Call<Modelperson> call, Response<Modelperson> response) {
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Modelperson> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "failour", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

        binding.showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,ListActivity.class));


            }
        });

    }
}