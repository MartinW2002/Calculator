package me.martinwiesner.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private boolean isResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.text_result);
    }

    public void onClick(View view) {
        String text = ((Button) view).getText().toString();
        switch (text) {
            case "CA":
                result.setText("0");
                break;
            case "DEL":
                if (result.getText().equals("0"))
                    return;
                if (isResult) {
                    result.setText("0");
                    return;
                }
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
                if (isResult)
                    isResult = false;
                if (containsSign(result.getText().toString()))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "*":
                if (result.getText().equals("0"))
                    return;
                if (isResult)
                    isResult = false;
                if (containsSign(result.getText().toString()))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "-":
                if (result.getText().equals("0"))
                    return;
                if (isResult)
                    isResult = false;
                if (containsSign(result.getText().toString()))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "+":
                if (result.getText().equals("0"))
                    return;
                if (isResult)
                    isResult = false;
                if (containsSign(result.getText().toString()))
                    return;
                result.setText(result.getText().toString() + text);
                break;
            case "=":
                if (result.getText().equals("0"))
                    return;
                if (!containsSign(result.getText().toString()))
                    return;
                isResult = true;
                String calc = "" + calculate(result.getText().toString());
                if (calc.contains(".0")) {
                    String newCalc = "";
                    for (int i = 0, n = calc.length(); i < n; i++) {
                        if (i == n - 2)
                            break;
                        newCalc = newCalc + "" + calc.charAt(i);
                    }
                    result.setText(newCalc);
                    return;
                }
                result.setText(calc);
                break;
            default:
                try {
                    int number = Integer.parseInt(text);
                    if (result.getText().equals("0"))
                        result.setText(number + "");
                    else {
                        if (isResult) {
                            result.setText(number + "");
                            isResult = false;
                            return;
                        }
                        result.setText(result.getText().toString() + number);
                    }
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

    private double calculate(String text) {
        String firstPart = "";
        String secondPart = "";
        double calc = 0;
        boolean signFound = false;
        String sign = "";
        for (char c : text.toCharArray()) {
            if (c == '+') {
                sign = String.valueOf(c);
                signFound = true;
                continue;
            } else if (c == '*') {
                sign = String.valueOf(c);
                signFound = true;
                continue;
            } else if (c == '-') {
                sign = String.valueOf(c);
                signFound = true;
                continue;
            } else if (c == '/') {
                sign = String.valueOf(c);
                signFound = true;
                continue;
            }
            if (!signFound)
                firstPart += c;
            else
                secondPart += c;
        }
        double firstDouble = 0;
        double secondDouble = 0;
        try {
            firstDouble = Double.parseDouble(firstPart);
            secondDouble = Double.parseDouble(secondPart);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        switch (sign) {
            case "+":
                calc = firstDouble + secondDouble;
                break;
            case "-":
                calc = firstDouble - secondDouble;
                break;
            case "*":
                calc = firstDouble * secondDouble;
                break;
            case "/":
                calc = firstDouble / secondDouble;
                break;
            default:
                new Exception("Invalid text to calculate!");
                return 0;
        }
        return calc;
    }

}