package com.datamining.arole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static final Double MIN_SUPPORT = 0.3;
    Set<String> hashData = new HashSet<>();
    List<Model> dataAll = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[][] data = {{"roti","selai","mentega"},{"roti","mentega"},{"roti","susu","mentega"},{"coklat","roti"},{"coklat","susu"}};

        for (String[] datum : data) {
            for (String s : datum) {
                hashData.add(s);
            }
        }

        for (String hashDatum : hashData) {
            dataAll.add(new Model(hashDatum));
        }

        int i=0;
        for(Model m : dataAll) {
            float sup = 0;
            for (String[] datum : data) {
                for (String s : datum) {
                    if(m.getBarang().equals(s)){
                        sup++;
                    }
                }
            }
            Log.d("SUPPORT",""+sup);
            m.setSupport(sup/dataAll.size());
            dataAll.set(i,m);
            i++;
        }

        int j=0;
        for(Model m : dataAll) {
            for (String[] datum : data) {
                for (String s : datum) {
                    if(m.getSupport()<MIN_SUPPORT){
                        dataAll.remove(j);
                    }
                }
            }
            j++;
        }

        for (Model model : dataAll) {
            Log.d("DATA",model.getBarang() + " : "+model.getSupport());
        }
    }
}
