package com.example.resourcechapter;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rdGrpDayNight;
    private ProgressBar progressBar1, progressBar2;
    private Button btnAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdGrpDayNight = findViewById(R.id.rdGrpDayNight);

        btnAnim = findViewById(R.id.btnAnime);

        btnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // user get some wrong
                final Animation shakeAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                btnAnim.startAnimation(shakeAnimation);
            }
        });

        int checkedRdBtn = rdGrpDayNight.getCheckedRadioButtonId();
        if (checkedRdBtn == R.id.radDay) {
            Toast.makeText(MainActivity.this, "It is a day", Toast.LENGTH_LONG).show();
            } else if (checkedRdBtn == R.id.radNone) {
            Toast.makeText(MainActivity.this, "It is a none", Toast.LENGTH_SHORT).show();
            }else if (checkedRdBtn == R.id.radNight) {
            Toast.makeText(MainActivity.this, "It is night", Toast.LENGTH_SHORT).show();}


        // Initialize the RadioGroup and ProgressBars

        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);

        // Set a listener on the RadioGroup
        rdGrpDayNight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radDay) {
                    Toast.makeText(MainActivity.this, "It is a day", Toast.LENGTH_LONG).show();
                    progressBar1.setVisibility(View.VISIBLE);
                    progressBar2.setVisibility(View.VISIBLE);
                    progressBar2.setProgress(75);
                } else if (checkedId == R.id.radNone) {
                    Toast.makeText(MainActivity.this, "It is a none", Toast.LENGTH_SHORT).show();
                    progressBar1.setVisibility(View.GONE);
                    progressBar2.setVisibility(View.GONE);
                } else if (checkedId == R.id.radNight) {
                    Toast.makeText(MainActivity.this, "It is night", Toast.LENGTH_SHORT).show();
                    progressBar1.setVisibility(View.VISIBLE);
                    progressBar2.setVisibility(View.VISIBLE);
                    progressBar2.setProgress(25);
                }
            }
        });
    }
}