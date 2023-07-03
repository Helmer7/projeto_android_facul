package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class tela23 extends AppCompatActivity {
    private Button qrbtn;
    private ImageView qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela23);
        qrbtn = (Button) findViewById(R.id.qrbtn);
        qr = (ImageView) findViewById(R.id.qr);
        final Activity activity = this;
        qrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //URL da aplicação
                String url = "https://torbenn-1.github.io/sitefacul/".trim();
                MultiFormatWriter writer = new MultiFormatWriter();
                try {
                    BitMatrix matrix = writer.encode(url, BarcodeFormat.QR_CODE, 350, 350);
                    BarcodeEncoder  encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(matrix);
                    qr.setImageBitmap((bitmap));
                    InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    Toast.makeText(activity, "QrCode Gerado para o site", Toast.LENGTH_SHORT).show();

                } catch (WriterException e ){
                    e.printStackTrace();
                }

            }
        });

    }



}
