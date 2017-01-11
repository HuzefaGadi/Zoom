package huzefagadi.com.zoom.fragments;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import huzefagadi.com.zoom.utilities.Constants;
import huzefagadi.com.zoom.utilities.DividerItemDecoration;
import huzefagadi.com.zoom.R;
import huzefagadi.com.zoom.adapters.VideosListAdapter;
import huzefagadi.com.zoom.interfaces.OnFragmentInteractionListener;

/**
 * A simple {@link Fragment} subclass.
 * activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class VideosListFragment extends Fragment {

    YouTubePlayerSupportFragment youTubePlayerSupportFragment;
    //s6Qzy4vtldk

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    VideosListAdapter videosListAdapter;

    private OnFragmentInteractionListener mListener;

    public VideosListFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videos_list, container, false);
        ButterKnife.bind(this, view);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(20));

        // specify an adapter (see also next example)
        videosListAdapter = new VideosListAdapter(new Constants().getVideoList(),getActivity(), this);
        mRecyclerView.setAdapter(videosListAdapter);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
