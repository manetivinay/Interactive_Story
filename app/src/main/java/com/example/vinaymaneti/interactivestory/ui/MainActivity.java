package com.example.vinaymaneti.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinaymaneti.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameField = (EditText) findViewById(R.id.name_edit_text);
        mStartButton = (Button) findViewById(R.id.start_your_adventure_button);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString();
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                if (name.matches("") || name.trim().length() <= 0) {
                    Toast.makeText(MainActivity.this, "You did not enter the username", Toast.LENGTH_LONG).show();
                    return;
                }
                startStory(name);
            }
        });
    }

    private void startStory(String name) {
        Intent mIntent = new Intent(this, StoryActivity.class);
        mIntent.putExtra(getString(R.string.key_name), name);
        startActivity(mIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
}
