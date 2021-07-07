package com.david.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.DialerFilter;
import java.util.ArrayList;

public class creerNouveauCompte extends AppCompatActivity {

    private EditText newNom;
    private EditText newPrenom;
    private EditText newAdresse;
    private EditText newUser;
    private EditText newPW;
    private EditText newSolde;
    private EditText newCredit;
    private Button btnAjout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_nouveau_compte);


        this.newAdresse = (EditText)findViewById(R.id.newAdresse);
        this.newNom = (EditText)findViewById(R.id.newNom);
        this.newUser = (EditText)findViewById(R.id.newUser);
        this.newPW = (EditText)findViewById(R.id.newPW);
        this.newSolde = (EditText)findViewById(R.id.newSolde);
        this.newCredit = (EditText)findViewById(R.id.newCredit);
        this.newPrenom = (EditText)findViewById(R.id.newPrenom);
        this.btnAjout = (Button)findViewById(R.id.btnAjout);

        this.btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
                    myDbAdapter.Open();
                    myDbAdapter.InsertClient(newNom.getText().toString(), newPrenom.getText().toString(),newAdresse.getText().toString(), newUser.getText().toString(), newPW.getText().toString(),Integer.parseInt(newSolde.getText().toString()), Integer.parseInt(newCredit.getText().toString()) );
                    String info = "Ajouté";
                    Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();
                }
                catch (Exception Ex)
                {
//                    AlertDialog.Builder adb = new AlertDialog.Builder(this);
//                    adb.setTitle("OUPS !!!");
//                    adb.setMessage(Ex.getMessage());
//
//                    AlertDialog ad = adb.create();
//                    ad.show();
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
                Intent intentCreerNouveauCompte = new Intent(creerNouveauCompte.this, creerNouveauCompte.class);
                startActivity(intentCreerNouveauCompte);
                return true;
            case R.id.effacerCompte:
                Intent intentEffacerCompte = new Intent(creerNouveauCompte.this, effacerCompte.class);
                startActivity(intentEffacerCompte);
                return true;
            case R.id.modiferCompte:
                Intent intentModiferCompte = new Intent(creerNouveauCompte.this, modiferCompte.class);
                startActivity(intentModiferCompte);
                return true;
            case R.id.modifierCreditCompte:
                Intent intentModifierCreditCompte = new Intent(creerNouveauCompte.this, modifierCreditCompte.class);
                startActivity(intentModifierCreditCompte);
                return true;
            case R.id.modifierSoldeCompte:
                Intent intentModifierSoldeCompte = new Intent(creerNouveauCompte.this, modifierSoldeCompte.class);
                startActivity(intentModifierSoldeCompte);
                return true;
            case R.id.obtenirComptesDelinquants:
                Intent intentObtenirComptesDelinquantse = new Intent(creerNouveauCompte.this, obtenirComptesDelinquants.class);
                startActivity(intentObtenirComptesDelinquantse);
                return true;
            case R.id.obtenirInformationCompte:
                Intent intentObtenirInformationCompte = new Intent(creerNouveauCompte.this, obtenirInformationCompte.class);
                startActivity(intentObtenirInformationCompte);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}