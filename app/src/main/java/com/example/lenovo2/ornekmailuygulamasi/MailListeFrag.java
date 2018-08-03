package com.example.lenovo2.ornekmailuygulamasi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MailListeFrag extends ListFragment {
    private boolean ekran_yataymi;
    private MailIcerikFrag mailIcerikFrag;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] mail_liste=getActivity().getResources().getStringArray(R.array.mail_liste);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,mail_liste);

        setListAdapter(adapter);

        FrameLayout container =(FrameLayout)getActivity().findViewById(R.id.icerik_fragment);

        ekran_yataymi=container!=null && container.getVisibility()== View.VISIBLE;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        //Log.d("pozisyon", ""+position);
        super.onListItemClick(l, v, position, id);



        if(ekran_yataymi){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            mailIcerikFrag=(MailIcerikFrag) getFragmentManager().findFragmentById(R.id.icerik_fragment);

            if (mailIcerikFrag==null || mailIcerikFrag.getPozisyon()!=position){
                mailIcerikFrag=new MailIcerikFrag(position);
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.icerik_fragment,mailIcerikFrag);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.commit();
            }
        }
        else {
            Intent intent=new Intent(getActivity(), ActivityIcerik.class);
            intent.putExtra("pozisyon",position);
            startActivity(intent);

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mailIcerikFrag != null){
            FragmentTransaction transaction=getFragmentManager().beginTransaction();
            transaction.remove(mailIcerikFrag);
            transaction.commit();
        }
    }
}
