package com.dcv3.admin;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by dezereljones on 4/25/16.
 */
public class CurrentOrderFragment extends Fragment {
    ListView listView;
    boolean clicked = false;
    ParseQueryAdapter<ParseObject> mainAdapter;
    String restId;
    String orderId;
    Button deleteButton;
    ParseObject obj;

    public CurrentOrderFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.currentorder_fragment, container, false);
        deleteButton = (Button) v.findViewById(R.id.deleteButton);
        // Initialize main ParseQueryAdapter
        mainAdapter = new ParseQueryAdapter<ParseObject>(getActivity(), new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery<ParseObject> create() {
                // query to gets orders for selected restaurant
                ParseQuery<ParseObject> query = new ParseQuery<>("Orders");
                query.whereEqualTo("restNo", "tdiv82Fxqx");
                query.whereEqualTo("isTracking", true);

                return query;
            }
        });

        mainAdapter.setTextKey("orderNo");


        listView = (ListView) v.findViewById(R.id.list);
        listView.setAdapter(mainAdapter);
        mainAdapter.loadObjects();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                clicked = true;
                //Getting the name of each item selected
                obj = mainAdapter.getItem(position);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View popupView) {
                obj.deleteInBackground();
            }
        });

        return v;
    }
}
