package com.aliasapps.tabwork;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SeasonGameListFragment extends Fragment {

    String dateString;

    public SeasonGameListFragment() {
        // Required empty public constructor
    }

    //we pass in the same date as the tabs
    public static SeasonGameListFragment newInstance(String date) {
        SeasonGameListFragment fragment = new SeasonGameListFragment();
        Bundle args = new Bundle();
        args.putString("date", date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            dateString = getArguments().getString("date");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_content, container, false);

        TextView date = view.findViewById(R.id.time);
        date.setText(dateString);

        return view;
    }
}
