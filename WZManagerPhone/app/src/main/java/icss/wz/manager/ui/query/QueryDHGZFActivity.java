package icss.wz.manager.ui.query;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import icss.wz.manager.R;
import icss.wz.manager.adapter.DHGZFAdapter;
import icss.wz.manager.bean.DHGFZInfo;
import icss.wz.manager.dialog.DatePickDialog;
import icss.wz.manager.ui.base.BaseActivity;

/**
 * Created by Administrator on 2015/12/22.
 * <p/>
 * 订货跟踪
 */
public class QueryDHGZFActivity extends BaseActivity
        implements View.OnClickListener {
    private static final String TAG = "QueryDHGZFActivity";

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.list)
    RecyclerView mRecyclerView;
    @Bind(R.id.srl_list)
    SwipeRefreshLayout mRefresh;
    @Bind(R.id.choice_date)
    TextView choiceDate;

    private DHGFZInfo dhgFirstZInfo;
    private List<DHGFZInfo> list;
    private DHGZFAdapter mAdapter;

    private DatePickDialog datePickDialog;

    @Override
    protected int getContentView() {
        return R.layout.activity_dhgz_query;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            dhgFirstZInfo = new DHGFZInfo();

            dhgFirstZInfo.setId("" + i);
            dhgFirstZInfo.setClientName("客户A ");
            dhgFirstZInfo.setClientCode("00112*");
            dhgFirstZInfo.setOrderQuantity(370);
            dhgFirstZInfo.setMoney(29000);
            dhgFirstZInfo.setOrderPrice(78.37);
            dhgFirstZInfo.setOrderNumber(5);

            list.add(dhgFirstZInfo);
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
                QueryDHGZFActivity.this.finish();

            }
        });
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String date = simpleDateFormat.format(new Date());
        choiceDate.setText("月份：" + date);
        choiceDate.setOnClickListener(this);

//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.ab_switch_data:
//                        //添加时间选择Dialog
////                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
////                        String date = simpleDateFormat.format(new Date());
////                        setTitle("月份 " + date);
//                        openDialog();
////                        ToastUtils.showToast(QueryDHGZFActivity.this, "选择时间");
//                        break;
//                }
//                return true;
//            }
//        });

        initRefresh();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerDecoration(this));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new DHGZFAdapter(list);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
//        return true;
    }

    /**
     * 更新数据
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

    @Override
    public void onClick(View v) {
        datePickDialog = new DatePickDialog(this, 2);
        //选择时间
        datePickDialog.show();
    }
}
