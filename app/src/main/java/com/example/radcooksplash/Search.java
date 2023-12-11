package com.example.radcooksplash;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radcooksplash.Adapter.FoodListAdapter;
import com.example.radcooksplash.Domain.FoodDomain;
import com.example.radcooksplash.R;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
private RecyclerView.Adapter adapterFoodList;
private RecyclerView recyclerViewFood;
@Override
    protected void onCreate(Bundle saveInstanceState){
    super.onCreate(saveInstanceState);
    setContentView(R.layout.activity_search);

    initRecyclerview();
}

    private void initRecyclerview() {
        ArrayList<FoodDomain> items=new ArrayList<>();
        items.add(new FoodDomain("Pasta Boloñesa", "La salsa boloñesa auténtica es una salsa muy fácil de hacer pero requiere tiempo y es algo laboriosa, ya que necesita una larga cocción.", "fast_1",15,30,15,5));
        items.add(new FoodDomain("Arroz Paisa", "Colombiana, Cuenta con carne, así como verduras y se corona con plátano frito. Por lo que la combinación de sabores estará a la orden del día.", "fast_2",10,40,12,4));
        items.add(new FoodDomain("Ensalada Vegetales", "Esta ensalada fresca de judías verdes es una propuesta ligera para entrantes y cenas", "fast_3",13,10,4,4.5));

        recyclerViewFood=findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        adapterFoodList=new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);
    }


}
