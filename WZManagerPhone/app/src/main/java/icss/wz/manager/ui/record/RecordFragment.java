package icss.wz.manager.ui.record;

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
public class RecordFragment extends BaseFragment
        implements OnItemClickListener {
    public static final String TAG = "RecordFragment";
    @Bind(R.id.list)
    RecyclerView mRecyclerView;

    private QueryGridAdapter mAdapter;
    private List<String> gridNames;

    @Override
    protected int getContentView() {
        return R.layout.fragment_record;
    }

    @Override
    protected void initData() {
        gridNames = Arrays.asList(mContext.getResources().getStringArray(R.array.record_grids));

    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new QueryGridAdapter(gridNames);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view, int position) {
        Bundle bundle = new Bundle();
        switch (position) {
            case 0://工作总结
                goToActivity(RecordGZZJActivity.class, bundle);
                break;
            default:
                break;
        }
    }
}
