package fr.iut.yellybird.models;

import android.media.MediaRecorder;

import java.io.File;
import java.io.IOException;

public class SoundMeter {
    public File audioFile;
    private MediaRecorder microphone;
    public boolean isRecording = false ;

    public float getMaxAmplitude() {
        if (microphone != null) {
            try {
                return microphone.getMaxAmplitude();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return 0;
            }
        } else {
            return 5;
        }
    }

    public File getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(File audioFile) {
        this.audioFile = audioFile;
    }

    /**
     * Recording
     * @return Whether to start recording successfully
     */
    public boolean startRecorder(){
        if (audioFile == null) {
            return false;
        }
        try {
            microphone = new MediaRecorder();

            microphone.setAudioSource(MediaRecorder.AudioSource.VOICE_RECOGNITION);
            microphone.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            microphone.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            //microphone.setOutputFile(audioFile.getAbsolutePath());

            microphone.prepare();
            microphone.start();
            isRecording = true;
            return true;
        } catch(IOException exception) {
            microphone.reset();
            microphone.release();
            microphone = null;
            isRecording = false ;
            exception.printStackTrace();
        }catch(IllegalStateException e){
            stopRecording();
            e.printStackTrace();
            isRecording = false ;
        }
        return false;
    }

    public void stopRecording() {
        if (microphone != null){
            if(isRecording){
                try{
                    microphone.stop();
                    microphone.release();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            microphone = null;
            isRecording = false ;
        }
    }

    public void delete() {
        stopRecording();
        if (audioFile != null) {
            audioFile.delete();
            audioFile = null;
        }
    }
}
