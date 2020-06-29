package com.example.autocomplete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private static final String[] CONTRIES=new String[]{

   "Afganistan" ,"Albania" , "Algria"  ,"Andoria"  ,"Angola"

  };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[]contries=getResources().getStringArray(R.array.contries);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,contries);

        Button dialog=(Button) findViewById(R.id.btn);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog .Builder mbuilder=new AlertDialog.Builder(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.auto, null);
                AutoCompleteTextView mtext=(AutoCompleteTextView) view.findViewById(R.id.actv);
                mtext.setAdapter(adapter);

                mbuilder.setView(view);
                AlertDialog dialog=mbuilder.create();
                dialog.show();
            }
        });

    }
}