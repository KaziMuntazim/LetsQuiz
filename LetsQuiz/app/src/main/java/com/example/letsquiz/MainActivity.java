package com.example.letsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   public static ArrayList<ModelC> listofQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listofQ = new ArrayList<>();
        listofQ.add(new ModelC("What is the capital of India?" , "Mumbai" , "New Delhi" , "Kolkata" , "Surat" , "New Delhi"));
        listofQ.add(new ModelC("Who is the current Prime Minister of India?" , "Narendra Modi" , "Rahul Gandhi" , "Kejriwal" , "Lata Ji" , "Narendra Modi"));
        listofQ.add(new ModelC("What is the largest lake in the world?" , "Caspian Sea" , "Baikal" , "Lake Superior" , "Ontario" , "Baikal"));
        listofQ.add(new ModelC("Which planet in the solar system is known as the Red Planet?" , "Jupiter" , "Earth" , "Venus" , "Mars" , "Mars"));
        listofQ.add(new ModelC("What is the capital of Japan?" , "Bangkok" , "Seoul" , "Tokyo" , "Beijing" , "Tokyo"));
        listofQ.add(new ModelC("Which river is the longest in the world?" , "Amazon" , "Nile" , "Yangtze" , "Mississippi" , "Nile"));
        listofQ.add(new ModelC("What animal is the national symbol of Australia?" , "Kangaroo" , "Crocodile" , "Emu" , "Koala" , "Kangaroo"));
        listofQ.add(new ModelC("Which is the largest island?" , "Greenland" , "Andaman Nicobar" , "Hawaii" , "New Guinea" , "Greenland"));
        listofQ.add(new ModelC("Which one is the hottest continent?" , "North America" , "Australia" , "Africa" , "South Asia" , "Africa"));
        listofQ.add(new ModelC(" What is the official currency of Japan?" , "Dollars" , "Yuan" , "Won" , "Yen" , "Yen"));
        listofQ.add(new ModelC("Which one of the following countries is not in Africa?" , "Morocco" , "Yemen" , "Sudan" , "Algeria" , "Yemen"));
        listofQ.add(new ModelC("What is considered the lung of the Earth?" , "Everest" , "The Sahara" , "Amazon rainforest" , "The Mississippi River" , "Amazon rainforest"));
        listofQ.add(new ModelC("Which is the richest country in the world?" , "USA" , "UAE" , "Qatar" , "Russia" , "Qatar"));
        listofQ.add(new ModelC("Which county is the biggest grower of coffee?" , "Brazil" , "India" , "Spain" , "Ethiopia" , "Brazil"));
        listofQ.add(new ModelC("How many bones are in the body of an adult human?" , "250" , "210" , "330" , "206" , "206"));
        listofQ.add(new ModelC("Which river is the second longest in the world?" , "Mississippi" , "Nile" , "Yangtze" , "Amazon" , "Yangtze"));
        listofQ.add(new ModelC("What year was the first man sent to space?" , "1961" , "1957" , "1969" , "1975" , "1961"));
        listofQ.add(new ModelC("What ocean is between Africa and Australia?" , "Pacific" , "Arctic" , "Indian" , "Atlantic" , "Indian"));
        listofQ.add(new ModelC("Which planet in the solar system is known as the “Planet of Love”?" , "Venus" , "Mars" , "Earth" , "Jupiter" , "Venus"));
        listofQ.add(new ModelC("How many teeth does an adult dog have?" , "34" , "38" , "42" , "32" , "42"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this , DashBordActivity.class);
                startActivity(intent);
                finish();
            }
        } , 1500);
    }
}