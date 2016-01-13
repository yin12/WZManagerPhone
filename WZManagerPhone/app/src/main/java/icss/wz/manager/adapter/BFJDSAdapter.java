package icss.wz.manager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import icss.wz.manager.R;
import icss.wz.manager.adapter.base.BaseRecyclerViewAdapter;
import icss.wz.manager.bean.BFJDSInfo;

/**
 * Created by Administrator on 2015/12/22.
 */
public class BFJDSAdapter extends BaseRecyclerViewAdapter {
    private BFJDSInfo secondInfo;
    private SparseArrayViewHolder sparseArrayViewHolder;

    /**
     * @param list the datas to attach the adapter
     */
    public BFJDSAdapter(List list) {
        super(list);
    }

    @Override
    protected void bindDataToItemView(SparseArrayViewHolder sparseArrayViewHolder, int position) {
        secondInfo = (BFJDSInfo) getItem(position);
        if (secondInfo != null) {
            sparseArrayViewHolder.setText(R.id.schedule_name, secondInfo.getScheduleName());
            sparseArrayViewHolder.setText(R.id.schedule_data, secondInfo.getScheduleData());
            sparseArrayViewHolder.setText(R.id.schedule_code, secondInfo.getScheduleCode());
            sparseArrayViewHolder.setText(R.id.schedule_address, secondInfo.getScheduleAddress());

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        sparseArrayViewHolder = new
                SparseArrayViewHolder(inflateItemView(parent, R.layout.item_info));
        return sparseArrayViewHolder;
    }

}
