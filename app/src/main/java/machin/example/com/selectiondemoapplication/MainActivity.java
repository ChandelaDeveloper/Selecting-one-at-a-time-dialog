package machin.example.com.selectiondemoapplication;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.Arrays;

import machin.example.com.easyselection.SelectionBuilder;
import machin.example.com.easyselection.SelectionDialog;
import machin.example.com.easyselection.SelectionListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new SelectionBuilder(this)
                .setTitle("Hello Please select somthing")
                .setList(Arrays.asList(getResources().getStringArray(R.array.classes)))
                .setFont(null)
                .setTitleColor(ContextCompat.getColor(this, R.color.orange))
                .setDataTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                .setCancelable(false)
                .setDataBold(true)
                .setCallBackListener(new SelectionListener() {
                    @Override
                    public void onClick(SelectionDialog dialog, int position) {
                        Toast.makeText(MainActivity.this, getResources().getStringArray(R.array.classes)[position], Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).build().show();
    }
}
