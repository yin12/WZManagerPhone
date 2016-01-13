package icss.wz.manager.ui.record;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import icss.wz.manager.R;
import icss.wz.manager.adapter.GZZJAdapter;
import icss.wz.manager.bean.GZZJInfo;
import icss.wz.manager.ui.base.BaseActivity;
import icss.wz.manager.util.ToastUtils;
import icss.wz.manager.view.MyListView;

/**
 * Created by Administrator on 2015/12/25.
 * <p/>
 * 工作总结
 */
public class RecordGZZJActivity extends BaseActivity
        implements View.OnTouchListener {
    private static final String TAG = "RecordGZZJActivity";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.submit_date)
    TextView mDate;//提交日期
    @Bind(R.id.client_name)
    TextView clientName;//客户名
    @Bind(R.id.scroll_view)
    ScrollView mScrollView;
    @Bind(R.id.my_list_view)
    MyListView myListView;
    /*拜访情况和问题总结的内容*/
    @Bind(R.id.situation_add_problem)
    EditText submitText;

    private GZZJInfo info;
    private List<GZZJInfo> list;
    private GZZJAdapter mAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_gzzj_record;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 1; i < 42; i++) {
            info = new GZZJInfo();
            if (i < 24) {
                info.setScheduleType(1);
            } else {
                info.setScheduleType(0);
            }
            info.setClientId("" + i);
            info.setClientName("客户A");
            info.setCheckInTime("09:45:38");
            info.setSignBackTime("09:56:45");
            list.add(info);
        }
    }

    @Override
    protected void initView() {
        /**获取系统时间*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String submitTime = format.format(new Date());

        clientName.setText("客户A");
        mDate.setText(submitTime);

        setSupportActionBar(toolbar);
        /**设置返回键可用*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /**返回事件*/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecordGZZJActivity.this.finish();
            }
        });
        /**
         * 提交总结MenuItem事件
         */
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ab_submit://提交
                        ToastUtils.showToast(RecordGZZJActivity.this, "提交");
                        break;
                }
                return true;
            }
        });

        mAdapter = new GZZJAdapter(this, list);
        myListView.setAdapter(mAdapter);

        /**解决ScrollView下镶嵌ListView进入页面不是在顶部的问题 */
        mScrollView.smoothScrollTo(0, 0);
        /**解决EditText在ScrollView里面的焦点冲突问题*/
        submitText.setOnTouchListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_submit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        /**EditText在ScrollView里面焦点冲突解决*/
        if (view.getId() == R.id.situation_add_problem) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_UP:
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                    break;
            }
        }
        return false;
    }
}
