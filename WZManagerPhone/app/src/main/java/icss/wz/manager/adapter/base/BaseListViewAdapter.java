package icss.wz.manager.adapter.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础的适配器
 */
@SuppressLint("UseSparseArrays")
public abstract class BaseListViewAdapter<E> extends BaseAdapter {

    public List<E> list;

    public Context mContext;

    public LayoutInflater mInflater;

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void add(E e) {
        this.list.add(e);
        notifyDataSetChanged();
    }

    public void addAll(List<E> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        this.list.remove(position);
        notifyDataSetChanged();
    }

    public BaseListViewAdapter(Context context, List<E> list) {
        super();
        this.mContext = context;
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
//		convertView = bindView(position, convertView, parent);
        SparseArrayViewHolder holder;
        if (null == convertView) {
            holder = new SparseArrayViewHolder();
            convertView = LayoutInflater.from(mContext)
                    .inflate(inflateLayoutRes(), null);
            convertView.setTag(holder);
        } else {
            holder = (SparseArrayViewHolder) convertView.getTag();
        }
        // 绑定内部点击监听
        addInternalClickListener(convertView, position, list.get(position));
        return bindView(position, convertView, parent, holder);
    }

    /**
     * 改方法需要子类实现，需要返回item布局的resource id
     *
     * @return
     */
    public abstract int inflateLayoutRes();

    public abstract View bindView(int position, View convertView,
                                  ViewGroup parent, SparseArrayViewHolder viewHolder);

    // adapter中的内部点击事件
    public Map<Integer, onInternalClickListener> canClickItem;

    private void addInternalClickListener(final View itemV,
                                          final Integer position, final Object valuesMap) {
        if (canClickItem != null) {
            for (Integer key : canClickItem.keySet()) {
                View inView = itemV.findViewById(key);
                final onInternalClickListener inviewListener = canClickItem
                        .get(key);
                if (inView != null && inviewListener != null) {
                    inView.setOnClickListener(new OnClickListener() {

                        public void onClick(View v) {
                            inviewListener.OnClickListener(itemV, v, position, valuesMap);
                        }
                    });
                }
            }
        }
    }

    public void setOnInViewClickListener(Integer key,
                                         onInternalClickListener onClickListener) {
        if (canClickItem == null)
            canClickItem = new HashMap<Integer, onInternalClickListener>();
        canClickItem.put(key, onClickListener);
    }

    public interface onInternalClickListener {
        public void OnClickListener(View parentV, View v, Integer position, Object values);
    }


    /**
     * 各个控件的缓存
     */
    public class SparseArrayViewHolder {
        public SparseArray<View> views = new SparseArray<View>();

        /**
         * 指定resId和类型即可获取到相应的view
         *
         * @param convertView
         * @param resId
         * @param <T>
         * @return
         */
        public <T extends View> T getView(View convertView, int resId) {
            View v = views.get(resId);
            if (null == v) {
                v = convertView.findViewById(resId);
                views.put(resId, v);
            }
            return (T) v;
        }

        public SparseArrayViewHolder setText(View convertView, int viewId, String value) {
            TextView view = getView(convertView, viewId);
            view.setText(value);
            return SparseArrayViewHolder.this;
        }

        public SparseArrayViewHolder setText(View convertView, int viewId, CharSequence text) {
            TextView view = getView(convertView, viewId);
            view.setText(text);
            return SparseArrayViewHolder.this;
        }

        public SparseArrayViewHolder setTextColor(View convertView, int viewId, int textColor) {
            TextView view = getView(convertView, viewId);
            view.setTextColor(textColor);
            return SparseArrayViewHolder.this;
        }

        public SparseArrayViewHolder setImageResource(View convertView, int viewId, int imageResId) {
            ImageView view = getView(convertView, viewId);
            view.setImageResource(imageResId);
            return SparseArrayViewHolder.this;
        }

        public SparseArrayViewHolder setBackgroundColor(View convertView, int viewId, int color) {
            View view = getView(convertView, viewId);
            view.setBackgroundColor(color);
            return SparseArrayViewHolder.this;
        }

        public SparseArrayViewHolder setBackgroundResource(View convertView, int viewId, int backgroundRes) {
            View view = getView(convertView, viewId);
            view.setBackgroundResource(backgroundRes);
            return SparseArrayViewHolder.this;
        }

        public SparseArrayViewHolder setVisible(View convertView, int viewId, boolean visible) {
            View view = getView(convertView, viewId);
            view.setVisibility(visible ? View.VISIBLE : View.GONE);
            return SparseArrayViewHolder.this;
        }

        public SparseArrayViewHolder setOnClickListener(View convertView, int viewId, OnClickListener listener) {
            View view = getView(convertView, viewId);
            view.setOnClickListener(listener);
            return SparseArrayViewHolder.this;
        }

        public SparseArrayViewHolder setOnTouchListener(View convertView, int viewId, View.OnTouchListener listener) {
            View view = getView(convertView, viewId);
            view.setOnTouchListener(listener);
            return SparseArrayViewHolder.this;
        }

        public SparseArrayViewHolder setOnLongClickListener(View convertView, int viewId, View.OnLongClickListener
                listener) {
            View view = getView(convertView, viewId);
            view.setOnLongClickListener(listener);
            return SparseArrayViewHolder.this;
        }
        public SparseArrayViewHolder setTag(View convertView, int viewId, Object tag) {
            View view = getView(convertView, viewId);
            view.setTag(tag);
            return SparseArrayViewHolder.this;
        }

    }
}
