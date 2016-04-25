package com.dcv3.admin;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by dezereljones on 4/25/16.
 */
public class CurrentOrderFragment extends Fragment {
    ListView listView;
    ParseQueryAdapter<ParseObject> mainAdapter;
    String restId;

    public CurrentOrderFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.currentorder_fragment, container, false);
        //restId =getArguments().getString("id");


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

        //Toast.makeText(getActivity(), restId, Toast.LENGTH_LONG).show();
        return v;
    }
}
