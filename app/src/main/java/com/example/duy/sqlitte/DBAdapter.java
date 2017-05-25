package com.example.duy.sqlitte;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
/**
 * Created by duy on 23/05/2017.
 */

public class DBAdapter extends RecyclerView.Adapter<DBAdapter.viewholder>{
    List<Data> datalist;
    Context context;

    public DBAdapter(List<Data> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_item,parent,false);
        return new viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {
        holder.tentv.setText(datalist.get(position).getTen());
        holder.id_team.setText(datalist.get(position).getId()+"");
        holder.tvtv.setText(datalist.get(position).getThanh_vien());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    public void addItem(int pos, Data data) {
        datalist.add(pos,data);
        notifyItemInserted(pos);
    }




    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tentv,tvtv,id_team;
        public viewholder(View itemView) {
            super(itemView);
            id_team = (TextView)itemView.findViewById(R.id.id_team);
            tentv = (TextView)itemView.findViewById(R.id.id_ten);
            tvtv = (TextView)itemView.findViewById(R.id.id_tv);
        }
      //  tentv = (TextView)
        @Override
        public void onClick(View v) {

        }
        public void  deleteitem(int pos,Data data){
        }
    }

}

