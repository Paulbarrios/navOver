package com.example.navover;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentPerfil extends Fragment{
	

	
	@Override
    public View onCreateView(
        LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_perfil, container, false);
		
		
	    
        
        return v;
    }
}