package com.david.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class obtenirComptesDelinquants extends AppCompatActivity {


    private ListView listView;
    private ArrayList<Client> clientArrayList;
    private ArrayAdapter adapter;
    private Button btnObtenirComptesDelinquants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtenir_comptes_delinquants);



        this.listView = (ListView)findViewById(R.id.listViewComptesDelinquants);
        ArrayList<Client> clientArrayList  = new ArrayList<Client>();

        clientArrayList.add(new Client(1,"Kante","David","Mtl","Dani", "8347", 100, 2));
        adapter = new ArrayAdapter(this, R.layout.listview, clientArrayList);
        listView.setAdapter(adapter);



        this.btnObtenirComptesDelinquants = (Button)findViewById(R.id.obtenirComptesDelinquants);
        this.btnObtenirComptesDelinquants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
                    myDbAdapter.Open();
                    ArrayList<Client> lstCptDelinquants = new ArrayList<Client>();
                    lstCptDelinquants = myDbAdapter.SelectComptesDelinquants();
                }
                catch (Exception Ex)
                {
                    Log.i("dbTest", Ex.getMessage());
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
                Intent intentCreerNouveauCompte = new Intent(obtenirComptesDelinquants.this, creerNouveauCompte.class);
                startActivity(intentCreerNouveauCompte);
                return true;
            case R.id.effacerCompte:
                Intent intentEffacerCompte = new Intent(obtenirComptesDelinquants.this, effacerCompte.class);
                startActivity(intentEffacerCompte);
                return true;
            case R.id.modiferCompte:
                Intent intentModiferCompte = new Intent(obtenirComptesDelinquants.this, modiferCompte.class);
                startActivity(intentModiferCompte);
                return true;
            case R.id.modifierCreditCompte:
                Intent intentModifierCreditCompte = new Intent(obtenirComptesDelinquants.this, modifierCreditCompte.class);
                startActivity(intentModifierCreditCompte);
                return true;
            case R.id.modifierSoldeCompte:
                Intent intentModifierSoldeCompte = new Intent(obtenirComptesDelinquants.this, modifierSoldeCompte.class);
                startActivity(intentModifierSoldeCompte);
                return true;
            case R.id.obtenirComptesDelinquants:
                Intent intentObtenirComptesDelinquantse = new Intent(obtenirComptesDelinquants.this, obtenirComptesDelinquants.class);
                startActivity(intentObtenirComptesDelinquantse);
                return true;
            case R.id.obtenirInformationCompte:
                Intent intentObtenirInformationCompte = new Intent(obtenirComptesDelinquants.this, obtenirInformationCompte.class);
                startActivity(intentObtenirInformationCompte);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}