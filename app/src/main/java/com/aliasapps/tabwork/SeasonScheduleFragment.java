package com.aliasapps.tabwork;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Date;


public class SeasonScheduleFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    String param1, param2;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapter;

    public SeasonScheduleFragment() {
        // Required empty public constructor
    }

    public static SeasonScheduleFragment newInstance(String param1, String param2) {
        SeasonScheduleFragment fragment = new SeasonScheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString(ARG_PARAM1);
            param2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //view pager setup
        viewPager = view.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(1);

        //tab layout setup
        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //adapter setup
        adapter = new ViewPagerAdapter(getFragmentManager());

        adapter.addFrag(SeasonGameListFragment.newInstance(new Date().toString()), new Date().toString());

        for(int i = 0; i < 3000; i++){Log.d("Mike", i+"");}//make the program wait a bit
        adapter.addFrag(SeasonGameListFragment.newInstance(new Date().toString()), new Date().toString());

        for(int i = 0; i < 3000; i++){Log.d("Mike", i+"");}//make the program wait a bit
        adapter.addFrag(SeasonGameListFragment.newInstance(new Date().toString()), new Date().toString());

        viewPager.setAdapter(adapter);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addFrag(SeasonGameListFragment.newInstance(new Date().toString()), new Date().toString());
            }
        });

        Button remove = view.findViewById(R.id.remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.removeFrag(tabLayout.getSelectedTabPosition());
            }
        });

        return view;
    }
}
