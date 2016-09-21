package com.temp.sayho.dgu.han_river;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.ImageView;

public class IntroActivity extends AppCompatActivity {

    private Handler h;
    private int delayTime = 1200;
    private ImageView iv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        iv = (ImageView)findViewById(R.id.imageView);
        iv.setDrawingCacheEnabled(true);

        h = new Handler();
        h.postDelayed(intro, delayTime);
    }

    Runnable intro = new Runnable() {
        public void run() {
            Intent i = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(i);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        h.removeCallbacks(intro);
    }
}

