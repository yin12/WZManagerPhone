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
import icss.wz.manager.adapter.DHGZSAdapter;
import icss.wz.manager.bean.DHGZSInfo;
import icss.wz.manager.ui.base.BaseActivity;

/**
 * Created by Administrator on 2015/12/23.
 * <p/>
 * 订货跟踪——表2
 */
public class QueryDHGZSActivity extends BaseActivity {
    private static final String TAG = "QueryDHGZSActivity";

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.srl_list)
    SwipeRefreshLayout mRefresh;
    @Bind(R.id.list)
    RecyclerView mRecyclerView;

    private DHGZSInfo dhgzSecondInfo;
    private List<DHGZSInfo> list;
    private DHGZSAdapter dhgzsAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_second_dhgz;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            dhgzSecondInfo = new DHGZSInfo();

            dhgzSecondInfo.setCigaretteOrders("致青春");
            dhgzSecondInfo.setGoodsQuantity(2.0);
            dhgzSecondInfo.setAmount(2400.00);
            dhgzSecondInfo.setOrderDate("2015-12-23");

            list.add(dhgzSecondInfo);
        }
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
                QueryDHGZSActivity.this.finish();
            }
        });

        initRefresh();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerDecoration(this));
        mRecyclerView.setHasFixedSize(true);
        dhgzsAdapter = new DHGZSAdapter(list);
        mRecyclerView.setAdapter(dhgzsAdapter);
    }

    /**
     * 下拉刷新，更新数据
     */
    private void initRefresh() {
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新,更新数据
                loadData();
            }
        });
        mRefresh.setColorSchemeColors(
                getResources().getColor(R.color.orange),
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green)
        );
    }
}
