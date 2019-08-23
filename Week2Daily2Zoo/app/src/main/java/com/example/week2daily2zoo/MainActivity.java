package com.example.week2daily2zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.week2daily2zoo.model.animal.Animal;
import com.example.week2daily2zoo.model.datasource.local.database.AnimalDatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Animal> animals;
    private AnimalDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new AnimalDatabaseHelper(this);
        setupAnimals();
    }

    public void onClick(View view){
        switch(view.getId()) {
            case R.id.btnCategories:
                Intent categoryIntent = new Intent(this, CategoryActivity.class);
                startActivity(categoryIntent);
                break;
            case R.id.btnEdit:
                Intent editIntent = new Intent(this, AnimalDBEditActivity.class);
                startActivity(editIntent);
        }
    }

    public void setupAnimals(){
        //Jungle, Forest, Tundra, Mountains, Grasslands
        dbHelper.insertAnimal(new Animal("Brown Howler Monkey", "Herbivore", "Jungle", "Alouatta", "guariba", "The brown howler, also known as brown howler monkey, is a species of howler monkey, a type of New World monkey that lives in forests in southeastern Brazil and far northeastern Argentina. It lives in groups of two to 11 individuals.", R.raw.monkey));
        dbHelper.insertAnimal(new Animal("Jaguar", "Carnivore", "Jungle", "Panthera", "onca", "The jaguar is a large felid species and the only extant member of the genus Panthera native to the Americas. The jaguar's present range extends from Southwestern United States and Mexico in North America, across much of Central America, and south to Paraguay and northern Argentina in South America.", R.raw.jaguar));
        dbHelper.insertAnimal(new Animal("Raccoon", "Omnivore", "Forest", "Procyon", "lotor", "Procyon is a genus of nocturnal mammals, comprising three species commonly known as raccoons, in the family Procyonidae. The most familiar species, the common raccoon (P. lotor), is often known simply as \"the\" raccoon, as the two other raccoon species in the genus are native only to the tropics and less well known.", R.raw.raccoon));
        dbHelper.insertAnimal(new Animal("Peacock", "Omnivores", "Forest", "Pavo", "cristasus", "Peafowl is a common name for three species of birds in the genera Pavo and Afropavo of the Phasianidae family, the pheasants and their allies. Male peafowl are referred to as peacocks, and female peafowl as peahens.", R.raw.peacock));
        dbHelper.insertAnimal(new Animal("Polar Bear", "Carnivore", "Tundra", "Ursus", "maritimus", "The polar bear is a hypercarnivorous bear whose native range lies largely within the Arctic Circle, encompassing the Arctic Ocean, its surrounding seas and surrounding land masses. It is a large bear, approximately the same size as the omnivorous Kodiak bear.", R.raw.polarbear));
        dbHelper.insertAnimal(new Animal("Emperor Penguin", "Carnivore", "Tundra", "Aptenodytes", "forsteri", "The emperor penguin is the tallest and heaviest of all living penguin species and is endemic to Antarctica. The male and female are similar in plumage and size, reaching 122 cm in height and weighing from 22 to 45 kg.", R.raw.penguin ));
        dbHelper.insertAnimal(new Animal("Brown Bear", "Carnivore", "Mountains", "Ursus", "arctos", "The brown bear is a bear that is found across much of northern Eurasia and North America. In North America, the populations of brown bears are often called grizzly bears.", R.raw.brownbear));
        dbHelper.insertAnimal(new Animal("Lion", "Carnivore", "Grasslands","Panthera","leo","The lion is a species in the family Felidae; it is a muscular, deep-chested cat with a short, rounded head, a reduced neck and round ears, and a hairy tuft at the end of its tail. It is sexually dimorphic; male lions have a prominent mane, which is the most recognisable feature of the species.", R.raw.lion));
        dbHelper.insertAnimal(new Animal("Black Rhino", "Herbivore", "Grasslands", "Diceros", "bicornis","The black rhinoceros or hook-lipped rhinoceros is a species of rhinoceros, native to eastern and southern Africa including Botswana, Kenya, Malawi, Mozambique, Namibia, South Africa, Swaziland, Tanzania, Zambia, and Zimbabwe. Although the rhinoceros is referred to as black, its colors vary from brown to grey.", R.raw.rhino));
    }
}
