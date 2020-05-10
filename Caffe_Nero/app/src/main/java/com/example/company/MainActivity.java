package vistula.NihatAllahverdiyev.company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.myfirstapp.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.myfirstapp.MESSAGE4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    static String descItem = "";
    static int priceItem = 0;

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayDetails46219.class);

        EditText name_text = (EditText) findViewById(R.id.editText);
        EditText surname_text = (EditText) findViewById(R.id.editText2);


        String descItem2 = descItem;
        // static String name = "";
        //String surname = "";
        String price = "";

        String name = name_text.getText().toString();
        String surname = surname_text.getText().toString();

        price = String.valueOf(priceItem);
        intent.putExtra(EXTRA_MESSAGE, name);
        intent.putExtra(EXTRA_MESSAGE2, surname);
        intent.putExtra(EXTRA_MESSAGE3, price);
        intent.putExtra(EXTRA_MESSAGE4, descItem2);

        startActivity(intent);
    }

    public void calculate(View onCreate) {
        EditText name_text = (EditText) findViewById(R.id.editText);
        EditText surname_text = (EditText) findViewById(R.id.editText2);

        Spinner itemSpinner = (Spinner) findViewById(R.id.spinner);
        Spinner amountSpinner = (Spinner) findViewById(R.id.spinner2);

        Button calculateButton = (Button) findViewById(R.id.button);
        Button checkoutButton = (Button) findViewById(R.id.button2);

        TextView descriptionItems = (TextView) findViewById(R.id.textView3);
        TextView amountTextView = (TextView) findViewById(R.id.textView5);

        String item = itemSpinner.getSelectedItem().toString();
        priceItem += getPrice(item) * Integer.valueOf(amountSpinner.getSelectedItem().toString());

        amountTextView.setText(String.valueOf(priceItem));

        if (descItem.equals(""))
            descItem = getItem(item);
        else {
            descItem += " ";
            descItem += getItem(item);
        }

        descriptionItems.setText(descItem);

    }

    public int getPrice(String item) {

        int loc_of = 0;

        for (int i = 0; i < item.length(); i++)
            if (item.charAt(i) == '-') {
                loc_of = i;
                break;
            }
        String itemCopy = item.substring(loc_of + 2, item.length() - 1);

        return Integer.valueOf(itemCopy);
    }

    public String getItem(String item) {

        int loc_of = 0;

        for (int i = 0; i < item.length(); i++)
            if (item.charAt(i) == '-') {
                loc_of = i;
                break;
            }

        return item.substring(0, loc_of - 1);
    }
}