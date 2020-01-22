package com.snn.ekts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        return new Holder(layoutInflater.inflate(R.layout.event_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomEventAdapter.Holder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return MainActivity.events.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private int position;

        Holder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, MainActivity.events.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        void setData(int position) {
            this.position = position;

            TextView textview = itemView.findViewById(R.id.tvEventCard);
            ImageView imageView = itemView.findViewById(R.id.ivEventCard);

            textview.setText(MainActivity.events.get(position).getName());
            imageView.setImageResource(MainActivity.events.get(position).getImage());
        }
    }
}
