package com.example.week2daily2zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    ListView lvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initListView();
    }

    public void initListView(){
        lvCategories = findViewById(R.id.lvCategories);
        final ArrayList<String> categories = new ArrayList<String>();
        categories.add("Jungle");
        categories.add("Mountains");
        categories.add("Grasslands");
        categories.add("Tundra");
        categories.add("Forest");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.category_item, categories);
        lvCategories.setAdapter(arrayAdapter);
        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent animalListIntent = new Intent(view.getContext(), AnimalListActivity.class);
                Bundle bundle = getIntent().getExtras();
                animalListIntent.putExtra("category", categories.get(position));
                animalListIntent.putExtras(bundle);
                view.getContext().startActivity(animalListIntent);
            }
        });
    }
}
