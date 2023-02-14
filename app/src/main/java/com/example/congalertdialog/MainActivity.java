package com.example.congalertdialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder adb;
    ConstraintLayout CL;
    Random rnd = new Random();
    final String[] colors = {"Red", "Green", "Blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CL = (ConstraintLayout) findViewById(R.id.CL);
    }

    /**
     * this function is for the first button when the user wants to make the screen to a rgb color
     * @param view
     */
    public void firstClicked(View view)
    {
        int[] color = new int[]{0, 0, 0};
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Change color");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i] = 255;
                CL.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });

        adb.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * this function is for the second button when the user wants to make the screen to a random color
     * @param view
     */
    public void secondClicked(View view)
    {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Change color");
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CL.setBackgroundColor(Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
            }
        });

        adb.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * this function is for the third button that makes teh screen white
     * @param view
     */
    public void thirdClick(View view)
    {
        CL.setBackgroundColor(Color.WHITE);
    }

    /**
     * this function is for the fourth button when the user gives input
     * @param view
     */
    public void fourthClick(View view)
    {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);

        final EditText edt = new EditText(this);
        edt.setHint("Type text here");
        adb.setView(edt);

        adb.setPositiveButton("Copy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String input = edt.getText().toString();
                Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();
            }
        });

        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * This fujcntion create an options menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * This function sends to the next activitys
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent si = new Intent(this, MainActivity2.class);
        startActivity(si);
        return super.onOptionsItemSelected(item);
    }
}