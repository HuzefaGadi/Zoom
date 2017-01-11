package huzefagadi.com.zoom.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import huzefagadi.com.zoom.R;
import huzefagadi.com.zoom.activities.MainActivity;
import huzefagadi.com.zoom.beans.EbookBean;
import huzefagadi.com.zoom.fragments.EbookDetailsFragment;
import huzefagadi.com.zoom.fragments.EbooksListFragment;
import huzefagadi.com.zoom.fragments.VideoDetailsFragment;

/**
 * Created by Rashida on 04/01/17.
 */
public class EbooksListAdapter extends RecyclerView.Adapter<EbooksListAdapter.ViewHolder> {
    private List <EbookBean> ebookList;
    private Context context;
    private Fragment fromFragment;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        @BindView(R.id.ebookTitle)
        TextView ebookTitle;
        @BindView(R.id.ebookThumbnail)
        ImageView ebookThumbnail;
        @BindView(R.id.card_view)
        CardView cardView;
        public ViewHolder(View view) {

            super(view);
            ButterKnife.bind(this, view);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public EbooksListAdapter(List<EbookBean> ebookList, Context context, Fragment fromFragment) {
        this.ebookList = ebookList;
        this.context = context;
        this.fromFragment = fromFragment;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public EbooksListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View v = null;
        if(fromFragment instanceof EbooksListFragment)
        {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.ebook_row_view, parent, false);
        }
        else if(fromFragment instanceof VideoDetailsFragment)
        {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.video_row_details_view, parent, false);
        }


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final EbookBean ebookBean = ebookList.get(position);
        final String title = ebookBean.getTitle();
        Picasso.with(context)
                .load(ebookBean.getThumbnailUrl())
                //  .resize(holder.ebookThumbnail.getWidth(),400)
                //.placeholder(R.drawable.slider_image)
                //.error(R.drawable.slider_image)
                .into(holder.ebookThumbnail);
        holder.ebookTitle.setText(ebookBean.getTitle());
        holder.ebookThumbnail.setTag(ebookBean.getUrl());
        holder.ebookThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fromFragment instanceof EbookDetailsFragment) {

                } else if (fromFragment instanceof EbooksListFragment) {
                    ((MainActivity) context).onButtonPressed(EbooksListFragment.class.getName(), ebookBean.getUrl());
                }

            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return ebookList.size();
    }
}


