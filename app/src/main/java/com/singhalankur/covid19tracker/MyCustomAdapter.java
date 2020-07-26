package com.singhalankur.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<ModelCountry> {

    private Context context;
    private List<ModelCountry> modelCountryList;
    private List<ModelCountry> modelCountryListFiltered;

    public MyCustomAdapter(Context context, List<ModelCountry> modelCountryList) {
        super(context, R.layout.list_custom_item, modelCountryList);

        this.context = context;
        this.modelCountryList = modelCountryList;
        this.modelCountryListFiltered = modelCountryList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item, null, true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        tvCountryName.setText(modelCountryListFiltered.get(position).getCountry());
        Glide.with(context).load(modelCountryListFiltered.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return modelCountryListFiltered.size();
    }

    @Nullable
    @Override
    public ModelCountry getItem(int position) {
        return modelCountryListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = modelCountryList.size();
                    filterResults.values = modelCountryList;

                } else {
                    List<ModelCountry> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (ModelCountry itemsModel : modelCountryList) {
                        if (itemsModel.getCountry().toLowerCase().contains(searchStr)) {
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                modelCountryListFiltered = (List<ModelCountry>) results.values;
                AffectedCountries.modelCountryList = (List<ModelCountry>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }

}
