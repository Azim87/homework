package com.kubatov.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.security.PublicKey;

public class Main2Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView_2);

        Intent intent = getIntent();
        String text = intent.getStringExtra("SOME_TEXT");
        textView.setText(text);



    }

    public void onTextClick (View v) {
        Intent intent = new Intent();
        intent.putExtra("RETURN_TEXT", "Clicked");
        setResult(RESULT_OK, intent);
        finish();
    }
}
