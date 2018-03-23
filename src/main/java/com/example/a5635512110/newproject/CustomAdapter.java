package com.example.a5635512110.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 5635512110 on 3/23/2018.
 */

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    String[] strName;
    int[] resId;
    View view;

    // initial value for adapter
    // get context from activity
    // strName => text items,  resId => image items (drawable)
    public CustomAdapter(Context context, String[] strName, int[] resId) {
        this.mContext= context;
        this.strName = strName;
        this.resId = resId;
    }

    @Override
    public int getCount() {
        return strName.length;
    }

    @Override
    public Object getItem(int position) {
        return strName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //  get inflater เป็นตัวเป่า view ที่จะแปะใน list
        LayoutInflater mInflater =
                (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // use inflate to create list view layout (from listview_row.xml)

        if(view == null)
            view = mInflater.inflate(R.layout.listview_row, parent, false);

        // initial value for UI component in listview
        TextView textView = (TextView)view.findViewById(R.id.textView1);
        textView.setText(strName[position]);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView1);
        imageView.setBackgroundResource(resId[position]);

        return view;
    }
}
