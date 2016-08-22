package com.example.gabriela.buttonsanddialogs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Gabriela on 8/20/2016.
 */
public class DialogsActivity extends Activity {
    Button ralucaDialogButton;

    public void raresDialog(View view) {

        final CharSequence[] options = {
                "Mancare", "Bautura", "Ambele :)"
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alege");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogs);

        ralucaDialogButton = (Button) findViewById(R.id.ralucadialog_button);
        raresDialogButton = (Button) findViewById(R.id.raresdialog_button);

        setUpHandlers();
    }

    private void setUpHandlers(){
        //aici adaugati handlerele pentru fiecare buton
        ralucaDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler :D
            }
        });

    }
}
