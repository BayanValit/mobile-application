package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button generateButton = (Button) findViewById(R.id.generateButton);
        this.onButtonClick(generateButton);
    }

    public void onButtonClick(View sender) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(Phraser.PhraserGen());
    }
}