package ro.pub.systems.eim.lab03.phonedialeractivity.graphicuserinterface;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import ro.pub.systems.eim.lab03.phonedialeractivity.R;
import ro.pub.systems.eim.lab03.phonedialeractivity.general.Constants;

public class PhoneDialerActivity extends AppCompatActivity {

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private CallImageButtonClickListener callListener = new CallImageButtonClickListener();
    private HangupImageButtonClickListener hangupListener = new HangupImageButtonClickListener();
    private BackspaceImageButtonClickListener backspaceListener = new BackspaceImageButtonClickListener();

    private class BackspaceImageButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText phoneDialerText = findViewById(R.id.phone_number);
            String phoneNumber = phoneDialerText.getText().toString();

            if (phoneNumber.length() > 0) {
                String newPhoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
                phoneDialerText.setText(newPhoneNumber);
            }
        }
    }

    private class CallImageButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(ro.pub.systems.eim.lab03.phonedialeractivity.graphicuserinterface.PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        ro.pub.systems.eim.lab03.phonedialeractivity.graphicuserinterface.PhoneDialerActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        Constants.PERMISSION_REQUEST_CALL_PHONE);
            } else {
                EditText phoneDialerText = findViewById(R.id.phone_number);
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneDialerText.getText().toString()));
                startActivity(intent);
            }
        }
    }

    private class HangupImageButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }
    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            // tastează numărul de telefon
            EditText phoneDialerText = findViewById(R.id.phone_number);
            String input = ((Button) view).getText().toString();
            String newPhoneNumber = phoneDialerText.getText().toString() + input;
            phoneDialerText.setText(newPhoneNumber);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        if (display.getWidth() <= display.getHeight()) {
            // create graphic user interface for portrait mode
            setContentView(R.layout.activity_phone_dialer_portret);
        }
        else {
            setContentView(R.layout.activity_phone_dialer);
            // create graphic user interface for landscape mode
        }

        Button star = (Button) findViewById(R.id.star);
        star.setOnClickListener(buttonClickListener);
        Button sign = (Button) findViewById(R.id.sign);
        sign.setOnClickListener(buttonClickListener);
        Button number1 = (Button) findViewById(R.id.number_1);
        number1.setOnClickListener(buttonClickListener);
        Button number2 = (Button) findViewById(R.id.number_2);
        number2.setOnClickListener(buttonClickListener);
        Button number3 = (Button) findViewById(R.id.number_3);
        number3.setOnClickListener(buttonClickListener);
        Button number4 = (Button) findViewById(R.id.number_4);
        number4.setOnClickListener(buttonClickListener);
        Button number5 = (Button) findViewById(R.id.number_5);
        number5.setOnClickListener(buttonClickListener);
        Button number6 = (Button) findViewById(R.id.number_6);
        number6.setOnClickListener(buttonClickListener);
        Button number7 = (Button) findViewById(R.id.number_7);
        number7.setOnClickListener(buttonClickListener);
        Button number8 = (Button) findViewById(R.id.number_8);
        number8.setOnClickListener(buttonClickListener);
        Button number9 = (Button) findViewById(R.id.number_9);
        number9.setOnClickListener(buttonClickListener);
        Button number0 = (Button) findViewById(R.id.number_0);
        number0.setOnClickListener(buttonClickListener);
        ImageButton call = (ImageButton) findViewById(R.id.call);
        call.setOnClickListener(callListener);
        ImageButton hangup = (ImageButton) findViewById(R.id.hangup);
        hangup.setOnClickListener(hangupListener);
        ImageButton backspace = (ImageButton) findViewById(R.id.backspace);
        backspace.setOnClickListener(backspaceListener);

    }
}
