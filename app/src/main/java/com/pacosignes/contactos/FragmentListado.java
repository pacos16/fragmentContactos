package com.pacosignes.contactos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class FragmentListado extends Fragment {
    private RecyclerViewAdapter.IOnContactListener listener;
    private RecyclerView rvList;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_listado,container,false);

    }

    public void onActivityCreated(@Nullable Bundle savedInstance){
        super.onActivityCreated(savedInstance);
        rvList= (RecyclerView)getView().findViewById(R.id.rvList);
        ContactParser parser=new ContactParser(this.getActivity());
        parser.parse();

        listener= ((MainActivity) getActivity()).giveListener();

        rvList.setAdapter(new RecyclerViewAdapter(this,parser.getContacts(),listener));
        rvList.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    public void setIContactListener(RecyclerViewAdapter.IOnContactListener listener){
        this.listener=listener;
    }

}
