package ru.emlsoft.healthtracker.adapters;

import static java.util.Collections.emptyList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.emlsoft.healthtracker.databinding.ItemDrugBinding;
import ru.emlsoft.healthtracker.model.Drug;



public class  DrugAdapter   extends ListAdapter<String, DrugViewHolder> {
    public DrugAdapter() {
        super(new DiffUtil.ItemCallback<String>() {
            @Override
            public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                return false;
            }

            @Override
            public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                return false;
            }
        });
    }

    @NonNull
    @Override
    public DrugViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDrugBinding binding = ItemDrugBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new DrugViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DrugViewHolder holder, int position) {
        holder.setText(getItem(position));
    }

}

 class DrugViewHolder extends RecyclerView.ViewHolder {
     private final TextView textView;

    public DrugViewHolder(ItemDrugBinding binding) {
        super(binding.getRoot());
        textView = binding.nameTextView;
    }

    public void setText(String text) {
        textView.setText(text);
    }
}