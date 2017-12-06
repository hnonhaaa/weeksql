package com.example.hnonhaaa.weeksql;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView vtextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button vbutton = (Button)findViewById(R.id.button) ;
        vtextView = (TextView)findViewById(R.id.textView) ;
        vbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPageTwo = new Intent(MainActivity.this , SecondActivity.class) ;
                startActivityForResult(toPageTwo,9712);
            }
        });

        Button vCall= (Button)findViewById(R.id.phone_call_button) ;
        vCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent innt = new Intent(Intent.ACTION_DIAL) ;
                //Intent innt = new Intent(Intent.ACTION_CALL) ; ต้องไปขอใน manifasts <uses-permission android:name="android.permission.CALL_PHONE"/>

                innt.setData(Uri.parse("tel:12345")) ; // สั่งโทรไปที่เบอร์ 12345
                startActivity(innt);    // สั้งมันเริ่มงาน
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 9712){
            if(resultCode == RESULT_OK){
                String box = data.getStringExtra("result");
                vtextView.setText(box);
            }
            else if(resultCode == RESULT_CANCELED){
                Toast.makeText(
                        MainActivity.this ,"ีuser dont push button OK", Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}
