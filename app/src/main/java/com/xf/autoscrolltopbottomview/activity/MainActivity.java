package com.xf.autoscrolltopbottomview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xf.autoscrolltopbottomview.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
     /*   if(Build.VERSION.SDK_INT >= 21){
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.scrollview_test).setOnClickListener(this);
        findViewById(R.id.listview_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.scrollview_test:
                intent.setClass(MainActivity.this,ScrollViewTestActivity.class);
                startActivity(intent);
                break;
            case R.id.listview_test:
                intent.setClass(MainActivity.this,ListViewTestActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

   /* @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
    }*/
    public void SlideMenuView_test(View view) {
        Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle();
        startActivity(new Intent(this,SlideMenuViewAct.class));
    }
}
