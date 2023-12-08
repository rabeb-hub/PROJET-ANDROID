package com.example.allotaxi;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;

import android.widget.ListView;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;


public class DestinationActivity extends AppCompatActivity {

    private ListView listViewTaxis;
    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        textViewWelcome = findViewById(R.id.textViewWelcome);
        listViewTaxis = findViewById(R.id.listViewTaxis);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            String username = user.getDisplayName();
            textViewWelcome.setText("Bienvenue " + (username != null && !username.isEmpty() ? username : "Utilisateur"));
        }
        ArrayList<Taxi> taxisList = new ArrayList<>();
        taxisList.add(new Taxi(R.drawable.taxi_image, "Chauffeur basic", "25", "123456789"));
        taxisList.add(new Taxi(R.drawable.taxi_image, "Chauffeur standard", "50", "987654321"));
        taxisList.add(new Taxi(R.drawable.taxi_image, "Chauffeur premium", "75", "1111111111"));


        TaxisAdapter adapter = new TaxisAdapter(this, taxisList);
        listViewTaxis.setAdapter(adapter);

        listViewTaxis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Taxi selectedTaxi = (Taxi) parent.getItemAtPosition(position);

                if (selectedTaxi != null && selectedTaxi.getPhoneNumber() != null && !selectedTaxi.getPhoneNumber().isEmpty()) {
                    String phoneNumber = selectedTaxi.getPhoneNumber();

                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    startActivity(intent);
                } else {
                    Toast.makeText(DestinationActivity.this, "Numéro de téléphone non disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}