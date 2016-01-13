package icss.wz.manager.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import icss.wz.manager.R;
import icss.wz.manager.adapter.base.BaseRecyclerViewAdapter;
import icss.wz.manager.bean.ClientInfo;

/**
 * Created by Administrator on 2015/12/22.
 */
public class BZWDAdapter extends BaseRecyclerViewAdapter
        implements View.OnClickListener, View.OnLongClickListener {

    private SparseArrayViewHolder sparseArrayViewHolder;
    private ClientInfo clientInfo;

    /**
     * @param list the datas to attach the adapter
     */
    public BZWDAdapter(List list) {
        super(list);
    }

    @Override
    protected void bindDataToItemView(SparseArrayViewHolder sparseArrayViewHolder, int position) {
        clientInfo = (ClientInfo) getItem(position);
        if (clientInfo != null) {
            sparseArrayViewHolder.setText(R.id.client_name,
                    clientInfo.getClientName());
            sparseArrayViewHolder.setText(R.id.client_code,
                    "(" + clientInfo.getClientCode() + ")");
            sparseArrayViewHolder.setText(R.id.client_phone_number,
                    clientInfo.getClientPhoneNumber());
            sparseArrayViewHolder.setText(R.id.client_address,
                    clientInfo.getClientAddress());


            /**点击手机号——拨号*/
            sparseArrayViewHolder.setOnClickListener(R.id.phone_icon, this);
//            sparseArrayViewHolder.setOnClickListener(R.id.client_phone_number, this);
            /**长按手机号——拨号*/
            sparseArrayViewHolder.setOnLongClickListener(R.id.client_phone_number, this);

        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        sparseArrayViewHolder = new SparseArrayViewHolder(
                inflateItemView(parent, R.layout.item_bzwd_info));
        return sparseArrayViewHolder;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + clientInfo.getClientPhoneNumber()));
        v.getContext().startActivity(intent);
    }


    @Override
    public boolean onLongClick(View v) {
        /**跳转到拨号界面——需要再次按拨号键打电话*/
//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + bzwdInfo.getClientPhoneNumber()));
        /**不跳转到拨号界面——直接打电话*/
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + clientInfo.getClientPhoneNumber()));
        v.getContext().startActivity(intent);
        return true;
    }
}
