package fr.iut.yellybird.view;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

import fr.iut.yellybird.Game.SoundMeter;
import fr.iut.yellybird.R;

public class MenuActivity extends AppCompatActivity{
    private final String[] permissions = {Manifest.permission.RECORD_AUDIO};
    private static final int PERMISSION_REQUEST_CODE = 666;

    private Button restart;


    private boolean checkPermission() {
        int result = ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED;
    }
//
    private void requestPermission() {
        ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean microAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                }
                break;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(checkPermission()){
            System.out.println("PERMISSION ALREADY GRANTED");
        }
        else{
            this.requestPermission();
        }

        this.restart = (Button) findViewById(R.id.btn_restart);

        restart.setOnClickListener(view -> {
            Intent activity = new Intent(getApplicationContext(),GameActivity.class);
            startActivity(activity);
            finish();
        });
    }

}
