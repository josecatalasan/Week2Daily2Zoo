package com.example.week2daily2zoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.week2daily2zoo.model.animal.Animal;
import com.example.week2daily2zoo.model.datasource.local.database.AnimalDatabaseHelper;

import java.util.ArrayList;

public class AnimalDBEditActivity extends AppCompatActivity {
    RecyclerView rvAnimalList;
    AnimalListAdapter adapter;
    AnimalDatabaseHelper dbHelper;
    EditText etName, etEating, etHabitat, etGenus, etSpecies, etDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_dbedit);
        dbHelper = new AnimalDatabaseHelper(this);
        bindViews();
        initRecyclerView();
    }

    private void bindViews(){
        rvAnimalList = findViewById(R.id.rvAnimalList);
        etName = findViewById(R.id.etName);
        etEating = findViewById(R.id.etEating);
        etHabitat = findViewById(R.id.etHabitat);
        etGenus = findViewById(R.id.etGenus);
        etSpecies = findViewById(R.id.etSpecies);
        etDescription = findViewById(R.id.etDescription);
    }

    private void clearViews(){
        etName.setText("");
        etEating.setText("");
        etHabitat.setText("");
        etGenus.setText("");
        etSpecies.setText("");
        etDescription.setText("");
    }

    private void initRecyclerView(){
        ArrayList<Animal> animalList = dbHelper.getAllAnimal();
        adapter = new AnimalListAdapter(animalList, 1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAnimalList.setLayoutManager(layoutManager);
        rvAnimalList.setAdapter(adapter);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.btnInsert:
                Animal animal = new Animal(etName.getText().toString(),etEating.getText().toString(),etHabitat.getText().toString(),etGenus.getText().toString(),etSpecies.getText().toString(),etDescription.getText().toString(),0);
                dbHelper.insertAnimal(animal);
                adapter.onDatabaseChange(dbHelper.getAllAnimal());
                clearViews();
                break;
            case R.id.btnUpdate:
                if(dbHelper.getAnimalByName(etName.getText().toString())!= null) {
                    Animal animalUpdate = new Animal(etName.getText().toString(), etEating.getText().toString(), etHabitat.getText().toString(), etGenus.getText().toString(), etSpecies.getText().toString(), etDescription.getText().toString(), 0);
                    dbHelper.updateAnimal(animalUpdate);
                    adapter.onDatabaseChange(dbHelper.getAllAnimal());
                    clearViews();
                } else {
                    Toast.makeText(view.getContext(), "Animal is not in database", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
