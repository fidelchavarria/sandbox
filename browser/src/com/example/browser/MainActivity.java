package com.example.browser;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	EditText uRLText;
	Button goButton;
	WebView browser;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		uRLText = (EditText) findViewById(R.id.URL);
		goButton = (Button) findViewById(R.id.Go);
		browser = (WebView) findViewById(R.id.WebEngine);
		browser.setWebViewClient(new MyWebViewClient());
		
		goButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				browser.loadUrl("http://" + uRLText.getText().toString());
			}
		});
	}
	
	private class MyWebViewClient extends WebViewClient {

		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        view.loadUrl(url);
		        return true;
		    }

		    @Override
		    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
		        if ((event.getKeyCode() == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
		            view.goBack();
		            return true;
		        }

		        return super.shouldOverrideKeyEvent(view, event);
		    }
		}
}