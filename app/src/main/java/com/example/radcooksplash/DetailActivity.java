package com.example.radcooksplash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.radcooksplash.Domain.FoodDomain;
import com.example.radcooksplash.Helper.ManagmentCart;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTxt,feeTxt, descriptionTxt, startTxt, timeTxt;
    private ImageView picFood;
    private FoodDomain object;
  private ManagmentCart managmentCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managmentCart =new ManagmentCart(DetailActivity.this);
        initView();
        getBundle();
    }
    private void getBundle(){
        object=(FoodDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("Calificación"+object.getPrice());
        descriptionTxt.setText(object.getDescription());
        startTxt.setText(object.getScore()+"");
        timeTxt.setText(object.getTime()+ "min");
    }

    private void initView() {
         timeTxt=findViewById(R.id.timeTxt);
          feeTxt=findViewById(R.id.priceTxt);
          titleTxt=findViewById(R.id.titleTxt);
           descriptionTxt=findViewById(R.id.descriptionTxt);
              picFood=findViewById(R.id.foodPic);
              startTxt=findViewById(R.id.StarTxt);
    }
}