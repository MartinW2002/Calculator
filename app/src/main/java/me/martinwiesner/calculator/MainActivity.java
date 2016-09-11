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
                CharSequence charSequence = result.getText();
                CharSequence newCS = "";
                for (int i = 0, n = charSequence.length(); i < n; i++) {
                    if (i == n - 1)
                        break;
                    newCS = newCS + "" + charSequence.charAt(i);
                }
                if (newCS == "")
                    newCS = "0";
                result.setText(newCS);
                break;
            case "/":
                if (result.getText().equals("0"))
                    return;
                if (containsSign(text))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "*":
                if (result.getText().equals("0"))
                    return;
                if (containsSign(text))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "-":
                if (result.getText().equals("0"))
                    return;
                if (containsSign(text))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "+":
                if (result.getText().equals("0"))
                    return;
                if (containsSign(text))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "=":
                if (result.getText().equals("0"))
                    return;
                if (!containsSign(text))
                    return;

                break;
            default:
                try {
                    int number = Integer.parseInt(text);
                    if (result.getText().equals("0"))
                        result.setText(number + "");
                    else
                        result.setText(result.getText().toString() + number);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
        }
    }

    private boolean containsSign(String text) {
        for (char c : text.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/')
                return true;
        }
        return false;
    }

}
