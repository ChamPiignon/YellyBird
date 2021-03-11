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

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    MediaRecorder mrecorder;
    boolean mStartRecording=false;

    private final String[] permissions = {Manifest.permission.RECORD_AUDIO};
    private final int permsRequestCode = 666;
    private static final int PERMISSION_REQUEST_CODE = 200;
    private View view;

    Button start, stop;
    private void startRec() throws IOException {
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // We can read and write the media
            mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // We can only read the media
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            // Something else is wrong. It may be one of many other states, but all we need
            //  to know is we can neither read nor write
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }
        File sdCardDirectory= Environment
                .getExternalStorageDirectory();
        if(mExternalStorageAvailable && !sdCardDirectory.exists())
        {
            sdCardDirectory.mkdir();
        }
        File f= new File(sdCardDirectory.getPath()+"/"+System.currentTimeMillis()+".mp3");
        if( mrecorder == null ) {
            mrecorder = new MediaRecorder();
            System.out.println("BEFORE SETTINGS");
            mrecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_RECOGNITION);
            mrecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

            mrecorder.setOutputFile(f.getPath());
            mrecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        }
        if(!mStartRecording) {

            try {
                mrecorder.prepare();
                mrecorder.start();
                mStartRecording = true;
            }  catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void stopRec() throws IOException {

        if(mStartRecording) {
            mStartRecording = false;
            mrecorder.stop();
            mrecorder.reset();
            mrecorder.release();
            mrecorder = null;
        }
    }

    @Override
    public void onClick(View v) {
        view = v;

        int id = v.getId();
        switch (id) {
            case R.id.btn_success:
                if (checkPermission()) {
                    Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(view, "Please request permission.", Snackbar.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_skins:
                if (!checkPermission()) {
                    requestPermission();
                }
                else {
                    Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_LONG).show();
                }
                break;
        }

    }


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

                    if (microAccepted)
                        Snackbar.make(view, "Permission Granted, Now you can access micro.", Snackbar.LENGTH_LONG).show();
                    else {
                        Snackbar.make(view, "Permission Denied, You cannot access micro.", Snackbar.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
//
//
//    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
//        new AlertDialog.Builder(MenuActivity.this)
//                .setMessage(message)
//                .setPositiveButton("OK", okListener)
//                .setNegativeButton("Cancel", null)
//                .create()
//                .show();
//    }


    private Button restart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//        requestPermissions(permissions, permsRequestCode);
//        if(checkIfAlreadyhavePermission()) {
//            System.out.println("PERMISSION ALREADY GRANTED");
//        }
//        else{
//            requestForSpecificPermission();
//            onRequestPermissionsResult(101,
//        }

        this.restart = (Button) findViewById(R.id.btn_restart);

        start =(Button) findViewById(R.id.btn_success);
        stop =(Button) findViewById(R.id.btn_skins);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(activity);
                finish();
            }
        });
    }

}
