package com.raminarman.tutorialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText editText;
    private Button button;
    private CheckBox checkBox;
    private ProgressBar progressBar;
    // private ImageView imageView;
    private Button btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtMessage);
        editText = findViewById(R.id.editBox);
        button = findViewById(R.id.btnClickMe);
        checkBox = findViewById(R.id.checkBox);
        progressBar = findViewById(R.id.progressBar);
        // imageView = findViewById(R.id.imageView);
        btnSecond = findViewById(R.id.btnSecond);

        btnSecond.setOnClickListener(this);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    progressBar.incrementProgressBy(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        Toast.makeText(this, "Hello this is my toast message.", Toast.LENGTH_LONG).show();
    }


    public void onCheckboxClick(View view) {
        textView.setVisibility(View.VISIBLE);
        if (checkBox.isChecked()) {
            textView.setText("You checked it.");
        } else {
            textView.setText("It is unchecked.");
        }
    }

    public void onImageClick(View view) {
        textView.setText("I clicked image view");
    }

    @Override
    public void onClick(View v) {
        textView.setVisibility(View.VISIBLE);
        switch (v.getId()) {
            case R.id.btnClickMe:
                String txt = this.editText.getText().toString();
                this.textView.setText(txt);
                break;
            case R.id.btnSecond:
                textView.setText("You have clicked on the second btn.");
        }
    }
}
