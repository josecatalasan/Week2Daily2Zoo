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

        //Jungle, Forest, Tundra, Mountains, Grasslands
        animals = new ArrayList<>();
        animals.add(new Animal("Monkey", "Omnivore", "Jungle","Animalia", "Macaca", "fascicularis", "imageFile", "This is a monkey. He throws poo.", R.raw.monkey));
        //Jaguar Jungle
        animals.add(new Animal("Jaguar", "Carnivore", "Jungle", "Animalia", "Panthera", "onca", "imageFile", "Placeholder desciption of a Panther", R.raw.jaguar));
        //Raccoon Forest
        animals.add(new Animal("Raccoon", "Omnivore", "Forest", "Animalia", "Procyon", "lotor", "imageFile", "Procyon is a genus of nocturnal mammals, comprising three species commonly known as raccoons, in the family Procyonidae. The most familiar species, the common raccoon (P. lotor), is often known simply as \"the\" raccoon, as the two other raccoon species in the genus are native only to the tropics and less well known.", R.raw.raccoon));
//        //Peacock Forest
        animals.add(new Animal("Peacock", "Omnivores", "Forest", "Animalia", "Pavo", "cristasus", "imageFile", "Peafowl is a common name for three species of birds in the genera Pavo and Afropavo of the Phasianidae family, the pheasants and their allies. Male peafowl are referred to as peacocks, and female peafowl as peahens.", R.raw.peacock));
//        //Polar Bear Tundra
        animals.add(new Animal("Polar Bear", "Carnivore", "Tundra", "Animalia", "Ursus", "maritimus", "", "The polar bear is a hypercarnivorous bear whose native range lies largely within the Arctic Circle, encompassing the Arctic Ocean, its surrounding seas and surrounding land masses. It is a large bear, approximately the same size as the omnivorous Kodiak bear.", R.raw.polarbear));
//        //Penguin Tundra
        animals.add(new Animal("Emperor Penguin", "Carnivore", "Tundra", "Animalia", "Aptenodytes", "forsteri", "", "The emperor penguin is the tallest and heaviest of all living penguin species and is endemic to Antarctica. The male and female are similar in plumage and size, reaching 122 cm in height and weighing from 22 to 45 kg.", R.raw.penguin ));
//        //Brown Bear Mountains
        animals.add(new Animal("Brown Bear", "Carnivore", "Mountains", "Animalia", "Ursus", "arctos", "", "The brown bear is a bear that is found across much of northern Eurasia and North America. In North America, the populations of brown bears are often called grizzly bears.", R.raw.brownbear));
//        //Lion Grasslands
        animals.add(new Animal("Lion", "Carnivore", "Grasslands","Animalia","Panthera","leo","","The lion is a species in the family Felidae; it is a muscular, deep-chested cat with a short, rounded head, a reduced neck and round ears, and a hairy tuft at the end of its tail. It is sexually dimorphic; male lions have a prominent mane, which is the most recognisable feature of the species.", R.raw.lion));
//        //Rhino Grasslands
        animals.add(new Animal("Black Rhino", "Herbivore", "Grasslands", "Animalia", "Diceros", "bicornis", "","The black rhinoceros or hook-lipped rhinoceros is a species of rhinoceros, native to eastern and southern Africa including Botswana, Kenya, Malawi, Mozambique, Namibia, South Africa, Swaziland, Tanzania, Zambia, and Zimbabwe. Although the rhinoceros is referred to as black, its colors vary from brown to grey.", R.raw.rhino));
    }
}
