package com.example.resty.lrucachesample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Resty on 12/15/2016.
 */

public class SampleAdapter extends BaseAdapter {

    private Context context;
    private List<SampleObject> values;

    public SampleAdapter(Context context, List<SampleObject> values) {
        this.context = context;
        this.values = values;
    }

    public void setValues(List<SampleObject> values) {
        this.values = values;
    }

    public List<SampleObject> getValues() {
        return values;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_layout, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        //TextView message = (TextView) convertView.findViewById(R.id.message);

        title.setText(values.get(position).getTitle());
        //message.setText(values.get(position).getMessage());

        return convertView;
    }
}
