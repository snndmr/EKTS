package com.snn.kts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;

    CustomAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CustomAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(layoutInflater.inflate(R.layout.event_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.Holder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class Holder extends RecyclerView.ViewHolder {
        private int position;

        Holder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Position : " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        void setData(int position) {
            this.position = position;
        }
    }
}
