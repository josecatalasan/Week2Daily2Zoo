package com.example.week2daily2zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AnimalDetailsActivity extends AppCompatActivity {
    //name, eatingHabit, habitat, kingdom, phylum, _class, order, suborder, family, soundFile, imageFile
    private ImageView ivAnimal;
    private TextView tvName, tvEatingHabit, tvHabitat, tvKingdom, tvSuborder, tvFamily, tvDescription;
    private MediaPlayer player;
    private Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        bindViews();
        Intent passedIntent = getIntent();
        animal = passedIntent.getExtras().getParcelable("animal");
        fillViews();
//        playAnimalSound();
    }

    public void bindViews(){
        ivAnimal = findViewById(R.id.ivAnimal);
        tvName = findViewById(R.id.tvName);
        tvEatingHabit = findViewById(R.id.tvEatingHabit);
        tvHabitat = findViewById(R.id.tvHabitat);
        tvKingdom = findViewById(R.id.tvKingdom);
        tvSuborder = findViewById(R.id.tvSuborder);
        tvFamily = findViewById(R.id.tvFamily);
        tvDescription = findViewById(R.id.tvDescription);
    }

    public void fillViews(){
        //fill ImageView
//        Bitmap imageBitmap = (Bitmap) extras.get("data");
//        imageView.setImageBitmap(imageBitmap);
        tvName.setText(animal.getName());
        tvEatingHabit.setText(animal.getEatingHabit());
        tvHabitat.setText(animal.getHabitat());
        tvKingdom.setText(animal.getKingdom());
        tvSuborder.setText(animal.getSuborder());
        tvFamily.setText(animal.getFamily());
        tvDescription.setText(animal.getDescription());
    }

    public void playAnimalSound(){
        if(player == null){
            player = MediaPlayer.create(this, animal.getSoundFile());
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if(player != null){
                        player.release();
                        player = null;
                    }
                }
            });
        }
        player.start();
    }
}
