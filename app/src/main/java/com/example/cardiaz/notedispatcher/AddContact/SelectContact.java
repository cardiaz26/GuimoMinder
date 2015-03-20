package com.example.cardiaz.notedispatcher.AddContact;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cardiaz.notedispatcher.ExceptionHandler;
import com.example.cardiaz.notedispatcher.GetMessageFragment;
import com.example.cardiaz.notedispatcher.R;

public class SelectContact extends ActionBarActivity implements SelectContactListFragment.OnFragmentInteractionListener, GetMessageFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_contact);
        onSwitchSelectContactListFragment();
        //onSwitchGetMessageFragment();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSwitchSelectContactListFragment()
    {
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.select_contact_fragment_container) != null) {

            /*// However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (getIntent().getExtras() != null) {
                return;
            }*/

            // Create a new Fragment to be placed in the activity layout
            SelectContactListFragment selectContactListFragment = new SelectContactListFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            selectContactListFragment.setArguments(getIntent().getExtras());

           /* // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, getMessageFragment).commit();*/

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.select_contact_fragment_container, selectContactListFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }else {
            Exception ex= new Exception("Could not load Select Contact List Fragment!");
            ExceptionHandler eh = new ExceptionHandler(ex,this);
        }
    }

    @Override
    public void onSelectContactListFragmentInteraction(String id) {

    }

    public void onSwitchGetMessageFragment()
    {
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.select_contact_fragment_container) != null) {

          /*  // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (getIntent().getExtras() != null) {
                return;
            }*/

            // Create a new Fragment to be placed in the activity layout
            GetMessageFragment getMessageFragment = new GetMessageFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            getMessageFragment.setArguments(getIntent().getExtras());

           /* // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, getMessageFragment).commit();*/

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.select_contact_fragment_container, getMessageFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

    @Override
    public void onGetMessageFragmentInteraction(String message) {

    }
}
