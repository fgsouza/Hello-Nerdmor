package com.nerdmor.helloworld;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean cursorVisible = true;
    private TextView prompt;

    private final Runnable blink = new Runnable() {
        @Override
        public void run() {
            cursorVisible = !cursorVisible;
            prompt.setText(getString(R.string.prompt) + (cursorVisible ? "_" : " "));
            handler.postDelayed(this, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prompt = findViewById(R.id.prompt);

        Button visit = findViewById(R.id.visit_button);
        visit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.site_url)));
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException ignored) {
                // No browser installed: nothing to do.
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.post(blink);
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(blink);
        super.onPause();
    }
}
