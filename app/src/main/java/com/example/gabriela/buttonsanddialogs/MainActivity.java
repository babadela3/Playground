package com.example.gabriela.buttonsanddialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Gabriela on 8/20/2016.
 */
public class MainActivity extends Activity {

    private Button dialogsButton;
    private Button buttonsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogsButton = (Button) findViewById(R.id.dialogs_button);
        buttonsButton = (Button) findViewById(R.id.buttons_button);
        setUpHandlers();
    }

    private void setUpHandlers(){
        dialogsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DialogsActivity.class ));
            }
        });

        buttonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ButtonsActivity.class));
            }
        });
    }
}
