package com.zhiyuan3g.fresco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class NuruToAdapter  extends BaseAdapter{

    private List<NaruTo>naruToList=new ArrayList<>();
    private Context context;

    public NuruToAdapter(List<NaruTo> naruToList, Context context) {
        this.naruToList = naruToList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return naruToList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder  =new Holder();
        if (convertView==null){

            convertView= LayoutInflater.from(context).inflate(R.layout.listviewlayout,null);
            holder.name= (TextView) convertView.findViewById(R.id.list_txtView);
            holder.content= (SimpleDraweeView) convertView.findViewById(R.id.list_sv);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        NaruTo naruTo=naruToList.get(position);
        holder.content.setImageURI(naruTo.getContent());
        holder.name.setText(naruTo.getName());
        return convertView;
    }

    private class Holder{
        TextView name;
        SimpleDraweeView content;
    }
}
