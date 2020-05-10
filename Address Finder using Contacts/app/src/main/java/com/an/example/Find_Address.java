package vistula.an.allahverdiyev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Find_Address extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find__address);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String surname = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);

        TextView nameText = (TextView) findViewById(R.id.textView_name);
        TextView surnameText = (TextView) findViewById(R.id.textView_surname);

        nameText.setText(name);
        surnameText.setText(surname);

    }

    public void map(View view){

        Spinner spinner_city = (Spinner) findViewById(R.id.spinner_town);
        String town = spinner_city.getSelectedItem().toString();

        EditText editText_street = (EditText) findViewById(R.id.editText_street);
        String street = editText_street.getText().toString();

        Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q=" + town + "+" + street));
        startActivity(geoIntent);
    }
}
