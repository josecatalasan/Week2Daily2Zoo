package com.example.week2daily2zoo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week2daily2zoo.model.animal.Animal;
import com.example.week2daily2zoo.model.datasource.local.database.AnimalDatabaseHelper;

import java.util.ArrayList;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder>{
    private static final int ANIMAL_LIST_ACTIVITY = 0;
    private static final int EDIT_DB_ACTIVITY = 1;
    private ArrayList<Animal> animalList;
    private int whichActivity;

    public AnimalListAdapter(ArrayList<Animal> animalList, int which) {this.animalList = animalList; this.whichActivity = which;}

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
            if (whichActivity == ANIMAL_LIST_ACTIVITY) {
                Intent detailsIntent = new Intent(view.getContext(), AnimalDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("animal", itemAnimal);
                detailsIntent.putExtras(bundle);
                view.getContext().startActivity(detailsIntent);
            }

            if (whichActivity == EDIT_DB_ACTIVITY) {
                final AnimalDatabaseHelper dbHelper = new AnimalDatabaseHelper(view.getContext());
                DialogInterface.OnClickListener confirmation = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int choice) {
                        switch(choice){
                            case DialogInterface.BUTTON_POSITIVE:
                                dbHelper.deleteAnimalInDB(itemAnimal.getName());
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }

                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Are you sure?").setPositiveButton("Yes", confirmation)
                        .setNegativeButton("No",confirmation).show();
            }
        }
    }
}
