package com.example.dongja94.samplecustomchoicelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new MyAdapter();
        listView.setAdapter(mAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        initData();

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (isLast && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    getMoreData();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (totalItemCount > 0 && firstVisibleItem + visibleItemCount >= totalItemCount - 1) {
                    isLast = true;
                } else {
                    isLast = false;
                }
            }
        });
    }

    private void getMoreData() {
        int start = mAdapter.getCount();
        for (int i = 0 ; i < 20; i++) {
            mAdapter.add("item " + (start + i));
        }
    }

    boolean isLast = false;

    private void initData() {
        for (int i = 0; i < 40; i++) {
            mAdapter.add("item " + i);
        }
    }
}
