package icss.wz.manager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import icss.wz.manager.R;
import icss.wz.manager.adapter.base.BaseRecyclerViewAdapter;
import icss.wz.manager.bean.DHGZSInfo;

/**
 * Created by Administrator on 2015/12/23.
 */
public class DHGZSAdapter extends BaseRecyclerViewAdapter {

    private SparseArrayViewHolder sparseArrayViewHolder;
    private DHGZSInfo dhgzSecondInfo;

    /**
     * @param list the datas to attach the adapter
     */
    public DHGZSAdapter(List list) {
        super(list);
    }

    @Override
    protected void bindDataToItemView(SparseArrayViewHolder sparseArrayViewHolder, int position) {
        dhgzSecondInfo = (DHGZSInfo) getItem(position);
        if (dhgzSecondInfo != null) {
            sparseArrayViewHolder.setText(R.id.cigarette_orders,
                    dhgzSecondInfo.getCigaretteOrders());
            sparseArrayViewHolder.setText(R.id.goods_quantity,
                    String.valueOf(dhgzSecondInfo.getGoodsQuantity()));
            sparseArrayViewHolder.setText(R.id.order_amount,
                    String.valueOf(dhgzSecondInfo.getAmount()));
            sparseArrayViewHolder.setText(R.id.order_date,
                    dhgzSecondInfo.getOrderDate());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        sparseArrayViewHolder = new SparseArrayViewHolder(
                inflateItemView(parent, R.layout.item_second_info_dhgz));

        return sparseArrayViewHolder;
    }
}
