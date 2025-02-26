package de.baumann.browser.view;

import android.content.Context;
import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import de.baumann.browser.R;

public class ProfilesListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final int layoutResId;
    private final List<String> list;

    public ProfilesListAdapter(Context context, List<String> list){
        super(context, R.layout.item_icon_right, list);
        this.context = context;
        this.layoutResId = R.layout.item_icon_right;
        this.list = list;
    }

    private static class Holder {
        TextView domain;
    }

    @SuppressWarnings("NullableProblems")
    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        Holder holder;
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(layoutResId, parent, false);
            holder = new Holder();
            holder.domain = view.findViewById(R.id.whitelist_item_domain);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        holder.domain.setText(list.get(position));
        return view;
    }
}
