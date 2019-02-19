package com.kubatov.homework;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button clickBtn;
    Button clickBtn2;
    Button sendText;
    EditText editText;

    String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initText();
        send();

        clickBtn = findViewById(R.id.firstButton);
        clickBtn2 = findViewById(R.id.secondButton);

        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("SOME_TEXT", "This is from main activity");
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            String text = data.getStringExtra("RETURN_TEXT");
            clickBtn.setText(text);

        }
    }

    public void onHideClick(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "text to send");
        intent.setType("text/plain");

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }

    void initText(){
        editText = findViewById(R.id.title_name);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                title = s.toString();
                Log.d("ololo", "e");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    void send(){
        sendText = findViewById(R.id.send_button);
        sendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("TEXT",title);
                startActivityForResult(intent, 2);
            }
        });
    }







}
