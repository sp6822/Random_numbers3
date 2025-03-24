package com.example.random_numbers3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.random_numbers3.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView Random1, Random2, answer2, Random2_2, answer3, Random2_3;
    EditText user_input, user_input2, input_user3;
    ImageView result_image, result_image2, result_image3;
    Button check_answer, check_answer2, check_answer3, new_button;
    int num1, num2, num3, num4, wins;
    Random random = new Random();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // חיבור רכיבי ה-XML
        Random1 = findViewById(R.id.Random1);
        Random2 = findViewById(R.id.Random2);
        user_input = findViewById(R.id.user_input);
        check_answer = findViewById(R.id.check_answer);
        result_image = findViewById(R.id.result_image);
        answer2 = findViewById(R.id.answer2);
        Random2_2 = findViewById(R.id.Random2_2);
        user_input2 = findViewById(R.id.user_input2);
        check_answer2 = findViewById(R.id.check_answer2);
        result_image2 = findViewById(R.id.result_image2);
        answer3 = findViewById(R.id.answer3);
        Random2_3 = findViewById(R.id.Random2_3);
        input_user3 = findViewById(R.id.input_user3);
        check_answer3 = findViewById(R.id.check_answer3);
        result_image3 = findViewById(R.id.result_image3);
        new_button = findViewById(R.id.new_button);

        restartGame();
    }

    public void check(View view) {
        String input = user_input.getText().toString();
        if (!input.equals("")) {
            if (num1 + num2 == Integer.parseInt(input)) {
                result_image.setVisibility(View.VISIBLE);
                wins++;
            } else {
                result_image.setImageResource(R.drawable.ex);
                result_image.setVisibility(View.VISIBLE);
            }
            user_input.setEnabled(false);
            check_answer.setEnabled(false);
            answer2.setText(String.valueOf(num1 + num2));
            answer2.setVisibility(View.VISIBLE);

            num3 = random.nextInt(89) + 10;
            Random2_2.setText(String.valueOf(num3));
            Random2_2.setVisibility(View.VISIBLE);
            user_input2.setVisibility(View.VISIBLE);
            check_answer2.setVisibility(View.VISIBLE);
        }
    }

    public void check2(View view) {
        String input = user_input2.getText().toString();
        if (!input.equals("")) {
            if ((num1 + num2) + num3 == Integer.parseInt(input)) {
                result_image2.setVisibility(View.VISIBLE);
                wins++;
            } else {
                result_image2.setImageResource(R.drawable.ex);
                result_image2.setVisibility(View.VISIBLE);
            }
            user_input2.setEnabled(false);
            check_answer2.setEnabled(false);
            answer3.setText(String.valueOf((num1 + num2) + num3));
            answer3.setVisibility(View.VISIBLE);

            num4 = random.nextInt(89) + 10;
            Random2_3.setText(String.valueOf(num4));
            Random2_3.setVisibility(View.VISIBLE);
            input_user3.setVisibility(View.VISIBLE);
            check_answer3.setVisibility(View.VISIBLE);
        }
    }

    public void check3(View view) {
        String input = input_user3.getText().toString();
        if (!input.equals("")) {
            if ((num1 + num2 + num3) + num4 == Integer.parseInt(input)) {
                result_image3.setVisibility(View.VISIBLE);
                wins++;
            } else {
                result_image3.setImageResource(R.drawable.ex);
                result_image3.setVisibility(View.VISIBLE);
            }
            input_user3.setEnabled(false);
            check_answer3.setEnabled(false);
            new_button.setText(String.format("%d/3 (%.2f%%)", wins, (wins / 3.0) * 100));
        }
    }

    public void restartGame() {
        num1 = random.nextInt(89) + 10;
        num2 = random.nextInt(89) + 10;
        num3 = random.nextInt(89) + 10;
        num4 = random.nextInt(89) + 10;
        wins = 0;

        Random1.setText(String.valueOf(num1));
        Random2.setText(String.valueOf(num2));

        answer2.setText("");
        answer3.setText("");
        Random2_2.setText("");
        Random2_3.setText("");

        user_input.setText("");
        user_input2.setText("");
        input_user3.setText("");

        user_input.setEnabled(true);
        user_input2.setEnabled(true);
        input_user3.setEnabled(true);

        check_answer.setEnabled(true);
        check_answer2.setEnabled(true);
        check_answer3.setEnabled(true);
        new_button.setText("new");

        result_image.setVisibility(View.INVISIBLE);
        result_image2.setVisibility(View.INVISIBLE);
        result_image3.setVisibility(View.INVISIBLE);

        check_answer2.setVisibility(View.INVISIBLE);
        check_answer3.setVisibility(View.INVISIBLE);

        user_input2.setVisibility(View.INVISIBLE);
        input_user3.setVisibility(View.INVISIBLE);
        answer2.setVisibility(View.INVISIBLE);
        answer3.setVisibility(View.INVISIBLE);
        Random2_2.setVisibility(View.INVISIBLE);
        Random2_3.setVisibility(View.INVISIBLE);
    }

    public void ristart(View view) {
        restartGame();
    }
}
