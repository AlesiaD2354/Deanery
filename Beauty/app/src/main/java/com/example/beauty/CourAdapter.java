package com.example.beauty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class CourAdapter extends ArrayAdapter<Cour> {
    public CourAdapter(@NonNull Context context, List<Cour> cours) {
        super(context, 0, cours);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Cour courData = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.course_list_item, parent,false);
        }

        TextView textViewSubjectName = convertView.findViewById(R.id.textViewSubjectName);
        TextView textViewSession = convertView.findViewById(R.id.textViewSession);
        TextView textViewExams = convertView.findViewById(R.id.textViewExams);
        TextView textViewPractice = convertView.findViewById(R.id.textViewPractice);
        TextView textViewInternship = convertView.findViewById(R.id.textViewInternship);
        TextView textViewEndInternshipDate =convertView.findViewById(R.id.textViewInternshipEndDate);
        TextView textViewDiploma = convertView.findViewById(R.id.textViewDiploma);
        TextView textViewGroupName = convertView.findViewById(R.id.textViewGroupName);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedStartSessionDate = courData.getSession().getStartDate().format(formatter);
        String formattedEndSessionDate = courData.getSession().getEndDate().format(formatter);
        String formattedExams = courData.getExams().format(formatter);
        String formattedStartPracticeDate = courData.getPractice().getStartDate().format(formatter);
        String formattedEndPracticeDate = courData.getPractice().getEndDate().format(formatter);
        String formattedStartInternShipDate = courData.getInternship().getStartDate().format(formatter);
        String formattedEndInternShipDate = courData.getInternship().getEndDate().format(formatter);
        String formattedDiploma = courData.getDiploma().format(formatter);

        textViewSubjectName.setText(courData.getSubjectName());
        textViewSession.setText(formattedStartSessionDate + " - " + formattedEndSessionDate);
        textViewExams.setText(formattedExams);
        textViewPractice.setText(formattedStartPracticeDate + " - " + formattedEndPracticeDate);
        textViewInternship.setText(formattedStartInternShipDate + " - ");
        textViewEndInternshipDate.setText(formattedEndInternShipDate);
        textViewDiploma.setText(formattedDiploma);
        textViewGroupName.setText(courData.getGroupName());

        return convertView;
    }
}
