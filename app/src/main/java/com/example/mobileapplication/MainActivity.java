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
        TextView tv_result_before = (TextView) findViewById(R.id.tv_result_before);
        TextView tv_result_after = (TextView) findViewById(R.id.tv_result_after);
        tv_result_before.setText(Phraser.PhraserGen("before"));
        tv_result_after.setText(Phraser.PhraserGen("after"));
    }
}