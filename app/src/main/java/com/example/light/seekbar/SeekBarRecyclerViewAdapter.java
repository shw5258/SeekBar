package com.example.light.seekbar;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.light.seekbar.SeekBarFragment.OnListFragmentInteractionListener;
import com.example.light.seekbar.dummy.DummyContent.DummyItem;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.List;

public class SeekBarRecyclerViewAdapter extends RecyclerView.Adapter<SeekBarRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public SeekBarRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_seekbar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mLeftTaste.setText(mValues.get(position).leftTaste);
        holder.mRightTaste.setText(mValues.get(position).rightTaste);

        //이부분에다가 어떠한 listener든지 다 붙일 수 있다. seekbar에도 붙이고
        //check 에도 붙이고 다 붙여보자..
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

        holder.mSeekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mLeftTaste;
        public final TextView mRightTaste;
        public final DiscreteSeekBar mSeekBar;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mLeftTaste = (TextView) view.findViewById(R.id.leftTaste);
            mRightTaste = (TextView) view.findViewById(R.id.rightTaste);
            mSeekBar = (DiscreteSeekBar) view.findViewById(R.id.seek1);
        }
    }
}
