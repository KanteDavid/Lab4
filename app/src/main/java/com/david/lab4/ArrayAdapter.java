package com.david.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArrayAdapter extends android.widget.ArrayAdapter<Client>
{
    private Context context;
    private ArrayList <Client> cl;
    private int ressource;
    public ArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Client> objects) {
        super(context, resource, objects);

        this.context = context;
        this.ressource = resource;
        cl = new ArrayList<Client>();
        cl = (ArrayList<Client>)objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Client eClient = this.cl.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.ressource, parent, false);

        TextView nom = (TextView)convertView.findViewById(R.id.nom);
        TextView prenom = (TextView)convertView.findViewById(R.id.prenom);
        TextView adresse = (TextView)convertView.findViewById(R.id.adresse);
        TextView user = (TextView)convertView.findViewById(R.id.user);
        TextView pw = (TextView)convertView.findViewById(R.id.pw);
        TextView solde = (TextView)convertView.findViewById(R.id.solde);
        TextView credit = (TextView) convertView.findViewById(R.id.credit);


        nom.setText("Nom: " + eClient.getNom());
        prenom.setText("Prenom: " + eClient.getPrenom());
        adresse.setText("Adresse: " + eClient.getAdresse());
        user.setText("User: " + eClient.getUser());
        pw.setText("Password: " + eClient.getPw());
        solde.setText("Solde: " + eClient.getSolde());
        credit.setText("Crédit: " + eClient.getCredit());

        return convertView;

    }
}
