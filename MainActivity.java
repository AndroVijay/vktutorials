package com.example.vijay.frademo;

import android.nfc.Tag;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private  static  final String TAG="ACTIVITY LIFECYCLE";
    private static  final String ACTIVITY_NAME=MainActivity.class.getSimpleName();
    private Button button;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();

        button=findViewById(R.id.addNewFragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addFragment();
            }
        });


        Log.d(TAG,ACTIVITY_NAME+"onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,ACTIVITY_NAME+"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,ACTIVITY_NAME+"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,ACTIVITY_NAME+"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,ACTIVITY_NAME+"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,ACTIVITY_NAME+"onDestroy");
    }

    private void addFragment()
    {
        Fragment fragment;
       /* switch (fragmentManager.getBackStackEntryCount())
        {
            case 0:fragment=new SampleFragment();break;
            case 1:fragment=new FragmentTwo();break;
            case 2:fragment=new FragmentThree();break;
            default:fragment=new SampleFragment();break;
        }*/

       fragment=fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment instanceof SampleFragment)
        {
            fragment=new FragmentTwo();

        }else if (fragment instanceof FragmentTwo)
        {
            fragment=new FragmentThree();

        }else if (fragment instanceof FragmentThree){

            fragment=new SampleFragment();

        }else {

            fragment=new SampleFragment();
        }
        transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer,fragment,"demofragment");
        transaction.addToBackStack("Add"+fragment.toString());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {

        Fragment fragment=fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment!=null)
        {
            transaction=fragmentManager.beginTransaction();
            transaction.remove(fragment);
            transaction.addToBackStack("Remove"+fragment.toString());
            transaction.commit();
        }else {

            super.onBackPressed();

        }

    }
}
