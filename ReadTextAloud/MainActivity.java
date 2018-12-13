package com.example.pd.textreader;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private static final int MY_DATA_CHECK_CODE = 1;
    private Button read;
    private EditText text;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    text = findViewById(R.id.editText);
    read = findViewById(R.id.button);

    read.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tx = text.getText().toString();
            if(tx!=null && tx.length()>0)
                tts.speak(tx,TextToSpeech.QUEUE_ADD,null);
        }
    });

    Intent cIntent = new Intent();
    cIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);

    startActivityForResult(cIntent, MY_DATA_CHECK_CODE);

    }

    protected void onActivityResult(int reqCode, int resCode, Intent data){
        if(reqCode == MY_DATA_CHECK_CODE){
            if(resCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
                tts = new TextToSpeech(this,this);
            }
            else{
                Intent insIntent = new Intent();
                insIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                startActivity(insIntent);
            }
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            Toast.makeText(this, "Text TO Speech Initialized...", Toast.LENGTH_LONG).show();
        }
        else if (status == TextToSpeech.ERROR){
            Toast.makeText(this, "error occurred", Toast.LENGTH_LONG).show();
        }
    }
}
