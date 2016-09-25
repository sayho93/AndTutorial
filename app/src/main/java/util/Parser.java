package util;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by 전세호 on 2016-09-21.
 */
public class Parser {
    private String URL, Selector, result;
    private SFCallback callback;
    public Parser(String URL, String selector, SFCallback callback){
        this.URL = URL;
        this.Selector = selector;
        this.result = "";
        thread.start();
        this.callback = callback;
    }
    public void setResult_b() { result="분당 날씨 -" + result; }
    public String getResult(){
        return result;
    }

    Thread thread = new Thread(){
        @Override
        public void run(){
            try{
                Document doc = Jsoup.connect(URL).followRedirects(true).get();
                Elements titles = doc.select(Selector);
                Log.e("seq", result);
                for(Element elem : titles) {
                    Log.e("sef", result);
                    result += elem.text() + "";
                }
            }
            catch(Exception e){e.printStackTrace();}
            callback.callback();
        }
    };

}
