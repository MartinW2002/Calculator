package me.martinwiesner.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.text_result);
    }

    public void onClick(View view) {
        String text = ((Button) view).getText().toString();
        switch (text) {
            case "DEL":
                if (result.getText().equals("0"))
                    return;

                break;
            case "/":
                if (result.getText().equals("0"))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "*":
                if (result.getText().equals("0"))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "-":
                if (result.getText().equals("0"))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "+":
                if (result.getText().equals("0"))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "=":
                if (result.getText().equals("0"))
                    return;

                break;
            default:
                try {
                    if (result.getText().equals("0"))
                        return;
                    int number = Integer.parseInt(text);
                    result.setText(result.getText().toString() + number);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
        }
    }

}
