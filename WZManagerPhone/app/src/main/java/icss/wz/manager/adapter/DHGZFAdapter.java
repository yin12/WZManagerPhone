package icss.wz.manager.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import icss.wz.manager.R;
import icss.wz.manager.adapter.base.BaseRecyclerViewAdapter;
import icss.wz.manager.bean.DHGFZInfo;
import icss.wz.manager.ui.query.QueryDHGZSActivity;

/**
 * Created by Administrator on 2015/12/22.
 */
public class DHGZFAdapter extends BaseRecyclerViewAdapter implements View.OnClickListener {

    private SparseArrayViewHolder sparseArrayViewHolder;
    private DHGFZInfo dhgFirstZInfo;

    /**
     * @param list the datas to attach the adapter
     */
    public DHGZFAdapter(List list) {
        super(list);
    }

    @Override
    protected void bindDataToItemView(SparseArrayViewHolder sparseArrayViewHolder, int position) {
        dhgFirstZInfo = (DHGFZInfo) getItem(position);
        if (dhgFirstZInfo != null) {
            sparseArrayViewHolder.setText(R.id.client_id,
                    dhgFirstZInfo.getId());
//            sparseArrayViewHolder.setText(R.id.client_name,
//                    dhgFirstZInfo.getClientName());
            sparseArrayViewHolder.setText(R.id.client_name,
                    Html.fromHtml("<u>" + dhgFirstZInfo.getClientName() + "</u>"));
            sparseArrayViewHolder.setText(R.id.client_code,
                    "(" + dhgFirstZInfo.getClientCode() + ")");
            sparseArrayViewHolder.setText(R.id.client_order_quantity,
                    String.valueOf(dhgFirstZInfo.getOrderQuantity()));
            sparseArrayViewHolder.setText(R.id.client_money,
                    String.valueOf(dhgFirstZInfo.getMoney()));
            sparseArrayViewHolder.setText(R.id.client_order_price,
                    String.valueOf(dhgFirstZInfo.getOrderPrice()));
            sparseArrayViewHolder.setText(R.id.client_order_number,
                    String.valueOf(dhgFirstZInfo.getOrderNumber()));

            /***/
            sparseArrayViewHolder.setOnClickListener(R.id.client_layout, this);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        sparseArrayViewHolder = new SparseArrayViewHolder(
                inflateItemView(parent, R.layout.item_dhgz_info));
        return sparseArrayViewHolder;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), QueryDHGZSActivity.class);
        v.getContext().startActivity(intent);
    }

}
