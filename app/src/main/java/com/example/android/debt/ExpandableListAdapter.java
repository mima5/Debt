package com.example.android.debt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by EZEL on 2/16/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _ctx;
    private List<String> _listDataHeadar;  // header titles

    //Child data in format  of header title and child title
    private HashMap<String , List<Item>> _listDataChild;


    public ExpandableListAdapter(Context _ctx, List<String> listDataHeadar, HashMap<String, List<Item>> listDataChild) {
        this._ctx = _ctx;
        this._listDataHeadar = listDataHeadar;
        this._listDataChild = listDataChild;
    }








    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeadar.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        Item item = (Item) getChild(groupPosition , childPosition);

        LayoutInflater inflater = (LayoutInflater) this._ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_items,null);

        TextView textView = (TextView) convertView.findViewById(R.id.tv_item);
        textView.setText(item.name);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_add);
        imageView.setImageResource(item.imagURL);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeadar.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeadar.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeadar.size();
    }


    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headelTitle = (String) getGroup(groupPosition);

        LayoutInflater inflater = (LayoutInflater) this._ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_group,null);

        TextView textView = (TextView) convertView.findViewById(R.id.tv_lv_headar);
        textView.setText(headelTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    //----------------------




















}
