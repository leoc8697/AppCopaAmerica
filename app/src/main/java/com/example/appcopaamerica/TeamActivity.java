package com.example.appcopaamerica;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static com.example.appcopaamerica.R.id.imgResultScan;

public class TeamActivity extends AppCompatActivity {

    Activity activity = this;

    private boolean addingNew = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.initiateScan();

            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent, Activity activity, Context context) {
        if (resultCode == RESULT_OK) {
            IntentResult scanResult = IntentIntegrator.parseActivityResult(
                    requestCode, resultCode, intent);
            if (scanResult != null) {
                // Handle successful scan
                String contents = scanResult.getContents();

                Picasso.with(context).load(contents)
                        .into((ImageView) findViewById(R.id.imgResultScan));


            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, R.string.scan_canceled, Toast.LENGTH_SHORT)
                    .show();
        }

    }

}
