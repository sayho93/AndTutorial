package com.temp.sayho.dgu.han_river;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import util.Parser;
import util.SFCallback;

public class MainActivity extends AppCompatActivity {

    private TextView _textview;
    private Parser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _textview = (TextView)findViewById(R.id.tempText);


        parser = new Parser(
                "https://m.search.naver.com/search.naver?query=%EB%B6%84%EB%8B%B9+%EB%82%A0%EC%94%A8&where=m&sm=mtp_hty"
                , "p[class=main_temp f_light]", new SFCallback() {
            @Override
            public void callback() {
                runOnUiThread (new Thread(new Runnable() {
                    public void run() {
                        parser.setResult_b();
                        _textview.setText(parser.getResult());
                    }
                }));

            }
        });
    }
}
