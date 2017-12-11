package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rrs27 on 2017-12-07.
 */

public class EarthquakeAdapter extends ArrayAdapter {

    /**
     * Class constructor.
     *
     * @param context - {@link Activity}
     * @param earthquakes - {@link List<Earthquake>}
     */
    public EarthquakeAdapter(Activity context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Provides a View for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item View.
     * @param convertView The recycled View to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing View is being reused, otherwise inflate the View
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake earthquake = (Earthquake) getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText(earthquake.getMagnitude());
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.magnitude);
        magnitudeCircle.setColor(magnitudeColor);

        TextView locationOffset = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffset.setText(earthquake.getLocationOffset());
        TextView location = (TextView) listItemView.findViewById(R.id.location);
        location.setText(earthquake.getLocation());

        TextView date_ = (TextView) listItemView.findViewById(R.id.date_);
        date_.setText(earthquake.getDate());
        TextView time_ = (TextView) listItemView.findViewById(R.id.time_);
        time_.setText(earthquake.getTime());

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeRoundedDown = (int) Math.floor(magnitude);
        int newColor = 0;

        switch (magnitudeRoundedDown){
            case 0:
            case 1:
                newColor = R.color.magnitude1;
                break;
            case 2:
                newColor = R.color.magnitude2;
                break;
            case 3:
                newColor = R.color.magnitude3;
                break;
            case 4:
                newColor = R.color.magnitude4;
                break;
            case 5:
                newColor = R.color.magnitude5;
                break;
            case 6:
                newColor = R.color.magnitude6;
                break;
            case 7:
                newColor = R.color.magnitude7;
                break;
            case 8:
                newColor = R.color.magnitude8;
                break;
            case 9:
                newColor = R.color.magnitude9;
                break;
            case 10:
            default:
                newColor = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),newColor);
    }


}
