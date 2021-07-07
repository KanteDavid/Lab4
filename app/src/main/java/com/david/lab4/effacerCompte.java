package com.david.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class effacerCompte extends AppCompatActivity {

    private EditText nomSup;
    private Button btnSup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effacer_compte);

        this.nomSup = (EditText)findViewById(R.id.nomSuppression);
        this.btnSup = (Button)findViewById(R.id.supprimerCompte);

        this.btnSup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
                    myDbAdapter.Open();
                    myDbAdapter.effacerClient(nomSup.getText().toString());
                    String info = "Effacé";
                    Toast.makeText(getApplicationContext(),info,Toast.LENGTH_LONG).show();
                }
                catch (Exception Ex)
                {
                    Toast.makeText(getApplicationContext(),Ex.getMessage(),Toast.LENGTH_LONG).show();

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.creerNouveauCompte:
                Intent intentCreerNouveauCompte = new Intent(effacerCompte.this, creerNouveauCompte.class);
                startActivity(intentCreerNouveauCompte);
                return true;
            case R.id.effacerCompte:
                Intent intentEffacerCompte = new Intent(effacerCompte.this, effacerCompte.class);
                startActivity(intentEffacerCompte);
                return true;
            case R.id.modiferCompte:
                Intent intentModiferCompte = new Intent(effacerCompte.this, modiferCompte.class);
                startActivity(intentModiferCompte);
                return true;
            case R.id.modifierCreditCompte:
                Intent intentModifierCreditCompte = new Intent(effacerCompte.this, modifierCreditCompte.class);
                startActivity(intentModifierCreditCompte);
                return true;
            case R.id.modifierSoldeCompte:
                Intent intentModifierSoldeCompte = new Intent(effacerCompte.this, modifierSoldeCompte.class);
                startActivity(intentModifierSoldeCompte);
                return true;
            case R.id.obtenirComptesDelinquants:
                Intent intentObtenirComptesDelinquantse = new Intent(effacerCompte.this, obtenirComptesDelinquants.class);
                startActivity(intentObtenirComptesDelinquantse);
                return true;
            case R.id.obtenirInformationCompte:
                Intent intentObtenirInformationCompte = new Intent(effacerCompte.this, obtenirInformationCompte.class);
                startActivity(intentObtenirInformationCompte);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}