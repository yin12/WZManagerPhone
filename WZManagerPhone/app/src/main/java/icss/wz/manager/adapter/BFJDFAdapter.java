package icss.wz.manager.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import icss.wz.manager.R;
import icss.wz.manager.adapter.base.BaseRecyclerViewAdapter;
import icss.wz.manager.bean.BFJDFInfo;
import icss.wz.manager.ui.query.BFJDPlanInfoActivity;
import icss.wz.manager.ui.query.BFJDRealityInfoActivity;

/**
 * Created by Administrator on 2015/12/22.
 */
public class BFJDFAdapter extends BaseRecyclerViewAdapter implements View.OnClickListener {

    private SparseArrayViewHolder sparseArrayViewHolder;
    private BFJDFInfo infoFirst;

    /**
     * @param list the datas to attach the adapter
     */
    public BFJDFAdapter(List list) {
        super(list);
    }

    @Override
    protected void bindDataToItemView(SparseArrayViewHolder sparseArrayViewHolder, int position) {
        infoFirst = (BFJDFInfo) getItem(position);
        if (infoFirst != null) {
            sparseArrayViewHolder.setText(R.id.schedule_week,
                    infoFirst.getScheduleWeek());
            sparseArrayViewHolder.setText(R.id.schedule_plan_number,
                    Html.fromHtml("<u>" + String.valueOf(infoFirst.getSchedulePlanNumber()) + "</u>"));
            sparseArrayViewHolder.setText(R.id.schedule_reality_number,
                    Html.fromHtml("<u>" + String.valueOf(infoFirst.getScheduleRealityNumber()) + "</u>"));
            sparseArrayViewHolder.setText(R.id.schedule_size, infoFirst.getScheduleSize() + "%");

//            sparseArrayViewHolder.setText(R.id.schedule_size,
//                    Html.fromHtml("<u>" + infoFirst.getScheduleSize() + "%" + "</u>"));
//            sparseArrayViewHolder.setText(R.id.schedule_plan_number,
//                    String.valueOf(infoFirst.getSchedulePlanNumber()));
//            sparseArrayViewHolder.setText(R.id.schedule_reality_number,
//            String.valueOf(infoFirst.getScheduleRealityNumber()));


            /**点击事件*/
//            sparseArrayViewHolder.setOnClickListener(R.id.schedule_week, this);
            sparseArrayViewHolder.setOnClickListener(R.id.schedule_plan_number, this);
            sparseArrayViewHolder.setOnClickListener(R.id.schedule_reality_number, this);
//            sparseArrayViewHolder.setOnClickListener(R.id.schedule_size, this);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        sparseArrayViewHolder = new
                SparseArrayViewHolder(inflateItemView(parent, R.layout.item_info_first));
        return sparseArrayViewHolder;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
//            case R.id.schedule_week:
//                Intent intent = new Intent();
//                intent.setClass(v.getContext(), QueryBFJDSActivity.class);
//                v.getContext().startActivity(intent);
//                break;
            case R.id.schedule_plan_number://计划户数信息
                intent.setClass(v.getContext(), BFJDPlanInfoActivity.class);
//                ToastUtils.showToast(v.getContext(), "查看计划户数信息");
                break;
            case R.id.schedule_reality_number://拜访户数信息
                intent.setClass(v.getContext(), BFJDRealityInfoActivity.class);
//                ToastUtils.showToast(v.getContext(), "查看拜访户数信息");
                break;
//            case R.id.schedule_size://拜访进度信息
//                intent.setClass(v.getContext(), BFJDScheduleActivity.class);
////                ToastUtils.showToast(v.getContext(), "查看拜访进度信息");
//                break;
            default:
                break;
        }
//        Intent intent = new Intent(v.getContext(), QueryBFJDSActivity.class);
        v.getContext().startActivity(intent);
    }

}
