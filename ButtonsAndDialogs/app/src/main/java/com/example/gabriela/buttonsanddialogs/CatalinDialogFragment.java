package com.example.gabriela.buttonsanddialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Cata on 8/21/2016.
 */
public class CatalinDialogFragment extends DialogFragment {


    public CatalinDialogFragment(){

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.v("CatalinDialogFragment", "onCreate");

        String Score = "50";
        Score = getArguments().getString("Score");


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogDesign = inflater.inflate(R.layout.catalin_dialog_fragment, null);

        //set the Dismiss functionality
        Button discardButton = (Button) dialogDesign.findViewById(R.id.catalinDF_discard);
        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatalinDialogFragment.this.dismiss();
            }
        });

        //set the Save functionality
        Button saveButton = (Button) dialogDesign.findViewById(R.id.catalinDF_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("CatalinDialogFragment:", "SAVED!");
                CatalinDialogFragment.this.dismiss();
            }
        });

        //set the Score
        TextView ScoreTV = (TextView) dialogDesign.findViewById(R.id.catalinDF_score);
        ScoreTV.setText(ScoreTV.getText()+Score);


        builder.setView(dialogDesign);
        return builder.create();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
