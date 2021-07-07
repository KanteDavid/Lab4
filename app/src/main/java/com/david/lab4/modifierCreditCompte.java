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

public class modifierCreditCompte extends AppCompatActivity {

    private EditText nomModife;
    private  EditText creditModife;
    private Button btnModifierCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_credit_compte);

        this.creditModife = (EditText)findViewById(R.id.CreditModife);
        this.nomModife = (EditText)findViewById(R.id.NomModife);
        this.btnModifierCredit = (Button)findViewById(R.id.btnModifierCredit);

        this.btnModifierCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
                    myDbAdapter.Open();
                    myDbAdapter.modifierCredit(Integer.parseInt(creditModife.getText().toString()), nomModife.getText().toString());
                    String info = "Crédit Modifié!";
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
                Intent intentCreerNouveauCompte = new Intent(modifierCreditCompte.this, creerNouveauCompte.class);
                startActivity(intentCreerNouveauCompte);
                return true;
            case R.id.effacerCompte:
                Intent intentEffacerCompte = new Intent(modifierCreditCompte.this, effacerCompte.class);
                startActivity(intentEffacerCompte);
                return true;
            case R.id.modiferCompte:
                Intent intentModiferCompte = new Intent(modifierCreditCompte.this, modiferCompte.class);
                startActivity(intentModiferCompte);
                return true;
            case R.id.modifierCreditCompte:
                Intent intentModifierCreditCompte = new Intent(modifierCreditCompte.this, modifierCreditCompte.class);
                startActivity(intentModifierCreditCompte);
                return true;
            case R.id.modifierSoldeCompte:
                Intent intentModifierSoldeCompte = new Intent(modifierCreditCompte.this, modifierSoldeCompte.class);
                startActivity(intentModifierSoldeCompte);
                return true;
            case R.id.obtenirComptesDelinquants:
                Intent intentObtenirComptesDelinquantse = new Intent(modifierCreditCompte.this, obtenirComptesDelinquants.class);
                startActivity(intentObtenirComptesDelinquantse);
                return true;
            case R.id.obtenirInformationCompte:
                Intent intentObtenirInformationCompte = new Intent(modifierCreditCompte.this, obtenirInformationCompte.class);
                startActivity(intentObtenirInformationCompte);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}