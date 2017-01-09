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
import huzefagadi.com.zoom.MainActivity;
import huzefagadi.com.zoom.R;
import huzefagadi.com.zoom.VideoBean;
import huzefagadi.com.zoom.fragments.VideoDetailsFragment;
import huzefagadi.com.zoom.fragments.VideosListFragment;

/**
 * Created by Rashida on 04/01/17.
 */
public class VideosListAdapter extends RecyclerView.Adapter<VideosListAdapter.ViewHolder> {
    private List <VideoBean> videoList;
    private Context context;
    private Fragment fromFragment;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        @BindView(R.id.videoTitle)
        TextView videoTitle;
        @BindView(R.id.videoThumbnail)
        ImageView videoThumbnail;
        @BindView(R.id.card_view)
        CardView cardView;
        public ViewHolder(View view) {

            super(view);
            ButterKnife.bind(this, view);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VideosListAdapter(List<VideoBean> videoList, Context context,Fragment fromFragment) {
        this.videoList = videoList;
        this.context = context;
        this.fromFragment = fromFragment;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public VideosListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = null;
        if(fromFragment instanceof VideosListFragment)
        {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.video_row_view, parent, false);
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
        VideoBean videoBean = videoList.get(position);
        final String title = videoBean.getVideoTitle();
        Picasso.with(context)
                .load("https://img.youtube.com/vi/"+videoBean.getVideoId()+"/hqdefault.jpg")
              //  .resize(holder.videoThumbnail.getWidth(),400)
                //.placeholder(R.drawable.slider_image)
                //.error(R.drawable.slider_image)
                .into(holder.videoThumbnail);
        holder.videoTitle.setText(videoBean.getVideoTitle());
        holder.videoThumbnail.setTag(videoBean.getVideoId());
        holder.videoThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fromFragment instanceof VideoDetailsFragment) {
                    VideoDetailsFragment videoDetailsFragment = (VideoDetailsFragment) fromFragment;
                    videoDetailsFragment.onVideoSelected(String.valueOf(view.getTag()));
                } else if (fromFragment instanceof VideosListFragment) {
                    ((MainActivity) context).onButtonPressed(VideosListFragment.class.getName(), title);
                }

            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return videoList.size();
    }
}


