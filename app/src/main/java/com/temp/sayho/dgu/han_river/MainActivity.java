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
                "https://www.google.co.kr/#newwindow=1&q=%EC%84%9C%EC%9A%B8+%EC%98%A8%EB%8F%84"
                , "div", new SFCallback() {
            @Override
            public void callback() {
                runOnUiThread (new Thread(new Runnable() {
                    public void run() {
                        _textview.setText(parser.getResult());
                    }
                }));

            }
        });
    }
}
