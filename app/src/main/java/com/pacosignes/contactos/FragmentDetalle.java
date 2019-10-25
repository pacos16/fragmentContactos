package com.pacosignes.contactos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetalle extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle,container,false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView tvName=getView().findViewById(R.id.tvName);
        TextView tvSurname=getView().findViewById(R.id.tvSurname);
        TextView tvAddress=getView().findViewById(R.id.tvAddress);
        TextView tvCompany=getView().findViewById(R.id.tvCompany);
        Contact c= (Contact) this.getActivity().getIntent().getSerializableExtra("holo");

        tvName.setText(c.getName());
        tvSurname.setText(c.getFirstSurname()+" "+c.getSecondSurname());
        tvAddress.setText(c.getAdress());
        tvCompany.setText(c.getCompany());
    }
}
