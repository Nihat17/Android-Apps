package vistula.NihatAllahverdiyev.company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayDetails46219 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details46219);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String surname = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        String price = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String desc = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);

        TextView name_view = (TextView) findViewById(R.id.textView6);
        TextView surname_view = (TextView) findViewById(R.id.textView10);

        TextView price_view = (TextView) findViewById(R.id.textView14);
        TextView desc_view = (TextView) findViewById(R.id.textView12);


        surname_view.setText(surname);
        name_view.setText(name);
        price_view.setText(price);
        desc_view.setText(desc);

    }
}
