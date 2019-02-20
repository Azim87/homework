package com.kubatov.homework.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kubatov.homework.R;

public class Main3Activity extends AppCompatActivity {

    EditText editText;
    Button button;
    int result;
    String number;
    String a;
    String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initEditText();
        initSendButton();
    }


    public void initEditText(){
        editText = findViewById(R.id.edit_text);
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {


                    result = Integer.parseInt(number);
                    int d = Integer.parseInt(a);
                    int g = Integer.parseInt(b);
                    result = d + g;
                }catch (Exception e){}
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void initSendButton(){
        button = findViewById(R.id.send_button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                intent.putExtra("NUM", result);
                startActivityForResult(intent, 3);
            }
        });
    }
}
