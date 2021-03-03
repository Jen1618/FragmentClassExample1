package com.example.fragmentexample;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Button button_fragmentOne, button_fragmentTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_fragmentOne = findViewById(R.id.button_one);
        button_fragmentTwo = findViewById(R.id.button_two);

        button_fragmentOne.setOnClickListener(v -> loadFragment(new FragmentFirst()));
        button_fragmentTwo.setOnClickListener(v -> loadFragment(new FragmentSecond()));
    }

    //based on the navigation components (aka buttons)
    // I will decide which fragment to load into the fragment placeholder
    public void loadFragment(Fragment fragment){
        //Fragment Manager
        // API 28 -> accessibility if this manager
        // before API 28, getFragmentManager()
        // after API 28, getSupportFragmentManager()

        //create a fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainerView with the fragment that is passed as parameter
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
        
    }
}