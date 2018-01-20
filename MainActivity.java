package com.example.shivendra.tempconv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText Evalue;
    private Button Cbutt;
    private Button Fbutt;
    private TextView Result;

    DecimalFormat roundoff = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Evalue = findViewById(R.id.valueText);
        Cbutt = findViewById(R.id.Cbutton);
        Fbutt = findViewById(R.id.Fbutton);
        Result = findViewById(R.id.resulttext);



        Cbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = Evalue.getText().toString();
                if(temp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }
                else {
                   double tempint = Double.parseDouble(temp);
                   double ansf= convertc(tempint);
                    String answerf = String.valueOf(roundoff.format(ansf));

                    Result.setText(answerf + " F");
                }

            }

        });


        Fbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = Evalue.getText().toString();
                if(temp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }
                else {
                   double tempint = Double.parseDouble(temp);
                   double ansc =convertf(tempint);
                    String answerc = String.valueOf(roundoff.format(ansc));

                    Result.setText(answerc + " C");
                }

            }
        });



    }

    public double convertc(double f){

        double resultc=(f-32)*5/9;

        return resultc ;
    }

    public double convertf(double c){

        double resultf =(c * 9/5) + 32;

        return resultf ;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
