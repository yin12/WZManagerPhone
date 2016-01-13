package icss.wz.manager.ui.query;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import icss.wz.manager.R;
import icss.wz.manager.dialog.DatePickDialog;
import icss.wz.manager.ui.base.BaseActivity;

/**
 * Created by Administrator on 2015/12/22.
 * <p/>
 * 卷烟跟踪
 */
public class QueryJYGZActivity extends BaseActivity
        implements View.OnClickListener {
    private static final String TAG = "QueryJYGZActivity";

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.list)
    RecyclerView mRecyclerView;
    @Bind(R.id.srl_list)
    SwipeRefreshLayout mRefresh;
    @Bind(R.id.choice_date)
    TextView choiceDate;

    @Override
    protected int getContentView() {
        return R.layout.activity_jygz_query;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        /**设置返回键可用*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /**返回事件*/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryJYGZActivity.this.finish();
            }
        });

        initRefresh();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerDecoration(this));
        mRecyclerView.setHasFixedSize(true);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        choiceDate.setText("日期选择 " + date);
        choiceDate.setOnClickListener(this);
    }

    /**
     * 更新数据
     */
    private void initRefresh() {
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新，更新数据
                loadData();
            }
        });
        mRefresh.setColorSchemeColors(
                getResources().getColor(R.color.orange),
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green)
        );
    }

    @Override
    public void onClick(View v) {
        //显示 时间格式为 yyyy-MM
        DatePickDialog pickDialog = new DatePickDialog(this, 1);
        pickDialog.show();
    }
}
