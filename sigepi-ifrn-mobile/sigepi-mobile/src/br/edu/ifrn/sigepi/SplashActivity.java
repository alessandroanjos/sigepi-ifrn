package br.edu.ifrn.sigepi;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class SplashActivity extends Activity {
	
	private Thread mSplashThread;
	private boolean mblnClicou = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		PackageManager manager = this.getPackageManager();
		try {
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			String versionNumber = info.versionName;
			TextView textView = (TextView) findViewById(R.id.versao_text_view);
		    textView.setText("v. " + versionNumber);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		mSplashThread = new Thread() {
			@Override
			public void run() {
				try {
					synchronized (this) {
						wait(5000);
						mblnClicou = true;
					}
				} catch (InterruptedException ex) {
				}

				if (mblnClicou) {
					finish();

					Intent i = new Intent();
					i.setClass(SplashActivity.this, MenuPrincipalActivity.class);
					startActivity(i);
				}
			}
		};

		mSplashThread.start();
	}

	@Override
	public void onPause() {
		super.onPause();
		mSplashThread.interrupt();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			synchronized (mSplashThread) {
				mblnClicou = true;
				mSplashThread.notifyAll();
			}
		}
		return true;
	}

}
