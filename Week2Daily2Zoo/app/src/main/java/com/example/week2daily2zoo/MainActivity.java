package com.example.week2daily2zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupAnimals();
    }

    public void goToCategories(View view){
        Intent categoryIntent = new Intent(this, CategoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("animal", animals);
        categoryIntent.putExtras(bundle);
        startActivity(categoryIntent);
    }

    public void setupAnimals(){
//  String name, eatingHabit, habitat, kingdom,
//  suborder, family, imageFile, description;
//  soundFile;
        animals = new ArrayList<>();
        animals.add(new Animal("Monkey", "Omnivore", "Jungle","Animalia", "Macaca", "Fascicularis", "imageFile", "This is a monkey. He throws poo.", 0));
    }
}
