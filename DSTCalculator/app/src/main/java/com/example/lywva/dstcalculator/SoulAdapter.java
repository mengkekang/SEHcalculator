package com.example.lywva.dstcalculator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Field;
import java.util.Vector;

/**
 * Created by lywva on 2020/10/18.
 */
public class SoulAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    Vector<Vector<String>> mfood;

    public SoulAdapter(Context context, Vector<Vector<String>> food){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mfood = food;
    }

    @Override
    public int getCount() {
        return 31;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        public ImageView ivItem;
        public TextView tvItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_soul_item, null);
            holder = new ViewHolder();
            holder.ivItem = (ImageView) convertView.findViewById(R.id.iv_item);
            holder.tvItem = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        String resName = "food" + (position+1);
        int drawableId = getDrawableId(resName);
        Glide.with(mContext).load(drawableId).into(holder.ivItem);
        holder.tvItem.setText(mfood.get(position).get(1));
        return convertView;
    }

    public static int getDrawableId(String var) {
        try {
            Field field = R.drawable.class.getField(var);
            return field.getInt(new R.drawable());
        } catch (Exception e) {
            return 0;
        }
    }
}
