package icss.wz.manager.ui.query;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import icss.wz.manager.R;
import icss.wz.manager.adapter.BZWDAdapter;
import icss.wz.manager.bean.ClientInfo;
import icss.wz.manager.ui.base.BaseActivity;

/**
 * Created by Administrator on 2015/12/22.
 * <p/>
 * 本周未订
 */
public class QueryBZWDActivity extends BaseActivity {
    private static final String TAG = "QueryBZWDActivity";

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.list)
    RecyclerView mRecyclerView;
    @Bind(R.id.srl_list)
    SwipeRefreshLayout mRefresh;

    private ClientInfo clientInfo;
    private List<ClientInfo> list;
    private BZWDAdapter bzwdAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_bzwd_query;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            clientInfo = new ClientInfo();
            clientInfo.setClientName("客户A");
            clientInfo.setClientCode("0000111*");
            clientInfo.setClientPhoneNumber("15956969324");
            clientInfo.setClientAddress("梧州市***************");
            list.add(clientInfo);
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
                QueryBZWDActivity.this.finish();
            }
        });
        initRefresh();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerDecoration(this));
        mRecyclerView.setHasFixedSize(true);
        bzwdAdapter = new BZWDAdapter(list);
        mRecyclerView.setAdapter(bzwdAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 更新数据，
     */
    private void initRefresh() {
        mRefresh.setColorSchemeColors(
                getResources().getColor(R.color.orange),
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green)
        );
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新，更新数据
                loadData();
            }
        });
    }
}
