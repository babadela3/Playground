package com.example.gabriela.buttonsanddialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Gabriela on 8/20/2016.
 */
public class DialogsActivity extends Activity {
    private Button ralucaDialogButton;
    private Button calinDialogButton;
    private Button teoDialogButton;
    private Button mihaiDialogButton;
    private Button gabiDialogButton;

    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogs);

        ralucaDialogButton = (Button) findViewById(R.id.ralucadialog_button);
        calinDialogButton = (Button) findViewById(R.id.calindialog_button);
        mihaiDialogButton = (Button) findViewById(R.id.mihaidialog_button);
        teoDialogButton = (Button) findViewById(R.id.teodialog_button);
        gabiDialogButton = (Button) findViewById(R.id.gabidialog_button);
        setUpHandlers();
    }

    private void setUpHandlers(){
        //aici adaugati handlerele pentru fiecare buton
        ralucaDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler :D
		        AlertDialog.Builder dialog = new AlertDialog.Builder(DialogsActivity.this);

                dialog.setMessage("Are you sure you want to make this decision?");
                dialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogsActivity.this, "Cool", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                            }
                        });
                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogsActivity.this, "You chose to cancel!", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                dialog.setIcon(android.R.drawable.ic_dialog_alert);
                dialog.show();
            }
        });

        calinDialogButton.setOnClickListener(new View.OnClickListener() {
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

        teoDialogButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DialogsActivity.this);


                Drawable dr = ResourcesCompat.getDrawable(getResources(), R.drawable.termsofservice, null);
                Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
                Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 50, 50, true));


                // set title
                alertDialogBuilder.setTitle("Therms of Service")
                        .setIcon(d);

                // set dialog message
                alertDialogBuilder
                        .setMessage("Do you accept all our terms and conditions?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(DialogsActivity.this, "Yes", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                }

                        )
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(DialogsActivity.this, "No", Toast.LENGTH_LONG).show();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

        mihaiDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(DialogsActivity.this);
                dialog.setContentView(R.layout.mihai_dialog_layout);
                dialog.setTitle("Add child");

                Button saveButton = (Button) dialog.findViewById(R.id.saveButton);
                Button cancelButton = (Button) dialog.findViewById(R.id.cancelButton);

                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        gabiDialogButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ProgressDialog progress = new ProgressDialog(DialogsActivity.this);
                progress.setTitle("Super cool title");
                progress.setMessage("Loading...");
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setIndeterminate(true);
                progress.setProgress(0);
                progress.setCancelable(false);
                progress.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                progress.show();


                final int totalProgressTime = 100;
                final Thread t = new Thread() {
                    @Override
                    public void run() {
                        int jumpTime = 0;

                        while(jumpTime < totalProgressTime) {
                            try {
                                sleep(200);
                                jumpTime += 5;
                                progress.setProgress(jumpTime);
                            }
                            catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                };
                t.start();

            }
        });
    }
}
