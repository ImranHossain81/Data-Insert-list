package com.example.data_insert_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapterperson extends RecyclerView.Adapter<Adapterperson.MyHolder> {

    ArrayList<Modelperson> person;
    Context context;

    public Adapterperson(ArrayList<Modelperson> person, Context context) {
        this.person = person;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapterperson.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemperson, parent, false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapterperson.MyHolder holder, int position) {

        holder.name.setText(person.get(position).getName());
        holder.student_id.setText(person.get(position).getStudent_id());
        holder.section.setText(person.get(position).getSection());
        holder.result.setText(person.get(position).getResult());
    }

    @Override
    public int getItemCount() {
        return person.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name,student_id,section,result;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.tex_name);
            student_id=itemView.findViewById(R.id.tex_student_id);
            section=itemView.findViewById(R.id.tex_section);
            result=itemView.findViewById(R.id.tex_result);

        }
    }

    public void search_list(ArrayList<Modelperson> list){
        person=list;
        notifyDataSetChanged();

    }
}
