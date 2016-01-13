package icss.wz.manager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

import icss.wz.manager.R;
import icss.wz.manager.adapter.base.BaseListViewAdapter;
import icss.wz.manager.bean.GZZJInfo;
import icss.wz.manager.util.ToastUtils;

/**
 * Created by Administrator on 2015/12/25
 * <p/>
 * 工作总结-Adapter
 */
public class GZZJAdapter extends BaseListViewAdapter<GZZJInfo>
        implements RadioGroup.OnCheckedChangeListener {
    /**
     * 设置已拜访是否显示的Value
     */
    private static final int IS_VISIT = 1;

    private GZZJInfo mInfo;
    private RadioButton isRadioButton, noRadioButton;
    private RadioGroup mRadioGroup;

    public GZZJAdapter(Context context, List<GZZJInfo> list) {
        super(context, list);
    }

    @Override
    public int inflateLayoutRes() {
        return R.layout.item_gzzj_info;
    }

    @Override
    public View bindView(int position, View convertView, ViewGroup parent, SparseArrayViewHolder viewHolder) {
        mInfo = list.get(position);
        viewHolder.setText(convertView, R.id.client_id, mInfo.getClientId());
        viewHolder.setText(convertView, R.id.client_name, mInfo.getClientName());
        viewHolder.setText(convertView, R.id.check_in_time, mInfo.getCheckInTime());
        viewHolder.setText(convertView, R.id.sign_back_time, mInfo.getSignBackTime());

        /**通过一个值来判断已拜访与未拜访原因的显示*/
        if (mInfo.getScheduleType() == IS_VISIT) {
            viewHolder.setVisible(convertView, R.id.schedule_type, true);//已拜访显示
            viewHolder.setVisible(convertView, R.id.radio_group, false);//未拜访显示
        } else {
            viewHolder.setVisible(convertView, R.id.schedule_type, false);//已拜访显示
            viewHolder.setVisible(convertView, R.id.radio_group, true);//未拜访显示
        }

        mRadioGroup = (RadioGroup) convertView.findViewById(R.id.radio_group);
        isRadioButton = (RadioButton) convertView.findViewById(R.id.is_button);
        noRadioButton = (RadioButton) convertView.findViewById(R.id.no_button);

        mRadioGroup.setOnCheckedChangeListener(this);

        return convertView;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.is_button:
                ToastUtils.showToast(group.getContext(), "延迟");
                break;
            case R.id.no_button:
                ToastUtils.showToast(group.getContext(), "其他原因");
                break;
            default:
                isRadioButton.setChecked(true);
                break;
        }
    }
}

//public class GZZJAdapter extends BaseRecyclerViewAdapter
//        implements RadioGroup.OnCheckedChangeListener {
//    private static final String TAG = "GZZJAdapter";
//    private SparseArrayViewHolder viewHolder;
//    private GZZJInfo info;
//    @Bind(R.id.is_button)
//    Button isRadioButton;
//    @Bind(R.id.no_button)
//    Button noRadioButton;
//
//    /**
//     * @param list the datas to attach the adapter
//     */
//    public GZZJAdapter(List list) {
//        super(list);
//    }
//
//    @Override
//    protected void bindDataToItemView(SparseArrayViewHolder sparseArrayViewHolder, int position) {
//        info = (GZZJInfo) getItem(position);
//        if (info != null) {
//            viewHolder.setText(R.id.client_id, info.getId());
//            viewHolder.setText(R.id.client_name, info.getClientName());
//            viewHolder.setText(R.id.check_in_time, info.getCheckInTime());
//            viewHolder.setText(R.id.sign_back_time, info.getSignBackTime());
//
//            /**已拜访可见*/
//            viewHolder.setVisible(R.id.client_state, true);
//            /**未拜访原因可见*/
////            viewHolder.setVisible(R.id.radio_group, true);
//        }
//
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        viewHolder = new SparseArrayViewHolder(
//                inflateItemView(parent, R.layout.item_gzzj_info));
//        return viewHolder;
//    }
//
//
//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        switch (checkedId) {
//            case R.id.is_button:
//                ToastUtils.showToast(group.getContext(), "延迟");
//                break;
//            case R.id.no_button:
//                ToastUtils.showToast(group.getContext(), "其他原因");
//                break;
//            default:
//                break;
//        }
//    }
//}
