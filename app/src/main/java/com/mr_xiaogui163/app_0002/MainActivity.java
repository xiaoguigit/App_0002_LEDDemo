package com.mr_xiaogui163.app_0002;

import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.mr_xiaogui163.hardlibrary.*;


public class MainActivity extends AppCompatActivity {

    private Boolean AllLedOn = false;
    private Button button = null;
    private CheckBox checkBoxLed1 = null;
    private CheckBox checkBoxLed2 = null;
    private CheckBox checkBoxLed3 = null;
    private CheckBox checkBoxLed4 = null;

    public void onCheckBoxClicked(View view){
        Boolean checked  = ((CheckBox)view).isChecked();

        switch(view.getId()){
            case R.id.LED1:
                if(checked){
                    Toast.makeText(getApplicationContext(), "LED1 ON", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 1);
                }else{
                    Toast.makeText(getApplicationContext(), "LED1 OFF", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 0);
                }
                break;

            case R.id.LED2:
                if(checked){
                    Toast.makeText(getApplicationContext(), "LED2 ON", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 1);
                }else{
                    Toast.makeText(getApplicationContext(), "LED2 OFF", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 0);
                }
                break;

            case R.id.LED3:
                if(checked){
                    Toast.makeText(getApplicationContext(), "LED31 ON",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 1);
                }else{
                    Toast.makeText(getApplicationContext(), "LED3 OFF",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 0);
                }
                break;

            case R.id.LED4:
                if(checked){
                    Toast.makeText(getApplicationContext(), "LED4 ON",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 1);
                }else{
                    Toast.makeText(getApplicationContext(), "LED4 OFF",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 0);
                }
                break;
        }
    }

    class MyButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            AllLedOn = !AllLedOn;
            if(AllLedOn){
                button.setText("ALL LED OFF");
                checkBoxLed1.setChecked(true);
                checkBoxLed2.setChecked(true);
                checkBoxLed3.setChecked(true);
                checkBoxLed4.setChecked(true);

                for (int i = 0; i < 4; i++)
                    HardControl.ledCtrl(i,1);
            }else {
                button.setText("ALL LED ON");
                checkBoxLed1.setChecked(false);
                checkBoxLed2.setChecked(false);
                checkBoxLed3.setChecked(false);
                checkBoxLed4.setChecked(false);
                for (int i = 0; i < 4; i++)
                    HardControl.ledCtrl(i,0);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HardControl.ledOpen();
        button = (Button) findViewById(R.id.BUTTON);
        checkBoxLed1 = (CheckBox) findViewById(R.id.LED1);
        checkBoxLed2 = (CheckBox) findViewById(R.id.LED2);
        checkBoxLed3 = (CheckBox) findViewById(R.id.LED3);
        checkBoxLed4 = (CheckBox) findViewById(R.id.LED4);

        button.setOnClickListener(new MyButtonListener());
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllLedOn = !AllLedOn;
                if(AllLedOn){
                    button.setText("ALL LED OFF");
                }else {
                    button.setText("ALL LED ON");
                }
            }
        });
        */
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
