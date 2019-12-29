package sinthy.animeworld;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Anime> dataSource;

    public ListAdapter(Context context, ArrayList<Anime> items) {
        this.context = context;
        dataSource = items;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataSource.indexOf(getItem(position));
    }

    private class ViewHolder {
        ImageView picture;
        TextView title;
        TextView description;
        TextView date;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();

            holder.picture = (ImageView) convertView.findViewById(R.id.image);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.description = (TextView) convertView.findViewById(R.id.description);
            holder.date = (TextView) convertView.findViewById(R.id.date);

            Anime item = dataSource.get(position);

            holder.picture.setImageResource(item.getPictureID());
            holder.title.setText(item.getTitle());
            holder.description.setText(item.getDescription());
            holder.date.setText(item.getDate());
        }

        return convertView;
    }
}