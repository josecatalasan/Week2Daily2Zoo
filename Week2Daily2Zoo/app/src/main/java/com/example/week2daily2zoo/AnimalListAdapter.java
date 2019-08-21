package com.example.week2daily2zoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder>{
    private ArrayList<Animal> animalList;

    public AnimalListAdapter(ArrayList<Animal> animalList) {this.animalList = animalList;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item,parent,false);
        return new ViewHolder(inflatedItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //populating data
        Animal currentAnimal = animalList.get(position);
//        holder.populateValues(currentCar);lol
        holder.tvAnimal.setText(currentAnimal.getName());
        holder.setItemAnimal(currentAnimal);
    }

    @Override
    public int getItemCount() {return animalList.size();}

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvAnimal;
        private Animal itemAnimal;

        public ViewHolder(View itemView){
            super(itemView);
            tvAnimal = itemView.findViewById(R.id.tvAnimal);
            itemView.setOnClickListener(this);
        }

        public void setItemAnimal(Animal animal){this.itemAnimal = animal;}

        @Override
        public void onClick(View view) {
            //go to details activity
            Intent detailsIntent = new Intent(view.getContext(), AnimalDetailsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("animal", itemAnimal);
            detailsIntent.putExtras(bundle);
            view.getContext().startActivity(detailsIntent);
        }
    }
}
