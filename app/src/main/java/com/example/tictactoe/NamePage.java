package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class NamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_page);
        ImageView img= findViewById(R.id.imageView);
        img.setImageResource(R.drawable.ttt_cover);
    }
    public void nextpage(View v)
    {
        Intent i= new Intent(this, MainActivity.class);
        String player1 = ((TextView)(findViewById(R.id.editTextTextPersonName))).getText().toString();
        String player2 = ((TextView)(findViewById(R.id.editTextTextPersonName2))).getText().toString();
        i.putExtra("PLAYER1",player1);
        i.putExtra("PLAYER2",player2);
        startActivity(i);
    }
}