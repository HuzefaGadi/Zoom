package huzefagadi.com.zoom.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import butterknife.BindView;
import butterknife.ButterKnife;
import huzefagadi.com.zoom.R;
import huzefagadi.com.zoom.adapters.GridViewAdapter;
import huzefagadi.com.zoom.interfaces.OnFragmentInteractionListener;


/**
 * A simple {@link Fragment} subclass.
 * activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EbooksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EbooksFragment extends Fragment {
    @BindView(R.id.grid_view_home)
    GridView gridView;

    private OnFragmentInteractionListener mListener;

    public EbooksFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the grid_card for this fragment
        View view = inflater.inflate(R.layout.fragment_ebooks, container, false);
        ButterKnife.bind(this,view);
        gridView.setAdapter(new GridViewAdapter(getActivity(), this, "EbooksFragment"));
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String buttonName) {
        if (mListener != null) {
            mListener.onButtonPressed(this.getClass().getName(),buttonName);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
