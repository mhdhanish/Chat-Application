package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chatapp.Fragments.CallFragment;
import com.example.chatapp.Fragments.ChatsFragment;
import com.example.chatapp.Fragments.StatusFragment;
import com.example.chatapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());


        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        Button btnChats = findViewById(R.id.btnChats);
        btnChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();


                fragmentManager.beginTransaction().
                        replace(R.id.fragmentContainerView3, ChatsFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        Button btncalls = findViewById(R.id.btnCalls);
        btncalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();


                fragmentManager.beginTransaction().
                        replace(R.id.fragmentContainerView3, CallFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        Button btnstatus = findViewById(R.id.btnStatus);
        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();


                fragmentManager.beginTransaction().
                        replace(R.id.fragmentContainerView3, StatusFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.settings:
                Toast.makeText(this, "Setting is clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.groupChat:
                Toast.makeText(this, "Group Chat is Started", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}