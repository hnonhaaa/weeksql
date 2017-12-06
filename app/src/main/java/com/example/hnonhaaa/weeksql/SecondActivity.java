package com.example.hnonhaaa.weeksql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final EditText edt = (EditText) findViewById(R.id.editText02);
        Button btOK = (Button) findViewById(R.id.button02);



        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edt.getText().toString() ;
                Intent inT =  new Intent() ;
                inT.putExtra("result" , data) ; //set value in intent
                setResult(RESULT_OK,inT);   //for set result to page one
                finish();
            }
        });

        Button btCancle = (Button)findViewById(R.id.button002);
        btCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
