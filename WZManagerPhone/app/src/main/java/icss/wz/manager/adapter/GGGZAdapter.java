package icss.wz.manager.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import icss.wz.manager.R;
import icss.wz.manager.adapter.base.BaseRecyclerViewAdapter;
import icss.wz.manager.bean.GGGZInfo;
import icss.wz.manager.util.ToastUtils;

/**
 * Created by Administrator on 2015/12/25.
 */
public class GGGZAdapter extends BaseRecyclerViewAdapter
        implements View.OnClickListener {
    private SparseArrayViewHolder viewHolder;
    private GGGZInfo info;

    /**
     * @param list the datas to attach the adapter
     */
    public GGGZAdapter(List list) {
        super(list);
    }

    @Override
    protected void bindDataToItemView(SparseArrayViewHolder sparseArrayViewHolder, int position) {
        info = (GGGZInfo) getItem(position);
        if (info != null) {
//            client_id client_name order_amount order_money

            viewHolder.setText(R.id.client_id, info.getId());
            viewHolder.setText(R.id.client_name,
                    Html.fromHtml("<u>" + info.getClientName() + "</u>"));
            viewHolder.setText(R.id.client_code,
                    Html.fromHtml("<u>" + "(" + info.getClientCode() + ")" + "</u>"));
            viewHolder.setText(R.id.order_amount,
                    String.valueOf(info.getOrderQuantity()));
            viewHolder.setText(R.id.order_money,
                    String.valueOf(info.getMoney()));

            viewHolder.setOnClickListener(R.id.cline_layout, this);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        viewHolder = new SparseArrayViewHolder(
                inflateItemView(parent, R.layout.item_info_gggz));

        return viewHolder;
    }

    @Override
    public void onClick(View v) {
        ToastUtils.showToast(v.getContext(), "点击事件");
    }
}
