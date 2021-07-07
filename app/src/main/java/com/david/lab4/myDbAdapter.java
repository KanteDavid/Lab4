package com.david.lab4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class myDbAdapter
{
    private Context context;
    private final String DATABASE_NAME = "MaDb";
    private myDbHelper dbHelper;
    private final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public myDbAdapter(Context context)
    {
        this.context = context;
        this.dbHelper = new myDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void InsertClient (String nom, String prenom, String adresse, String user, String pw, int solde, int credit)
    {
        this.db.execSQL("INSERT INTO clients (nom, prenom,adresse,user, pw, solde, credit) VALUES ('Kante', 'David','Mtl', 'Dani', '8347', 100, 2);");
    }



    public ArrayList<Client> selectClient (String nom)
    {
//        this.db.execSQL("SELECT * FROM clients WHERE nom = " + nom );
        ArrayList<Client> client = new ArrayList<Client>();
        Cursor cursor = this.db.rawQuery("SELECT * FROM clients WHERE nom = " + nom, null);

        int nomIndex = cursor.getColumnIndex("nom");
        int prenomIndex = cursor.getColumnIndex("prenom");
        int adresseIndex = cursor.getColumnIndex("adresse");
        int userIndex = cursor.getColumnIndex("user");
        int pwIndex = cursor.getColumnIndex("pw");
        int soldeIndex = cursor.getColumnIndex("solde");
        int creditIndex = cursor.getColumnIndex("credit");
        int idIndex = cursor.getColumnIndex("id");

        if ((cursor != null) && cursor.moveToFirst())
        {
            do{
                client.add(new Client(cursor.getInt(idIndex), cursor.getString(nomIndex), cursor.getString(prenomIndex), cursor.getString(adresseIndex), cursor.getString(userIndex), cursor.getString(pwIndex), cursor.getInt(soldeIndex), cursor.getInt(creditIndex) ));
            }while (cursor.moveToNext());
        }

        return client;
    }

    public void deleteAllClients()
    {
        this.db.delete("clients", null, null);
    }

    public ArrayList<Client> SelectAllClients ()
    {
        ArrayList<Client> listOfClients = new ArrayList<Client>();
        Cursor cursor = this.db.rawQuery("SELECT * FROM clients", null);

        int nomIndex = cursor.getColumnIndex("nom");
        int prenomIndex = cursor.getColumnIndex("prenom");
        int adresseIndex = cursor.getColumnIndex("adresse");
        int userIndex = cursor.getColumnIndex("user");
        int pwIndex = cursor.getColumnIndex("pw");
        int soldeIndex = cursor.getColumnIndex("solde");
        int creditIndex = cursor.getColumnIndex("credit");
        int idIndex = cursor.getColumnIndex("id");

        if ((cursor != null) && cursor.moveToFirst())
        {
            do{
                listOfClients.add(new Client(cursor.getInt(idIndex), cursor.getString(nomIndex), cursor.getString(prenomIndex), cursor.getString(adresseIndex), cursor.getString(userIndex), cursor.getString(pwIndex), cursor.getInt(soldeIndex), cursor.getInt(creditIndex) ));
            }while (cursor.moveToNext());
        }

        return listOfClients;
    }


    public ArrayList<Client> SelectComptesDelinquants ()
    {
        ArrayList<Client> listOfClients = new ArrayList<Client>();
        Cursor cursor = this.db.rawQuery("SELECT * FROM clients WHERE credit > solde ", null);

        int nomIndex = cursor.getColumnIndex("nom");
        int prenomIndex = cursor.getColumnIndex("prenom");
        int adresseIndex = cursor.getColumnIndex("adresse");
        int userIndex = cursor.getColumnIndex("user");
        int pwIndex = cursor.getColumnIndex("pw");
        int soldeIndex = cursor.getColumnIndex("solde");
        int creditIndex = cursor.getColumnIndex("credit");
        int idIndex = cursor.getColumnIndex("id");

        if ((cursor != null) && cursor.moveToFirst())
        {
            do{
                listOfClients.add(new Client(cursor.getInt(idIndex), cursor.getString(nomIndex), cursor.getString(prenomIndex), cursor.getString(adresseIndex), cursor.getString(userIndex), cursor.getString(pwIndex), cursor.getInt(soldeIndex), cursor.getInt(creditIndex) ));
            }while (cursor.moveToNext());
        }

        return listOfClients;
    }

    public void effacerClient(String nom)
    {
        this.db.execSQL("DELETE FROM clients WHERE nom = " + nom);
    }

    public void modifierClient(String nom)
    {
        this.db.execSQL("UPDATE clients SET nom =" + nom + "WHERE id = 1;");
    }

    public void modifierCredit(int credit,String nom)
    {
        this.db.execSQL("UPDATE clients SET credit = " + credit + "WHERE nom = "  + nom);
    }

    public void modifierSolde(int solde,String nom)
    {
        this.db.execSQL("UPDATE clients SET solde = " + solde + "WHERE nom = "  + nom);
    }


    public void Open()
    {
        this.db = this.dbHelper.getWritableDatabase();
    }
}
