package icss.wz.manager.ui.query;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import icss.wz.manager.R;
import icss.wz.manager.adapter.GGGZAdapter;
import icss.wz.manager.bean.GGGZInfo;
import icss.wz.manager.dialog.DatePickDialog;
import icss.wz.manager.ui.base.BaseActivity;
import icss.wz.manager.util.ToastUtils;

/**
 * Created by Administrator on 2015/12/25.
 * <p/>
 * 规格跟踪
 */
public class QueryGGGZActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,
        AdapterView.OnItemSelectedListener, View.OnClickListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.srl_list)
    SwipeRefreshLayout mRefresh;
    @Bind(R.id.list)
    RecyclerView mRecyclerView;

    @Bind(R.id.spinner)
    Spinner mSpinner;
    @Bind(R.id.radio_group)
    RadioGroup mRadioGroup;
    @Bind(R.id.is_button)
    RadioButton isRadioButton;
    @Bind(R.id.no_button)
    RadioButton noRadioButton;
    @Bind(R.id.choice_date)
    TextView choiceDate;

    private GGGZInfo info;
    private List<GGGZInfo> list;
    private GGGZAdapter gggzAdapter;
    private ArrayAdapter<String> arrayAdapter;
    private String[] mItems;
    private DatePickDialog datePickDialog;

    @Override

    protected int getContentView() {
        return R.layout.activity_gggz_query;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            info = new GGGZInfo();
            info.setId("" + i);
            info.setClientName("客户A");
            info.setClientCode("00112*");
            info.setOrderQuantity(370);
            info.setMoney(29000.00);
            //添加数据
            list.add(info);
        }
        mItems = getResources().getStringArray(R.array.spinner_content);
        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, mItems);
        mSpinner.setAdapter(arrayAdapter);
    }

    @Override
    protected void initView() {
        /**获取系通时间*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String mDate = simpleDateFormat.format(new Date());
        choiceDate.setText("订单日期：" + mDate);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryGGGZActivity.this.finish();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        gggzAdapter = new GGGZAdapter(list);
        mRecyclerView.setAdapter(gggzAdapter);

        //刷新数据
        initRefresh();
        //单选
        mRadioGroup.setOnCheckedChangeListener(this);
        /**日期选择事件监听*/
        choiceDate.setOnClickListener(this);
        //下拉选择
        //添加事件Spinner事件监听
        mSpinner.setOnItemSelectedListener(this);
        mSpinner.setVisibility(View.VISIBLE);

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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.is_button:
                ToastUtils.showToast(QueryGGGZActivity.this, "是");
                break;
            case R.id.no_button:
                ToastUtils.showToast(QueryGGGZActivity.this, "否");
                break;
            default:
                isRadioButton.setChecked(true);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ToastUtils.showToast(this, mItems[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {
//        ToastUtils.showToast(this, "选择日期");
        /**选择日期*/
        datePickDialog = new DatePickDialog(this, 1);
        datePickDialog.show();
    }
}
