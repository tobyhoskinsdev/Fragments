package examples.aaronhoskins.com.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements UserInputFragment.OnFragmentInteractionListener {
    private static final String FRAG_TAG_ONE = "frag_one";
    private static final String FRAG_TAG_TWO = "frag_two";
    UserInputFragment userInputFragment;
    DisplayUserInput displayUserInput;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInputFragment = new UserInputFragment();
        displayUserInput = new DisplayUserInput();


        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.flFragPlaceHolderOne, userInputFragment)
                .addToBackStack(FRAG_TAG_ONE)
                .commit();

        fm.beginTransaction()
                .replace(R.id.flFragPlaceHolderTwo, displayUserInput)
                .addToBackStack(FRAG_TAG_TWO)
                .commit();

    }
    @Override
    public void sendToActivity(String string) {
        displayUserInput.setDisplay(string);
    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnOneRemove:
                //remove by fragment instance
                //fm.beginTransaction().remove(userInputFragment).commit();
                //remove by fragment tag from backstack
                fm.popBackStack(FRAG_TAG_ONE, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            case R.id.btnRemoveAll:
                int fmCount = fm.getBackStackEntryCount();
                for(int i = 0; i < fmCount; i++) {
                    fm.popBackStack();
                }
                break;
        }

    }
}
