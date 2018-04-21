package yoenas.co.id.youtubeapiplusadmob.adapter;

import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import yoenas.co.id.youtubeapiplusadmob.R;
import yoenas.co.id.youtubeapiplusadmob.responseServer.ItemsItem;
import yoenas.co.id.youtubeapiplusadmob.youtube.FullscreenDemoActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ItemsItem> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvJudul, tvChannel, tvTanggal;
        ImageView img;

        public ViewHolder(View v) {
            super(v);
//            mTextView = v;
            tvJudul = v.findViewById(R.id.textJudul);
            tvChannel = v.findViewById(R.id.textChannel);
            tvTanggal = v.findViewById(R.id.textTanggal);
            img = v.findViewById(R.id.itemImage);

        }

        public void bind(final ItemsItem itemsItem) {
            tvJudul.setText(itemsItem.getSnippet().getTitle());
            tvChannel.setText(itemsItem.getSnippet().getChannelTitle());
            tvTanggal.setText(itemsItem.getSnippet().getPublishedAt());
            Picasso.get().load(itemsItem.getSnippet().getThumbnails().getHigh().getUrl()).into(img);

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(itemView.getContext(), FullscreenDemoActivity.class);
                    intent.putExtra("video",itemsItem.getId().getVideoId());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<ItemsItem> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mTextView.setText(mDataset[position]);

        holder.bind(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
