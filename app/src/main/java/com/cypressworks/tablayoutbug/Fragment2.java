package com.cypressworks.tablayoutbug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressWarnings("ConstantConditions")
public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ViewPager pager = (ViewPager) getView().findViewById(R.id.pager);
        TabLayout tabs = (TabLayout) getView().findViewById(R.id.tabs);

        pager.setAdapter(new PagerAdapter());
        tabs.setupWithViewPager(pager);
    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter() {
            super(getChildFragmentManager());
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Fragment getItem(final int position) {
            PagerFragment frag = new PagerFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", getPageTitle(position).toString());
            frag.setArguments(bundle);
            return frag;
        }

        @Override
        public CharSequence getPageTitle(final int position) {
            return "Page " + position;
        }
    }
}
