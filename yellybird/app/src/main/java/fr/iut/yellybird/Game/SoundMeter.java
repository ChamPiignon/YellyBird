package fr.iut.yellybird.Game;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

import java.io.File;
import java.io.IOException;

public class SoundMeter {
//    private MediaRecorder microphone;
//    public boolean isRecording = false ;
//
//    public float getMaxAmplitude() {
//        if (microphone != null) {
//            try {
//                return microphone.getMaxAmplitude();
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//                return 0;
//            }
//        } else {
//            return 5;
//        }
//    }
//
//    /**
//     * Recording
//     * @return Whether to start recording successfully
//     */
//    public boolean startRecorder(){
//        try {
//            microphone = new MediaRecorder();
//
//            microphone.setAudioSource(MediaRecorder.AudioSource.MIC);
//            microphone.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//            microphone.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//
//            microphone.prepare();
//            microphone.start();
//            isRecording = true;
//            return true;
//        } catch(IOException exception) {
//            microphone.reset();
//            microphone.release();
//            microphone = null;
//            isRecording = false ;
//            exception.printStackTrace();
//        }catch(IllegalStateException e){
//            stopRecording();
//            e.printStackTrace();
//            isRecording = false ;
//        }
//        return false;
//    }
//
//    public void stopRecording() {
//        if (microphone != null){
//            if(isRecording){
//                try{
//                    microphone.stop();
//                    microphone.release();
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//            microphone = null;
//            isRecording = false ;
//        }
//    }

    private AudioRecord ar = null;
    private int minSize;

    public void start() {
        minSize= AudioRecord.getMinBufferSize(8000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
        ar = new AudioRecord(MediaRecorder.AudioSource.MIC, 8000,AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT,minSize);
        ar.startRecording();
    }

    public void stop() {
        if (ar != null) {
            ar.stop();
        }
    }

    public double getAmplitude() {
        short[] buffer = new short[minSize];
        ar.read(buffer, 0, minSize);
        int max = 0;
        for (short s : buffer)
        {
            if (Math.abs(s) > max)
            {
                max = Math.abs(s);
            }
        }
        return max;
    }

}
