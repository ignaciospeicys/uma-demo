package com.gometro.umademo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gometro.umademo.enums.UmaStatusEnum;
import com.gometroapp.uma.GoMetroUma;

public class MainActivity extends AppCompatActivity {

    private boolean umaInit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateStatusTextView(UmaStatusEnum.PAUSED);
    }

    /**
     * Starts the GoMetroUma service
     * Once pressed, swaps the button with another that stops all activity
     */
    public void startUmaService(View view) {

        if (umaInit) {
            //force closes the app and all background processes, only meant for testing purposes!
            System.exit(0);
        }

        GoMetroUma.initialise(
                this,
                getString(R.string.client_id),
                getString(R.string.client_secret));

        updateStatusTextView(UmaStatusEnum.RUNNING);
        Toast.makeText(this, R.string.uma_start_toast, Toast.LENGTH_LONG).show();
        updateMainButton((Button) view);
    }

    private void updateStatusTextView(UmaStatusEnum umaStatus) {
        TextView umaStatusTextView = findViewById(R.id.umaStatusTextView);
        String statusText = getString(umaStatus.getTextId());
        String originalText = getString(R.string.uma_status_text_view, statusText);
        umaStatusTextView.setText(originalText);
    }

    private void updateMainButton(Button button) {
        button.setText(getString(R.string.exit_app));
        umaInit = true;
    }
}