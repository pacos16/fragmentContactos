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
    public RecyclerViewAdapter(Fragment fragment, Contact[] data){
        this.contacts=data;
        this.context=fragment.getContext();
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_contacto,parent,false);
        return new ContactViewHolder(view,context);


    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contact contact=contacts[position];
        holder.bindContact(contact);

    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNameList;
        private TextView tvPhone1List;
        Context context;

        public ContactViewHolder(View itemView, Context context){
            super(itemView);
            this.context=context;

            tvNameList= (TextView) itemView.findViewById(R.id.tvNameList);
            tvPhone1List= (TextView) itemView.findViewById(R.id.tvPhoneList);
        }
        public void bindContact(Contact contact){
            tvNameList.setText(contact.getName());
            tvPhone1List.setText(contact.getPhone1());
        }

    }
}
