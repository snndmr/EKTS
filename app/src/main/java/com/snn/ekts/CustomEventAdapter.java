package com.snn.ekts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CustomEventAdapter extends RecyclerView.Adapter<CustomEventAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;

    CustomEventAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CustomEventAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 2) {
            return new Holder(layoutInflater.inflate(R.layout.event_card_horizontal, parent, false));
        }
        return new Holder(layoutInflater.inflate(R.layout.event_card_vertical, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CustomEventAdapter.Holder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return Test.events.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private int position;

        Holder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent event = new Intent(context, EventActivity.class);
                    event.putExtra("Position", position);
                    context.startActivity(event);
                }
            });
        }

        void setData(int position) {
            this.position = position;
        }
    }
}
