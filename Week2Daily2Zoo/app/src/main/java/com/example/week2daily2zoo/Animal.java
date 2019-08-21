package com.example.week2daily2zoo;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private String name, eatingHabit, habitat, kingdom, suborder, family, imageFile, description;
    private int soundFile;

    public Animal() {
    }

    public Animal(String name, String eatingHabit, String habitat, String kingdom, String suborder, String family, String imageFile, String description, int soundFile) {
        this.name = name;
        this.eatingHabit = eatingHabit;
        this.habitat = habitat;
        this.kingdom = kingdom;
        this.suborder = suborder;
        this.family = family;
        this.imageFile = imageFile;
        this.description = description;
        this.soundFile = soundFile;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        eatingHabit = in.readString();
        habitat = in.readString();
        kingdom = in.readString();
        suborder = in.readString();
        family = in.readString();
        imageFile = in.readString();
        description = in.readString();
        soundFile = in.readInt();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEatingHabit() {
        return eatingHabit;
    }

    public void setEatingHabit(String eatingHabit) {
        this.eatingHabit = eatingHabit;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getSuborder() {
        return suborder;
    }

    public void setSuborder(String suborder) {
        this.suborder = suborder;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(int soundFile) {
        this.soundFile = soundFile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(eatingHabit);
        parcel.writeString(habitat);
        parcel.writeString(kingdom);
        parcel.writeString(suborder);
        parcel.writeString(family);
        parcel.writeString(imageFile);
        parcel.writeString(description);
        parcel.writeInt(soundFile);
    }
}
