package com.example.next.androidtojsconversion;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button button;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
button= (Button) findViewById(R.id.click);
         webView = (WebView) findViewById(R.id.web_view);


        webView = (WebView) findViewById(R.id.web_view);

        webView.loadUrl("file:///android_asset/web.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebViewJavaScriptInterface(this),"app" );
        webView.setWebChromeClient(new WebChromeClient());
        webView.setBackgroundColor(Color.CYAN);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss="message.........";
                webView.loadUrl("javascript:callfromAndroid('"+ss+"')");
            }
        });

    }


    public  class WebViewJavaScriptInterface{

       private Context context;


        public WebViewJavaScriptInterface(Context context) {
            this.context = context;
        }

        @JavascriptInterface
        public  void makeToast(String message , boolean lengthlong)
        {


            Toast.makeText(context, message, (lengthlong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT)).show();

        }
    }



}
