package com.example.vijay.frademo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vijay on 06-01-2018.
 */

public class SampleFragment extends Fragment {


    private  static  final String TAG="FRAGMENT LIFECYCLE";
    private static  final String FRAGMENT_NAME=SampleFragment.class.getSimpleName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,FRAGMENT_NAME+"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,FRAGMENT_NAME+"onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,FRAGMENT_NAME+"onCreateView");
        return inflater.inflate(R.layout.fragment_sample,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,FRAGMENT_NAME+"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,FRAGMENT_NAME+"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,FRAGMENT_NAME+"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,FRAGMENT_NAME+"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,FRAGMENT_NAME+"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,FRAGMENT_NAME+"onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,FRAGMENT_NAME+"onDetach");
    }
}
