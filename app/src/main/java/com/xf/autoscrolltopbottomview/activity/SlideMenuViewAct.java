package com.xf.autoscrolltopbottomview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xf.autoscrolltopbottomview.R;

/**
 * User: 吕勇
 * Date: 2016-07-24
 * Time: 07:17
 * Description:
 */
public class SlideMenuViewAct extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      /*  if(Build.VERSION.SDK_INT >= 21){
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_slide_menu_view_test);
    }
/*    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
    }*/
}
