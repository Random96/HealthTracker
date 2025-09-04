package ru.emlsoft.healthtracker.ui.drug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.emlsoft.healthtracker.databinding.FragmentDrugBinding;

public class DrugFragment extends Fragment {

    private FragmentDrugBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DrugViewModel drugViewModel =
                new ViewModelProvider(this).get(DrugViewModel.class);

        binding = FragmentDrugBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDrug;
        drugViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
