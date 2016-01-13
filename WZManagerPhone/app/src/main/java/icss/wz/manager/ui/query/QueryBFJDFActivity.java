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
import icss.wz.manager.adapter.BFJDFAdapter;
import icss.wz.manager.bean.BFJDFInfo;
import icss.wz.manager.ui.base.BaseActivity;

/**
 * Created by Administrator on 2015/12/22.
 * <p/>
 * 拜访进度
 */
public class QueryBFJDFActivity extends BaseActivity {
    private static final String TAG = "QueryBFJDFActivity";

    @Bind(R.id.list)
    RecyclerView mRecyclerView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.srl_list)
    SwipeRefreshLayout mRefresh;

    private BFJDFInfo bfjdfInfo;
    private List<BFJDFInfo> list;
    private BFJDFAdapter mAdapter;


    @Override
    protected int getContentView() {
        return R.layout.activity_bfjd_first_test;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        bfjdfInfo = new BFJDFInfo();
        bfjdfInfo.setScheduleWeek("2015" + "年  第" + 1 + "周");
        bfjdfInfo.setSchedulePlanNumber(20);
        bfjdfInfo.setScheduleRealityNumber(15);
        bfjdfInfo.setScheduleSize(bfjdfInfo.getScheduleRealityNumber(),
                bfjdfInfo.getSchedulePlanNumber());
        list.add(bfjdfInfo);

        for (int i = 2; i < 12; i++) {
            bfjdfInfo = new BFJDFInfo();
            bfjdfInfo.setScheduleWeek("2015" + "年  第" + i + "周");
            bfjdfInfo.setSchedulePlanNumber(30);
            bfjdfInfo.setScheduleRealityNumber(26);
            bfjdfInfo.setScheduleSize(bfjdfInfo.getScheduleRealityNumber(),
                    bfjdfInfo.getSchedulePlanNumber());
            list.add(bfjdfInfo);
        }
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        /**设置返回键可用*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryBFJDFActivity.this.finish();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerDecoration(mContext));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new BFJDFAdapter(list);
        mRecyclerView.setAdapter(mAdapter);

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
                //更新数据
                loadData();
            }
        });
    }
}
