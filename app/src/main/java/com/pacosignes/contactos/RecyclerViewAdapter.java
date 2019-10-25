package com.pacosignes.contactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder> {

    private Contact[] contacts;
    private Context context;
    private IOnContactListener listener;

    public RecyclerViewAdapter(Fragment fragment, Contact[] data,IOnContactListener listener){
        this.contacts=data;
        this.context=fragment.getContext();
        this.listener=listener;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_contacto,parent,false);
        return new ContactViewHolder(view,context,listener);


    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contact contact=contacts[position];
        holder.bindContact(contact,position);


    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvNameList;
        private TextView tvPhone1List;
        Context context;
        private IOnContactListener listener;
        private int position;


        public ContactViewHolder(View itemView, Context context, IOnContactListener listener){
            super(itemView);
            this.context=context;

            tvNameList= (TextView) itemView.findViewById(R.id.tvNameList);
            tvPhone1List= (TextView) itemView.findViewById(R.id.tvPhoneList);
            this.listener=listener;

            itemView.setOnClickListener(this);
        }
        public void bindContact(Contact contact, int position){
            tvNameList.setText(contact.getName());
            tvPhone1List.setText(contact.getPhone1());
            this.position=position;
        }

        @Override
        public void onClick(View v) {

            listener.onContactClick(contacts[position]);
        }
    }


    public interface IOnContactListener{
        void onContactClick(Contact c);
    }
}
