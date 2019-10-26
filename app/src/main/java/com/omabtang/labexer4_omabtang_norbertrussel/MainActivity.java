package com.omabtang.labexer4_omabtang_norbertrussel;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] verNames, country, industry, ceo, info;
    int[] logo = {R.drawable.icbc
            ,R.drawable.jpmorgan,R.drawable.chinaconstruction,
            R.drawable.agricultural,R.drawable.america,R.drawable.apple,R.drawable.pingan,R.drawable.bankofchina,
            R.drawable.royaldutch,R.drawable.wellsfargo,R.drawable.exxonmobil,R.drawable.att,R.drawable.samsung,R.drawable.citigroup};
    ArrayList<AndroidVersion> versions=new ArrayList<>();

    ListView lstVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get String from res folder
        verNames = getResources().getStringArray(R.array.VerName);
        country = getResources().getStringArray(R.array.rCountry);
        industry = getResources().getStringArray(R.array.rIndustry);
        ceo = getResources().getStringArray(R.array.rCEO);
        info = getResources().getStringArray(R.array.rInfo);

        for(int i = 0; i < verNames.length; i++){
            versions.add(new AndroidVersion(logo[i], verNames[i], country[i], industry[i], ceo[i]));

        }

        //Adapter for activity and list view
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item, versions);

        //setting list view component with id of lvAndroid to lstVersions variable
        lstVersions = findViewById(R.id.lvAndroid);

        //1stVersions consumes adapter
        lstVersions.setAdapter(adapter);

        //Set Listener Object
        lstVersions.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[i]);
        dialog.setTitle(verNames[i]);
        dialog.setMessage(info[i]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, verNames[i], Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();
    }
}


