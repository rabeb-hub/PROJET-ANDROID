package com.example.allotaxi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TaxisAdapter extends ArrayAdapter<Taxi> {

    private Context context;
    private ArrayList<Taxi> taxisList;
    public TaxisAdapter(Context context, ArrayList<Taxi> taxisList) {
        super(context, 0, taxisList);
        this.context = context;
        this.taxisList = taxisList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_taxi, parent, false);
        }

        // Obtenez l'élément Taxi pour cette position
        Taxi currentTaxi = getItem(position);

        // Récupérez les vues de l'élément_taxi.xml pour les personnaliser avec les données de Taxi
        ImageView imageViewTaxi = convertView.findViewById(R.id.imageViewTaxi);
        TextView textViewDriverName = convertView.findViewById(R.id.textViewDriverName);
        TextView textViewPrice = convertView.findViewById(R.id.textViewPrice);
        TextView textViewPhoneNumber = convertView.findViewById(R.id.textViewPhoneNumber);

        // Configurez les vues avec les données du taxi actuel
        if (currentTaxi != null) {
            imageViewTaxi.setImageResource(currentTaxi.getImage());
            textViewDriverName.setText(currentTaxi.getDriverName());
            textViewPrice.setText(currentTaxi.getPrice());
            textViewPhoneNumber.setText(currentTaxi.getPhoneNumber());
        }

        return convertView;
    }


}
