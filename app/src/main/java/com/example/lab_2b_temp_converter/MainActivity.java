package com.example.lab_2b_temp_converter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.lab_2b_temp_converter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView f = binding.fahrenheitInput;
                TextView c = binding.celsiusInput;
                double temp = 0.0;

                try {
                    if (!f.getText().toString().isEmpty()) {
                        temp = Double.parseDouble(f.getText().toString());
                        c.setText(String.format("%.1f", ((temp - 32) / 1.8)));
                    } else if (!c.getText().toString().isEmpty()) {
                        temp = Double.parseDouble(c.getText().toString());
                        f.setText(String.format("%.1f", ((temp * 1.8) + 32)));
                    }
                } catch (NumberFormatException e) {
                    Log.i("Error", "Error");
                }
            }
        });
    }
}