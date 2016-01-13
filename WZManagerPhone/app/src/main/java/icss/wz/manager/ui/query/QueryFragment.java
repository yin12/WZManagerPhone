package icss.wz.manager.ui.query;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import icss.wz.manager.R;
import icss.wz.manager.adapter.QueryGridAdapter;
import icss.wz.manager.listener.OnItemClickListener;
import icss.wz.manager.ui.base.BaseFragment;

/**
 * Created by john on 2015/12/15.
 */
public class QueryFragment extends BaseFragment implements
        OnItemClickListener {
    public static final String TAG = "QueryFragment";

    @Bind(R.id.list)
    RecyclerView mRecyclerView;

    private List<String> gridNames;
    private QueryGridAdapter mAdapter;


    @Override
    protected int getContentView() {
        return R.layout.fragment_query;
    }

    @Override
    protected void initData() {
        gridNames = Arrays.asList(mContext.getResources().getStringArray(R.array.query_grids));
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
//        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(mContext));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new QueryGridAdapter(gridNames);
//        mAdapter.addAll(gridNames);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:   //拜访进度
//              goToActivity(VisitFirstActivity.class, bundle);
                goToActivity(QueryBFJDFActivity.class, bundle);
                break;
            case 1: //订货跟踪
                goToActivity(QueryDHGZFActivity.class, bundle);
                break;
            case 2://本周未订
                goToActivity(QueryBZWDActivity.class, bundle);
                break;
            case 3://规格跟踪
                goToActivity(QueryGGGZActivity.class, bundle);
                break;
//            case 4://卷烟跟踪
//                goToActivity(QueryJYGZActivity.class, bundle);
//                break;
            default:
                break;
        }

    }
}
