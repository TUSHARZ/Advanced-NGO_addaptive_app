package com.example.tushar.bro.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tushar.bro.R;
import com.example.tushar.bro.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Brother_details extends BaseFragment {
    @BindView(R.id.brother_details_image)
    ImageView image;
    @BindView(R.id.brother_details_progress)
    ProgressBar progressBar;
    @BindView(R.id.brother_details_name)
    TextView name;
    @BindView(R.id.brother_details_major)
    TextView major;
    @BindView(R.id.brother_details_crossed)
    TextView crossed;
    @BindView(R.id.brother_details_fact)
    TextView fact;
    @BindView(R.id.brother_details_joined)
    TextView joined;

    private Brother brother;
    public static final String BrotherClicked="Clicked";

    public Brother_details() {
        // Required empty public constructor
    }
    public static Brother_details newInstance(Brother brother){
        Bundle bundle=new Bundle();
        bundle.putParcelable(BrotherClicked,brother);
        Brother_details brother_details=new Brother_details();
        brother_details.setArguments(bundle);
        return brother_details;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        brother=getArguments().getParcelable(BrotherClicked);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_brother_details, container, false);
        ButterKnife.bind(this,v);
        name.setText(brother.getBrotherName());
        major.setText(brother.getBrothermajor());
        crossed.setText(brother.getBrotherCrossSemester());
        fact.setText(brother.getBrotherFunFact());
        joined.setText(brother.getBrotherwhyJoin());

        Picasso.with(Brother_details.this.getActivity()).load(brother.getBrotherPicture()).into(image, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });





        return v;
    }

}
