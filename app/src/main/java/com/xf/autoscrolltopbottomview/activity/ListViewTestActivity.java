package com.xf.autoscrolltopbottomview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.xf.autoscrolltopbottomview.R;
import com.xf.autoscrolltopbottomview.widget.AutoScrollTopBottomView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewTestActivity extends AppCompatActivity {

    private AutoScrollTopBottomView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initView();
        ListView listView = (ListView) findViewById(R.id.list_view);
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("test", "topView" + i);
            list.add(map);
        }
        listView.setAdapter(new SimpleAdapter(this, list, R.layout.test_item, new String[]{"test"}, new int[]{R.id.test}));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                test.autoMove();

            }
        });
    }

    private void initView() {
        test = (AutoScrollTopBottomView) findViewById(R.id.test);
    }
}
