package com.ninefilta.ingnine;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    ImageView feedBtn;
    ImageView searchBtn;
    ImageView cameraBtn;
    ImageView portfolioBtn;
    ImageView myBtn;

    FragmentTransaction transaction;
    FeedFragment feedFragment;
    PortfolioFragment portfolioFragment;
    MyFragment myFragment;
    SearchFragment searchFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCustomActionBar();

        feedBtn = (ImageView) findViewById(R.id.feed_btn);
        searchBtn = (ImageView) findViewById(R.id.searchbtn);
        cameraBtn = (ImageView) findViewById(R.id.cameraBtn);
        portfolioBtn = (ImageView) findViewById(R.id.portfoliobtn);
        myBtn = (ImageView) findViewById(R.id.mybtn);


        feedFragment = new FeedFragment();
        portfolioFragment = new PortfolioFragment();
        myFragment = new MyFragment();
        searchFragment = new SearchFragment();


        if (findViewById(R.id.container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            feedFragment.setArguments(getIntent().getExtras());

            transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.container, feedFragment).commit();
        }


        feedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle feedBundle = new Bundle();
             //   feedBundle.putInt(FeedFragment.ARG_POSITION, position);
                feedFragment.setArguments(feedBundle);

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, feedFragment);
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle searchBundle = new Bundle();
                //   feedBundle.putInt(FeedFragment.ARG_POSITION, position);
                searchFragment.setArguments(searchBundle);

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, searchFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        portfolioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle portBundle = new Bundle();
                //   feedBundle.putInt(FeedFragment.ARG_POSITION, position);
                portfolioFragment.setArguments(portBundle);

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, portfolioFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle myBundle = new Bundle();
                //   feedBundle.putInt(FeedFragment.ARG_POSITION, position);
                myFragment.setArguments(myBundle);

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, myFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

    /*
    @Override
    public void onArticleSelected(int position) {

        DetailItemFragment detailFrag = (DetailItemFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_fragment);

        if (detailFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            detailFrag.update(position);
        } else {
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            DetailItemFragment newFragment = new DetailItemFragment();
            Bundle detailArgs = new Bundle();
           // args.putInt(DetailItemFragment.ARG_POSITION, position);
            newFragment.setArguments(detailArgs);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.container, detailFrag);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
*/
    public void setCustomActionBar(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        View view = getLayoutInflater().inflate(R.layout.toolbar_main, null);
        actionBar.setCustomView(view);

        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        ImageView cameraBtn = (ImageView) view.findViewById(R.id.titleBtn1);

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();
            }
        });

        getSupportActionBar().setElevation(0);
    }

}
