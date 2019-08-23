package com.example.week2daily2zoo.model.datasource.local.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.week2daily2zoo.model.animal.Animal;

import java.util.ArrayList;

public class AnimalDatabaseHelper extends SQLiteOpenHelper {

    public AnimalDatabaseHelper(Context context) {
        super(context, AnimalDatabaseContract.DATABASE_NAME, null, AnimalDatabaseContract.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(AnimalDatabaseContract.QUERY_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(AnimalDatabaseContract.DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    //Select All Method
    public ArrayList<Animal> getAllAnimal() {
        ArrayList<Animal> animalList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Cursor cursor = readableDatabase.rawQuery(AnimalDatabaseContract.QUERY_SELECT_ALL, null);

        if(cursor.moveToFirst()) {
            do {
                Animal animal = new Animal(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_NAME)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_EATING_HABIT)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_HABITAT)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_GENUS)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_SPECIES)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_DESCRIPTION)),
                        cursor.getInt(cursor.getColumnIndex(AnimalDatabaseContract.COL_SOUND)));

                animalList.add(animal);
            } while(cursor.moveToNext());
        }

        return animalList;
    }

    //Find by id
    public Animal getAnimalByName(String name) {
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery(AnimalDatabaseContract.QUERY_SELECT_BY_NAME(name), null);

        if(cursor.moveToFirst()) {
            Animal animal = new Animal(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_NAME)),
                    cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_EATING_HABIT)),
                    cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_HABITAT)),
                    cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_GENUS)),
                    cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_SPECIES)),
                    cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_DESCRIPTION)),
                    cursor.getInt(cursor.getColumnIndex(AnimalDatabaseContract.COL_SOUND)));
            return animal;
        }

        return null;
    }

    //Find by category
    public ArrayList<Animal> getAnimalsByHabitat(String habitat) {
        ArrayList<Animal> animalList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Cursor cursor = readableDatabase.rawQuery(AnimalDatabaseContract.QUERY_SELECT_BY_HABITAT(habitat), null);

        if(cursor.moveToFirst()) {
            do {
                Animal animal = new Animal(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_NAME)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_EATING_HABIT)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_HABITAT)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_GENUS)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_SPECIES)),
                        cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_DESCRIPTION)),
                        cursor.getInt(cursor.getColumnIndex(AnimalDatabaseContract.COL_SOUND)));
                animalList.add(animal);
            } while(cursor.moveToNext());
        }

        return animalList;
    }

    //Insert Phone into database
    public void insertAnimal(Animal animal) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        //Container which is key value pairs, key being the Col of DB, value being
        // what to save in that place
        ContentValues contentValues = new ContentValues();
        //Put values in contentValues
        contentValues.put(AnimalDatabaseContract.COL_NAME, animal.getName());
        contentValues.put(AnimalDatabaseContract.COL_EATING_HABIT, animal.getEatingHabit());
        contentValues.put(AnimalDatabaseContract.COL_HABITAT, animal.getHabitat());
        contentValues.put(AnimalDatabaseContract.COL_GENUS, animal.getGenus());
        contentValues.put(AnimalDatabaseContract.COL_SPECIES, animal.getSpecies());
        contentValues.put(AnimalDatabaseContract.COL_DESCRIPTION, animal.getDescription());
        contentValues.put(AnimalDatabaseContract.COL_SOUND, animal.getSoundFile());

        writableDatabase.insert(AnimalDatabaseContract.TABLE_NAME, null, contentValues);
    }

    //Update Phone in the database
    public void updateAnimal(Animal animal) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(AnimalDatabaseContract.COL_EATING_HABIT, animal.getEatingHabit());
        contentValues.put(AnimalDatabaseContract.COL_HABITAT, animal.getHabitat());
        contentValues.put(AnimalDatabaseContract.COL_GENUS, animal.getGenus());
        contentValues.put(AnimalDatabaseContract.COL_SPECIES, animal.getSpecies());
        contentValues.put(AnimalDatabaseContract.COL_DESCRIPTION, animal.getDescription());
        contentValues.put(AnimalDatabaseContract.COL_SOUND, animal.getSoundFile());

        sqLiteDatabase.update(AnimalDatabaseContract.TABLE_NAME, contentValues, "name = ?", new String[]{animal.getName()});
    }

    //Delete a Phone
    public void deleteAnimalInDB(String name) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(AnimalDatabaseContract.TABLE_NAME, "name = ?", new String[]{name});
    }
}
