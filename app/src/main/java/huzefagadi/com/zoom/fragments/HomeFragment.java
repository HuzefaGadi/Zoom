package huzefagadi.com.zoom.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import huzefagadi.com.zoom.interfaces.OnFragmentInteractionListener;
import huzefagadi.com.zoom.R;


/**
 * A simple {@link Fragment} subclass.
 * activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 *
 */
public class HomeFragment extends Fragment {

    String [] tabs = new String[]{"Home","Chat","Videos","EBooks"};
    CollectionPagerAdapter mCollectionPagerAdapter;
    @BindView(R.id.pager)
    ViewPager mViewPager;

    @BindView(R.id.pager_tabs)
    TabLayout tabLayout;
    private OnFragmentInteractionListener mListener;

    public HomeFragment() {


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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        mCollectionPagerAdapter = new CollectionPagerAdapter(getActivity().getSupportFragmentManager());

        mViewPager.setAdapter(mCollectionPagerAdapter);

        tabLayout.setupWithViewPager(mViewPager);
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




    public class CollectionPagerAdapter extends FragmentStatePagerAdapter {
        public CollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;

            switch (i) {

                case 0:
                    fragment = new CoursesFragment();
                    return fragment;

                case 1:
                    fragment = new ChatFragment();
                    return fragment;

                case 2:
                    fragment = new EbooksFragment();
                    return fragment;

                case 3:
                    fragment = new VideosFragment();
                    return fragment;

                default:
                    return new CoursesFragment();
            }

        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return "Chat";
                case 2:
                    return "EBooks";
                case 3:
                    return "Videos";
                default:
                    return "Home";
            }
        }
    }

}
