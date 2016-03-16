package sidespell.tech.finalsexam.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import sidespell.tech.finalsexam.R;
import sidespell.tech.finalsexam.fragments.MainFragment;
import sidespell.tech.finalsexam.fragments.PredictGenderFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnTopicItemClickListener {

    private boolean mDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_main);


        mainFragment.setOnTopicItemClickListener(this);

        View view = mainFragment.getView().findViewById(R.id.details);
        mDualPane = view != null && view.getVisibility() == View.VISIBLE;
        Log.d("Boholst", mDualPane + "");

        if (mDualPane) {
            onItemClick(0);
        }
    }

    public void onItemClick(int position) {
        if (mDualPane) {
            Log.d("Boholst", "Tab");
            // TODO: If app to run is on a tablet, show the PredictGenderFragment on the right side
        } else {
            Log.d("Boholst", "Cellphone");
            // TODO: If app to run is on a phone, launch a new activity to present the Predict Gender screen
            Intent intent = new Intent(this, PredictGenderActivity.class);
            startActivity(intent);
        }
    }
}
