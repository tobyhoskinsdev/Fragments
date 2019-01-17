package examples.aaronhoskins.com.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements UserInputFragment.OnFragmentInteractionListener {
    UserInputFragment userInputFragment;
    DisplayUserInput displayUserInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInputFragment = new UserInputFragment();
        displayUserInput = new DisplayUserInput();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.flFragPlaceHolderOne, userInputFragment)
                .commit();

        fm.beginTransaction()
                .replace(R.id.flFragPlaceHolderTwo, displayUserInput)
                .commit();

    }
    @Override
    public void sendToActivity(String string) {
        displayUserInput.setDisplay(string);
    }
}
