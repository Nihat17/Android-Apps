package vistula.an.allahverdiyev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2";

    Spinner spinner_min;
    Spinner spinner_max;
    Spinner spinner_diff;
    EditText nameEdit;
    EditText surnameEdit;
    static int min, max, diff;
    int n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_min = (Spinner) findViewById(R.id.spinner_min);
        spinner_max = (Spinner) findViewById(R.id.spinner_max);
        spinner_diff = (Spinner) findViewById(R.id.spinner_diff);
        nameEdit = (EditText) findViewById(R.id.editText_name);
        surnameEdit = (EditText) findViewById(R.id.editText_surname);
        min = Integer.valueOf(spinner_min.getSelectedItem().toString());
        max = Integer.valueOf(spinner_max.getSelectedItem().toString());
        diff = Integer.valueOf(spinner_diff.getSelectedItem().toString());
    }


    public void game(View view){

        Random rand = new Random();

        TextView n1Text = (TextView) findViewById(R.id.textView_N1);
        TextView n2Text = (TextView) findViewById(R.id.textView_N2);

        spinner_min = (Spinner) findViewById(R.id.spinner_min);
        spinner_max = (Spinner) findViewById(R.id.spinner_max);
        spinner_diff = (Spinner) findViewById(R.id.spinner_diff);

        min = Integer.valueOf(spinner_min.getSelectedItem().toString());
        max = Integer.valueOf(spinner_max.getSelectedItem().toString());
        diff = Integer.valueOf(spinner_diff.getSelectedItem().toString());

        n1 = rand.nextInt(max + 1 - min) + min;
        n2 = rand.nextInt(max + 1 - min) + min;

        n1Text.setText(String.valueOf(n1));
        n2Text.setText(String.valueOf(n2));


        //Intent find_contact = new Intent(this, Find_Contact.class);
        //Intent find_address = new Intent(this, Find_Address.class);

    }

    public void go(View view){
        Intent find_contact = new Intent(this, Find_Contact.class);
        Intent find_address = new Intent(this, Find_Address.class);

        int diff2 = (n1 > n2) ? n1 - n2 : n2 - n1;
        if(diff2 == diff){
            find_address.putExtra(EXTRA_MESSAGE, nameEdit.getText().toString());
            find_address.putExtra(EXTRA_MESSAGE2, surnameEdit.getText().toString());
            startActivity(find_address);
        }


    }
}
