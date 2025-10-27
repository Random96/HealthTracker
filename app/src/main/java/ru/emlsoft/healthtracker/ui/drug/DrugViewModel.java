package ru.emlsoft.healthtracker.ui.drug;

import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ru.emlsoft.healthtracker.model.HealthSQLiteHelper;

public class DrugViewModel extends ViewModel {
    private final MutableLiveData<List<String>> mDrugs;

    public DrugViewModel() {
        mDrugs = new MutableLiveData<>();

        // SQLiteDatabase database = new HealthSQLiteHelper(this).getReadableDatabase();
        List<String> texts = new ArrayList<>();
        texts.add("Анальгин");
        texts.add("Аспирин");
        mDrugs.setValue(texts);
    }

    public LiveData<List<String>> getDrugs() {
        return mDrugs;
    }
}
