package icss.wz.manager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import icss.wz.manager.R;
import icss.wz.manager.adapter.base.BaseRecyclerViewAdapter;
import icss.wz.manager.bean.ClientInfo;

/**
 * Created by Administrator on 2015/12/24.
 */
public class BFJDScheduleAdapter extends BaseRecyclerViewAdapter {
    private SparseArrayViewHolder viewHolder;
    private ClientInfo clientInfo;

    /**
     * @param list the datas to attach the adapter
     */
    public BFJDScheduleAdapter(List list) {
        super(list);
    }

    @Override
    protected void bindDataToItemView(SparseArrayViewHolder sparseArrayViewHolder, int position) {
        clientInfo = (ClientInfo) getItem(position);
        if (clientInfo != null) {
            viewHolder.setText(R.id.client_name, clientInfo.getClientName());
            viewHolder.setText(R.id.client_code, "(" + clientInfo.getClientCode() + ")");
            viewHolder.setText(R.id.client_address, clientInfo.getClientAddress());

            viewHolder.setText(R.id.behavior_red, clientInfo.getBehavior());
//            viewHolder.setText(R.id.behavior_blue, clientInfo.getBehavior());

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        viewHolder = new SparseArrayViewHolder(
                inflateItemView(parent, R.layout.item_info_schedule));
        return viewHolder;
    }
}
