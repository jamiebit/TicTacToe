package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

class globe{
    public static int flg;
    globe()
    {
        flg=0;
    }
}

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textView3).setVisibility(View.INVISIBLE);
        ((TextView)(findViewById(R.id.textView2))).setText(player1()+" may play!");
        Log.d("hi","in OnCreate");
    }
    public String player1()
    {
        Intent i= getIntent();
        String ply1=i.getStringExtra("PLAYER1");
        return(ply1);
    }
    public String player2()
    {
        Intent i= getIntent();
        String ply2=i.getStringExtra("PLAYER2");
        return(ply2);
    }
    public void Breset(Button b)
    {
        b.setEnabled(true);
        b.setBackgroundColor(Color.WHITE);
        b.setText("");
    }
    public void disabled(Button b)
    {
        if(b.getText()=="")
        { b.setEnabled(false);
            b.setBackgroundColor(Color.DKGRAY);}
    }

    public void disable(View v){
        v.setEnabled(false);
        if(globe.flg==0)
        {
            ((Button)v).setText("X");
            ((Button)v).setTextColor(Color.BLACK);
            ((Button)v).setBackgroundColor(Color.RED);
            TextView txt=findViewById(R.id.textView2);
            txt.setText(player2()+" may play!");
            globe.flg=1;
        }
        else
        {
            ((Button)v).setText("O");
            ((Button)v).setTextColor(Color.BLACK);
            ((Button)v).setBackgroundColor(Color.GREEN);
            TextView txt=findViewById(R.id.textView2);
            txt.setText(player1()+" may play!");
            globe.flg=0;
        }
        checkresult();
    }
    public boolean full(Button b)
    {
        if(b.getText()!="")
            return true;
        return false;
    }
    public void checkresult(){

        Button a=((Button)(findViewById(R.id.button23)));
        Button b=((Button)(findViewById(R.id.button21)));
        Button c=((Button)(findViewById(R.id.button20)));
        Button d=((Button)(findViewById(R.id.button24)));
        Button e=((Button)(findViewById(R.id.button17)));
        Button f=((Button)(findViewById(R.id.button8)));
        Button g=((Button)(findViewById(R.id.button19)));
        Button h=((Button)(findViewById(R.id.button18)));
        Button i=((Button)(findViewById(R.id.button22)));

        if((a.getText()=="X"&& b.getText()=="X"&& e.getText()=="X"||f.getText()=="X"&& g.getText()=="X"&& d.getText()=="X"||h.getText()=="X"&& c.getText()=="X"&& i.getText()=="X"
                ||a.getText()=="X"&& f.getText()=="X"&& h.getText()=="X"||g.getText()=="X"&& b.getText()=="X"&& c.getText()=="X"||d.getText()=="X"&& i.getText()=="X"&& e.getText()=="X" ||
                a.getText()=="X"&& g.getText()=="X"&& i.getText()=="X"||h.getText()=="X"&& g.getText()=="X"&& e.getText()=="X")||(a.getText()=="O"&& b.getText()=="O"&& e.getText()=="O"||
                f.getText()=="O"&& g.getText()=="O"&& d.getText()=="O"||h.getText()=="O"&& c.getText()=="O"&& i.getText()=="O"|| a.getText()=="O"&& f.getText()=="O"&& h.getText()=="O"||
                g.getText()=="O"&& b.getText()=="O"&& c.getText()=="O"||d.getText()=="O"&& i.getText()=="O"&& e.getText()=="O" || a.getText()=="O"&& g.getText()=="O"&& i.getText()=="O"||
                h.getText()=="O"&& g.getText()=="O"&& e.getText()=="O"))
        {
            disabled(a);
            disabled(b);
            disabled(c);
            disabled(d);
            disabled(e);
            disabled(f);
            disabled(g);
            disabled(h);
            disabled(i);


            findViewById(R.id.textView2).setVisibility(View.INVISIBLE);

            if(globe.flg==1)
                ((TextView)findViewById(R.id.textView3)).setText(player1().toUpperCase()+" HAS WON!");
            else
                ((TextView)findViewById(R.id.textView3)).setText(player2().toUpperCase()+" HAS WON!");

            ((TextView)findViewById(R.id.textView3)).setGravity(Gravity.CENTER); //CENTER ALIGNS THE TEXT!
            ((TextView)findViewById(R.id.textView3)).setVisibility(View.VISIBLE);
        }
        else if(full(a)&&full(b)&&full(c)&&full(d)&&full(e)&&full(f)&&full(g)&&full(h)&&full(i))
        {
            findViewById(R.id.textView2).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.textView3)).setText("A TIE HAS OCCURRED");
            ((TextView)findViewById(R.id.textView3)).setGravity(Gravity.CENTER); //CENTER ALIGNS THE TEXT!
            ((TextView)findViewById(R.id.textView3)).setVisibility(View.VISIBLE);
        }
    }

    public void reset(View v){
        Button a=((Button)(findViewById(R.id.button23)));
        Button b=((Button)(findViewById(R.id.button21)));
        Button c=((Button)(findViewById(R.id.button20)));
        Button d=((Button)(findViewById(R.id.button24)));
        Button e=((Button)(findViewById(R.id.button17)));
        Button f=((Button)(findViewById(R.id.button8)));
        Button g=((Button)(findViewById(R.id.button19)));
        Button h=((Button)(findViewById(R.id.button18)));
        Button i=((Button)(findViewById(R.id.button22)));

        Breset(a);
        Breset(b);
        Breset(c);
        Breset(d);
        Breset(e);
        Breset(e);
        Breset(f);
        Breset(g);
        Breset(h);
        Breset(i);

        findViewById(R.id.textView3).setVisibility(View.INVISIBLE);
        ((TextView)findViewById(R.id.textView2)).setText(player1()+" may play!");
        globe.flg=0;
        findViewById(R.id.textView2).setVisibility(View.VISIBLE);

    }
}