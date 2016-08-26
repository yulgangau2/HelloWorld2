package com.example.kai.helloworld;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvhello, tvresult;
    EditText edit1, edit2, input1, input2;
    Button btncoppy;
    Button btncal;
    RadioButton rbplus, rbminus, rbmulti, rbdevide;
    RadioGroup rgoperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initinstances();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int width = size.x;
        int height = size.y;


        Toast.makeText(MainActivity.this,
                "Width = " + width + "Height = " + height ,
                Toast.LENGTH_LONG)
                .show();


    }


    //instance
    private void initinstances() {
        tvhello = (TextView) findViewById(R.id.tvhello);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        btncoppy = (Button) findViewById(R.id.btncoppy);
        input1 = (EditText) findViewById(R.id.editinput1);
        input2 = (EditText) findViewById(R.id.editinput2);
        tvresult = (TextView) findViewById(R.id.tvresult);
        btncal = (Button) findViewById(R.id.btncal);
        rbplus = (RadioButton) findViewById(R.id.rbplus);
        rbminus = (RadioButton) findViewById(R.id.rbminus);
        rbmulti = (RadioButton) findViewById(R.id.rbmulti);
        rbdevide = (RadioButton) findViewById(R.id.rbdevide);
        rgoperator = (RadioGroup) findViewById(R.id.rgoperator);

        edit2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    tvhello.setText(edit2.getText());

                    return true;
                }
                return false;
            }

        });

        btncoppy.setOnClickListener(this);
        btncal.setOnClickListener(this);
    }//end instance

    @Override
    public void onClick(View view) {
        if (view == btncoppy) {
            tvhello.setText(edit2.getText() + " " + edit1.getText());
        } else if (view == btncal) {
            int val1 = 0, val2 = 0, sum = 0;
            try {
                val1 = Integer.parseInt(input1.getText().toString());
            } catch (NumberFormatException e) {
            }
            try {
                val2 = Integer.parseInt(input2.getText().toString());
            } catch (NumberFormatException e) {
            }

            switch (rgoperator.getCheckedRadioButtonId()) {
                case R.id.rbplus: {
                    sum = val1 + val2;
                    break;
                }
                case R.id.rbminus: {
                    sum = val1 - val2;
                    break;
                }
                case R.id.rbmulti: {
                    sum = val1 * val2;
                    break;
                }
                case R.id.rbdevide: {
                    sum = val1 / val2;
                    break;
                }

            }


            tvresult.setText(" " + sum);

            dubug (sum);


        }

    }

    private void dubug(int sum) {
        Log.d("calculation+" , "Result is " + sum);

        Toast.makeText(MainActivity.this,
                "Result is " + sum,
                Toast.LENGTH_SHORT)
                .show();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_setting ) {
            Toast.makeText(MainActivity.this,
                    "This is Setting",
                    Toast.LENGTH_LONG)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
