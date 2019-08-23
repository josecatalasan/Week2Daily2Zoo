package com.example.week2daily2zoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.week2daily2zoo.model.animal.Animal;
import com.example.week2daily2zoo.model.datasource.local.database.AnimalDatabaseHelper;

import java.util.ArrayList;

public class AnimalListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimalDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        dbHelper = new AnimalDatabaseHelper(this);

        //layout manager
        recyclerView = findViewById(R.id.rvAnimals);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //adapter
        String habitat = getIntent().getStringExtra("category");
        ArrayList<Animal> displayList = dbHelper.getAnimalsByHabitat(habitat);
        AnimalListAdapter adapter = new AnimalListAdapter(displayList, 0);
        recyclerView.setAdapter(adapter);

    }
}
