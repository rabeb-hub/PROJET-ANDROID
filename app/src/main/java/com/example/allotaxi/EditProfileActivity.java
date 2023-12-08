package com.example.allotaxi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class EditProfileActivity extends AppCompatActivity {

    private EditText editTextNewUsername, editTextNewEmail;
    private Button buttonSaveChanges;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_activity);

        mAuth = FirebaseAuth.getInstance();

        editTextNewUsername = findViewById(R.id.editTextNewUsername);
        editTextNewEmail = findViewById(R.id.editTextNewEmail);
        buttonSaveChanges = findViewById(R.id.buttonSaveChanges);

        buttonSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les nouvelles informations saisies par l'utilisateur
                String newUsername = editTextNewUsername.getText().toString().trim();
                String newEmail = editTextNewEmail.getText().toString().trim();

                // Mettre à jour les informations de l'utilisateur dans Firebase Authentication
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(newUsername)
                            .build();

                    user.updateProfile(profileUpdates)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Mise à jour réussie
                                        Toast.makeText(EditProfileActivity.this, "Modifications enregistrées avec succès", Toast.LENGTH_SHORT).show();
                                        // Redirection vers la page de profil après modification
                                        Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                                        startActivity(intent);
                                    } else {
                                        // Échec de la mise à jour
                                        Toast.makeText(EditProfileActivity.this, "Échec de l'enregistrement des modifications", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
