package com.example.lenovo2.ornekmailuygulamasi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

public class MailListeFrag extends ListFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] mail_liste=getActivity().getResources().getStringArray(R.array.mail_liste);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,mail_liste);

        setListAdapter(adapter);
    }
}
