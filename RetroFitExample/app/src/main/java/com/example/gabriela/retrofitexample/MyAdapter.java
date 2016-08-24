package com.example.gabriela.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriela on 8/24/2016.
 */
public class MyAdapter extends ArrayAdapter<Question> {

    private Context context;
    private ArrayList<Question> questions;

    public MyAdapter(Context context, int resource, List<Question> objects) {
        super(context, resource, objects);
        this.context = context;
        this.questions = (ArrayList) objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        TextView firstTextView = (TextView) rowView.findViewById(R.id.titleTextView);
        TextView secondTextView = (TextView) rowView.findViewById(R.id.linkTextView);

        firstTextView.setText(questions.get(position).title);
        secondTextView.setText(questions.get(position).link);

        return rowView;

    }
}
