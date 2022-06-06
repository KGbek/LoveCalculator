package com.example.lovecalculator.onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lovecalculator.R;

public class Viewpager2Adapter extends RecyclerView.Adapter<Viewpager2Adapter.ViewHolder> {

    public int[] images = { R.drawable.loveis0,
            R.drawable.loveis1,
            R.drawable.loveis2,
            R.drawable.loveis3};
    private Context mcontext;

    public Viewpager2Adapter(Context context) {
        this.mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.vp_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.decsTV.setText(mcontext.getResources().getStringArray(R.array.Description)[position]);
        holder.heading.setText(mcontext.getResources().getStringArray(R.array.heading)[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView decsTV;
        TextView heading;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
            decsTV = itemView.findViewById(R.id.DescriptionTV);
            heading = itemView.findViewById(R.id.HeadingTV);
        }
    }
}
