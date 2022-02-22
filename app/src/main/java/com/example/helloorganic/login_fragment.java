package com.example.helloorganic;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_fragment extends Fragment {
    Button button;
    EditText editText,editText2;
    DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_login_fragment, container, false);
        button=v.findViewById(R.id.btnlogin);
        editText=v.findViewById(R.id.edt4);
        editText2=v.findViewById(R.id.edt5);
        databaseHelper=new DatabaseHelper(getActivity());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=editText.getText().toString();
                String password=editText2.getText().toString();
                Boolean checklogin=databaseHelper.checklogin(username,password);
                if (checklogin==true){
                    Intent intent=new Intent(getActivity(),Dashboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "Invalid username Password", Toast.LENGTH_SHORT).show();
                }
            }

        });
        return v;
    }
}