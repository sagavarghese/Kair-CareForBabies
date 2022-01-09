package com.example.kair_careforbabies.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.kair_careforbabies.HomeActivity;
import com.example.kair_careforbabies.MainActivity;
import com.example.kair_careforbabies.R;

public class CategoryAdminActivity extends AppCompatActivity {
    private ImageView girldress, boydress, girlshoes, boyshoes;
    private ImageView blanket, diaper, bath, books;
    private ImageView strollers, carseats, safety, toys;
    private Button LogoutBtn, CheckOrdersBtn, maintainProductsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_admin);

        girldress = (ImageView) findViewById(R.id.girl_dresses);
         boydress = (ImageView) findViewById(R.id.boy_dresses);
        girlshoes = (ImageView) findViewById(R.id.boy_shoes);
        boyshoes = (ImageView) findViewById(R.id.girl_shoes);

        blanket = (ImageView) findViewById(R.id.baby_blankets);
        diaper = (ImageView) findViewById(R.id.baby_diapers);
        bath = (ImageView) findViewById(R.id.bath_acessories);
        books = (ImageView) findViewById(R.id.baby_books);

        strollers = (ImageView) findViewById(R.id.strollers);
        carseats = (ImageView) findViewById(R.id.car_seats);
        safety = (ImageView) findViewById(R.id.safety);
        toys = (ImageView) findViewById(R.id.toys);

        LogoutBtn = (Button) findViewById(R.id.admin_logout_btn);
        CheckOrdersBtn = (Button) findViewById(R.id.check_orders_btn);
        maintainProductsBtn = (Button) findViewById(R.id.maintain_btn);



        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });


        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        CheckOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
//                Intent intent = new Intent(CategoryAdminActivity.this, AdminNewOrdersActivity.class);
//                startActivity(intent);
            }
        });

        girldress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "girldress");
                startActivity(intent);
            }
        });


        boydress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "boydress");
                startActivity(intent);
            }
        });


        girlshoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "girlshoes");
                startActivity(intent);
            }
        });


        boyshoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "boyshoes");
                startActivity(intent);
            }
        });


        blanket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category","blanket");
                startActivity(intent);
            }
        });


        diaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "diaper");
                startActivity(intent);
            }
        });



        bath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "bath");
                startActivity(intent);
            }
        });


        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "books");
                startActivity(intent);
            }
        });



        strollers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "strollers");
                startActivity(intent);
            }
        });


        carseats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "carseats");
                startActivity(intent);
            }
        });


        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "safety");
                startActivity(intent);
            }
        });


        toys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryAdminActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "toys");
                startActivity(intent);
            }
        });


    }


}
