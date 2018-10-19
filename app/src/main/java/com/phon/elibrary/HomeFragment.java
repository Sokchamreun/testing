package com.phon.elibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HomeFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentLayout = inflater.inflate(R.layout.fragment_home, container, false);
        return fragmentLayout;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnClickMe = view.findViewById(R.id.btn_click_me);
        btnClickMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "You click me!", Toast.LENGTH_LONG).show();
    }
}
