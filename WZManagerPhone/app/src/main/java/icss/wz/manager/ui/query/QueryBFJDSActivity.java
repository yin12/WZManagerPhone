package icss.wz.manager.ui.query;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import icss.wz.manager.R;
import icss.wz.manager.adapter.BFJDSAdapter;
import icss.wz.manager.bean.BFJDSInfo;
import icss.wz.manager.ui.base.BaseActivity;

/**
 * Created by Administrator on 2015/12/22.
 */
public class QueryBFJDSActivity extends BaseActivity {
    private static final String TAG = "QueryBFJDSActivity";

    @Bind(R.id.list)
    RecyclerView mRecyclerView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.srl_list)
    SwipeRefreshLayout mRefresh;

    private BFJDSAdapter mAdapter;
    private List<BFJDSInfo> list;
    private BFJDSInfo secondInfo;

    @Override
    protected int getContentView() {
        return R.layout.activity_second_test;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            secondInfo = new BFJDSInfo();
            secondInfo.setScheduleName("客户A(000011*)");
            secondInfo.setScheduleData("2015-12-22");
            secondInfo.setScheduleCode("AHWZH");
            secondInfo.setScheduleAddress("梧州市**************");
            list.add(secondInfo);
        }
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        /**设置返回键可用*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //返回事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryBFJDSActivity.this.finish();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerDecoration(mContext));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new BFJDSAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setOnItemClickListener(this);

        initRefresh();
    }

    /**
     * 更新数据
     */
    private void initRefresh() {
        mRefresh.setColorSchemeColors(
                getResources().getColor(R.color.orange),
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green));
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新,更新数据
                loadData();
            }
        });
    }
}
