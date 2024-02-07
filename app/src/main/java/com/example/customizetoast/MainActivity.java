package com.example.customizetoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast=findViewById(R.id.btnToast);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //default toast
                //Toast.makeText(this, "This is my Toast ", Toast.LENGTH_LONG).show();

                //customize toast


                //1.) getting view
                Toast toast=new Toast(getApplicationContext());

                //the below require view but we have layout so to convert layout to view we require layout inflator

                View view=getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.viewContainer));

                toast.setView(view);

                //2.) setting text
                TextView txtMsg=view.findViewById(R.id.txtMsg);

                txtMsg.setText("Message sent Successfully !");

                //3.) setting duration
                toast.setDuration(Toast.LENGTH_LONG);

                toast.setGravity(Gravity.TOP|Gravity.END,0,0);
                // we can use END instead of right as in new version left=start and right is end
                toast.show();
            }
        });

    }


}