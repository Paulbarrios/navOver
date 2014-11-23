package com.example.navover;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

public class FragmentLista extends Fragment{
	
	@Override
    public View onCreateView(
    		LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    		View v = inflater.inflate(R.layout.fragment_list, container, false);
    		
    		Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar2);
            getActivity().setActionBar(toolbar);
    	    
            return v;
    }
}
