package com.example.week2daily2zoo.model.datasource.local.database;

public class AnimalDatabaseContract {

    // private String name, eatingHabit, habitat
    // genus, species, description;
    //    private int soundFile;

    public static final String DATABASE_NAME = "animals_db";
    public static final String TABLE_NAME = "animals_table";
    //psfi {enter}
    public static final int DATABASE_VERSION = 1;
    public static final String COL_NAME = "name";
    public static final String COL_EATING_HABIT = "eating_habit";
    public static final String COL_HABITAT = "habitat";
    public static final String COL_GENUS = "genus";
    public static final String COL_SPECIES = "species";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_SOUND = "sound";

    //Create Table Query
    public static final String QUERY_CREATE_TABLE =
            String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY NOT NULL, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INTEGER)",
                    TABLE_NAME, COL_NAME, COL_EATING_HABIT, COL_HABITAT, COL_GENUS, COL_SPECIES, COL_DESCRIPTION, COL_SOUND);

    //Select All Query
    public static final String QUERY_SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);

    //Select by ID
    public static String QUERY_SELECT_BY_NAME(String name) {
        return String.format("SELECT * FROM %s WHERE %s = \'%s\'", TABLE_NAME, COL_NAME, name);
    }

    //Select by Habitat
    public static String QUERY_SELECT_BY_HABITAT(String habitat) {
        return String.format("SELECT * FROM %s WHERE %s = \'%s\'", TABLE_NAME, COL_HABITAT, habitat);
    }

    //Drop Table Query
    public static final String DROP_TABLE = String.format("DROP TABLE %s", TABLE_NAME);
}
