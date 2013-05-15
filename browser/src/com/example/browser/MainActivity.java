package com.example.browser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	EditText URLText;
	Button GoButton;
	WebView Browser;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		URLText = (EditText) findViewById(R.id.URL);
		GoButton = (Button) findViewById(R.id.Go);
		Browser = (WebView) findViewById(R.id.WebEngine);

		GoButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Browser.loadUrl("http://" + URLText.getText().toString());
			}
		});
	}
	
//	private class MyWebViewClient extends WebViewClient {
//		@Override
//		public boolean shouldOverrideUrlLoading(WebView view, String url) {
//			view.loadUrl(url);
//			return true;
//		}
//	}
}