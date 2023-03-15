package com.example.data_insert_listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.data_insert_listview.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListActivity extends AppCompatActivity {

    ArrayList<Modelperson> persons=new ArrayList<>();
    Adapterperson adapterperson;
    ApiInterface apiInterface;
    //for view binding...//////
    private ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

         //recycler view serup...........
        binding.recyclerPerson.setLayoutManager(new LinearLayoutManager(this));
        adapterperson = new Adapterperson(persons,this);


          //get data from the database by api call.......

        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);

        apiInterface.getAllData().enqueue(new Callback<List<Modelperson>>() {
            @Override
            public void onResponse(Call<List<Modelperson>> call, Response<List<Modelperson>> response) {

                persons.addAll(response.body());
                binding.recyclerPerson.setAdapter(adapterperson);
                adapterperson.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Modelperson>> call, Throwable t) {

                Toast.makeText(ListActivity.this,  "Something is wrong !", Toast.LENGTH_SHORT).show();


            }
        });



        binding.searchList.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                //for search list...

                ArrayList<Modelperson> search_arraylist=new ArrayList<>();
                for (Modelperson item: persons){

                    if (item.getName().toLowerCase().contains(editable.toString().toLowerCase())
                            || item.getStudent_id().toLowerCase().contains(editable.toString().toLowerCase())
                            || item.getSection().toLowerCase().contains(editable.toString().toLowerCase())
                            || item.getResult().toLowerCase().contains(editable.toString().toLowerCase())

                    )
                    {
                        search_arraylist.add(item);
                    }
                }

                adapterperson.search_list(search_arraylist);


            }
        });



    }



}