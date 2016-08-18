package com.example.cretucalinn.playground;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

/**
 * Created by Cretu Calinn on 8/18/2016.
 */
public class DialogsActivity extends Activity {
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private Button buttonCretuCalin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        buttonCretuCalin= (Button) findViewById(R.id.buttonCretuCalin);
        buttonCretuCalin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pd = new ProgressDialog(DialogsActivity.this);

                // Set progress dialog style spinner
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                // Set the progress dialog title and message
                pd.setTitle("Title of progress dialog.");
                pd.setMessage("Loading.........");

                // Set the progress dialog background color
                pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFD4D9D0")));

                pd.setIndeterminate(false);

                // Finally, show the progress dialog
                pd.show();

                // Set the progress status zero on each button click
                progressStatus = 0;

                // Start the lengthy operation in a background thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressStatus < 100){
                            // Update the progress status
                            progressStatus +=1;

                            // Try to sleep the thread for 20 milliseconds
                            try{
                                Thread.sleep(20);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }

                            // Update the progress bar
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    // Update the progress status
                                    pd.setProgress(progressStatus);
                                    // If task execution completed
                                    if(progressStatus == 100){
                                        // Dismiss/hide the progress dialog
                                        pd.dismiss();
                                    }
                                }
                            });
                        }
                    }
                }).start(); // Start the operation
            }
        });
    }
}
