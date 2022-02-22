package com.example.helloorganic;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin_page extends Fragment {
    DatabaseHelper databaseHelper;
    EditText edt1,edt2,edt3;
    Button btnsign;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_signin_page, container, false);
        edt1=v.findViewById(R.id.edt1);
        edt2=v.findViewById(R.id.edt2);
        edt3=v.findViewById(R.id.edt3);
        databaseHelper=new DatabaseHelper(getActivity());
        btnsign=v.findViewById(R.id.btnsignin);
     btnsign.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String username =edt1.getText().toString();
             String password=edt2.getText().toString();
             String confirm=edt3.getText().toString();
             if (username.equals("")||password.equals("")||confirm.equals(""))
             {
                 Toast.makeText(getActivity(), "Fields Requireds", Toast.LENGTH_SHORT).show();

             }
             else {

                 if (password.equals(confirm)){
                     Boolean checkname =databaseHelper.Checkusername(username);
                     if (checkname==true){
                         Boolean insert =databaseHelper.Insert(username,password);
                         if (insert==true){
                             Toast.makeText(getActivity(), "Registered", Toast.LENGTH_SHORT).show();
                             edt1.setText("");
                             edt2.setText("");
                             edt3.setText("");
                         }

                     }
                     else {
                         Toast.makeText(getActivity(), "Username Already Taken", Toast.LENGTH_SHORT).show();
                     }

                 }else {
                     Toast.makeText(getActivity(), "Password Dose Match", Toast.LENGTH_SHORT).show();
                 }
             }
         }

     });
        return v;
    }
}