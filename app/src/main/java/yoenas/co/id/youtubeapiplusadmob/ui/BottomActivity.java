package yoenas.co.id.youtubeapiplusadmob.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import yoenas.co.id.youtubeapiplusadmob.R;
import yoenas.co.id.youtubeapiplusadmob.fragment.AnimalsFragment;
import yoenas.co.id.youtubeapiplusadmob.fragment.CampussFragment;
import yoenas.co.id.youtubeapiplusadmob.fragment.SportsFragment;

public class BottomActivity extends AppCompatActivity {

    private AdView mAdView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_home:

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new SportsFragment()).commit();

                    return true;

                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new AnimalsFragment()).commit();
                    return true;

                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new CampussFragment()).commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SportsFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
