package com.example.week2daily2zoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class AnimalListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        //layout manager
        recyclerView = findViewById(R.id.rvAnimals);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //adapter
        ArrayList<Animal> displayList = getAnimalList();
        AnimalListAdapter adapter = new AnimalListAdapter(displayList);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Animal> getAnimalList() {
        ArrayList<Animal> passedList = getIntent().getExtras().getParcelableArrayList("animal");
        String category = getIntent().getStringExtra("category");


            for (int i = 0; i < passedList.size(); i++) {
                if (!passedList.get(i).getHabitat().equalsIgnoreCase(category)){
                    passedList.remove(i);
                }
            }

        return passedList;
    }
}
