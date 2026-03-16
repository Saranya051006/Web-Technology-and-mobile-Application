package io.github.notwrench.calculatorapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import io.github.notwrench.calculatorapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(v -> calculate('+'));
        binding.btnSub.setOnClickListener(v -> calculate('-'));
        binding.btnMul.setOnClickListener(v -> calculate('*'));
        binding.btnDiv.setOnClickListener(v -> calculate('/'));

        binding.btnClear.setOnClickListener(v -> {
            binding.etNum1.setText("");
            binding.etNum2.setText("");
            binding.tvResult.setText("Result will appear here");
        });
    }

    private void calculate(char op) {
        String a = binding.etNum1.getText().toString();
        String b = binding.etNum2.getText().toString();

        if (a.isEmpty() || b.isEmpty()) {
            binding.tvResult.setText("Please enter both numbers");
            return;
        }

        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);
        double res;

        switch (op) {
            case '+': res = x + y; break;
            case '-': res = x - y; break;
            case '*': res = x * y; break;
            case '/':
                if (y == 0) {
                    binding.tvResult.setText("Cannot divide by zero");
                    return;
                }
                res = x / y;
                break;
            default:
                return;
        }

        binding.tvResult.setText("Result: " + res);
    }
}