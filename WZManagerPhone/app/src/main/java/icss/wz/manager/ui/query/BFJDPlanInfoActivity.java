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
import icss.wz.manager.adapter.BFJDPlanAdapter;
import icss.wz.manager.bean.ClientInfo;
import icss.wz.manager.ui.base.BaseActivity;

/**
 * Created by Administrator on 2015/12/24.
 * <p/>
 * 计划户数——信息
 */
public class BFJDPlanInfoActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.list)
    RecyclerView mRecyclerView;
    @Bind(R.id.srl_list)
    SwipeRefreshLayout mRefresh;

    private ClientInfo clientInfo;
    private List<ClientInfo> list;
    private BFJDPlanAdapter planAdapter;


    @Override
    protected int getContentView() {
        return R.layout.activity_info_plan_bfjd;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            clientInfo = new ClientInfo();
            //数据赋值
            clientInfo.setClientName("客户A");
            clientInfo.setPlanDate("2015-12-24");
            clientInfo.setClientCode("0000111*");
            clientInfo.setClientAddress("梧州市****************");
            //添加数据
            list.add(clientInfo);
        }

    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /**返回事件*/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BFJDPlanInfoActivity.this.finish();
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        planAdapter = new BFJDPlanAdapter(list);
        mRecyclerView.setAdapter(planAdapter);

        initRefresh();
    }

    /**
     * 下拉刷新，更新数据
     */
    private void initRefresh() {
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //加载数据
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
