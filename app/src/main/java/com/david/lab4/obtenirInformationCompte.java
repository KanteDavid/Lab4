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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class obtenirInformationCompte extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Client> clientArrayList;
    private ArrayAdapter adapter;
    private EditText nom;
    private EditText prenom;
    private EditText adresse;
    private EditText user;
    private EditText pw;
    private EditText solde;
    private EditText credit;
    private Button btn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtenir_information_compte);

        this.listView = (ListView)findViewById(R.id.listViewLst);
        ArrayList<Client> clientArrayList  = new ArrayList<Client>();

        clientArrayList.add(new Client(1,"Kante","David","Mtl","Dani", "8347", 100, 2));
        adapter = new ArrayAdapter(this, R.layout.listview, clientArrayList);
        listView.setAdapter(adapter);



        this.btn = (Button)findViewById(R.id.obtenirInfo);
        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
                    myDbAdapter.Open();
//                    myDbAdapter.InsertClient("David", "Kante","Mtl", "Dani", "8347", 100, 2);
                    ArrayList<Client> ls = new ArrayList<Client>();
                    ls = myDbAdapter.SelectAllClients();
//                    Log.i("dbTest", String.valueOf(ls.size()));
//                    myDbAdapter.effacerClient();
//                    ls = myDbAdapter.SelectAllClients();
//                    Log.i("dbTest", String.valueOf(ls.size()));
//                    String info = String.valueOf(ls.size"());
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
                Intent intentCreerNouveauCompte = new Intent(obtenirInformationCompte.this, creerNouveauCompte.class);
                startActivity(intentCreerNouveauCompte);
                return true;
            case R.id.effacerCompte:
                Intent intentEffacerCompte = new Intent(obtenirInformationCompte.this, effacerCompte.class);
                startActivity(intentEffacerCompte);
                return true;
            case R.id.modiferCompte:
                Intent intentModiferCompte = new Intent(obtenirInformationCompte.this, modiferCompte.class);
                startActivity(intentModiferCompte);
                return true;
            case R.id.modifierCreditCompte:
                Intent intentModifierCreditCompte = new Intent(obtenirInformationCompte.this, modifierCreditCompte.class);
                startActivity(intentModifierCreditCompte);
                return true;
            case R.id.modifierSoldeCompte:
                Intent intentModifierSoldeCompte = new Intent(obtenirInformationCompte.this, modifierSoldeCompte.class);
                startActivity(intentModifierSoldeCompte);
                return true;
            case R.id.obtenirComptesDelinquants:
                Intent intentObtenirComptesDelinquantse = new Intent(obtenirInformationCompte.this, obtenirComptesDelinquants.class);
                startActivity(intentObtenirComptesDelinquantse);
                return true;
            case R.id.obtenirInformationCompte:
                Intent intentObtenirInformationCompte = new Intent(obtenirInformationCompte.this, obtenirInformationCompte.class);
                startActivity(intentObtenirInformationCompte);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    public void obtenirInfo(View view)
//    {
//        try
//        {
//            myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
//            myDbAdapter.Open();
//            myDbAdapter.InsertClient("Kante", "David","Mtl", "Dani", "8347", 100, 2);
//            ArrayList<Client> listClient = new ArrayList<Client>();
////            listClient = myDbAdapter.SelectAllClients();
//            listClient = myDbAdapter.selectClient("Kante");
////            Log.i("dbTest", String.valueOf(ls.size()));
////            myDbAdapter.effacerClient();
////            listClient = myDbAdapter.SelectAllClients();
////            Log.i("dbTest", String.valueOf(listClient.size()));
//        }
//        catch (Exception Ex)
//        {
//            AlertDialog.Builder adb = new  AlertDialog.Builder(this);
//            adb.setTitle("OUPS !!!");
//            adb.setMessage(Ex.getMessage());
//
//            AlertDialog ad = adb.create();
//            ad.show();
//        }
//    }
}