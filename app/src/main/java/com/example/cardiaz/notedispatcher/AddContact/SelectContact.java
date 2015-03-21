package com.example.cardiaz.notedispatcher.AddContact;

import android.content.Intent;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.LoaderManager;

import com.example.cardiaz.notedispatcher.AddContact.dummy.DummyContent;
import com.example.cardiaz.notedispatcher.ExceptionHandler;
import com.example.cardiaz.notedispatcher.GetMessageFragment;
import com.example.cardiaz.notedispatcher.R;
import com.example.cardiaz.notedispatcher.showAlertBox;

public class SelectContact extends ActionBarActivity implements  GetMessageFragment.OnFragmentInteractionListener,
     PhoneContactFragment.OnFragmentInteractionListener{

    public static final int CONTACT_QUERY_LOADER = 0;
    public static final String QUERY_KEY = "query";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_contact);
        onSearch_Contact("Carlos");
        //onSwitchPhoneContactFragment();
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

        /*//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.search_phone_contact:

                onSwitchPhoneContactFragment("Carlos");
                return true;
            default:
                return true;
        }

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

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.select_contact_fragment_container, getMessageFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

    public void onSwitchPhoneContactFragment(String query)
    {
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.select_contact_fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (getIntent().getExtras() != null) {

                return;
            }

            // Create a new Fragment to be placed in the activity layout
            PhoneContactFragment phoneContactFragment = new PhoneContactFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            //phoneContactFragment.setArguments(getIntent().getExtras());
            Bundle bundle = new Bundle();
            bundle.putString("query",query);
            phoneContactFragment.setArguments(bundle);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.select_contact_fragment_container, phoneContactFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }


    @Override
    public void onGetMessageFragmentInteraction(String message) {

    }

    @Override
    public void onPhoneContactFragmentInteraction(int position) {
       // showAlertBox.Show(ContactablesLoaderCallbacks.CONTACT_ITEMS.get(position).name,"Selected contact:",this);
    }

    private void onSearch_Contact(String query)
    {

        // We need to create a bundle containing the query string to send along to the
        // LoaderManager, which will be handling querying the database and returning results.
        Bundle bundle = new Bundle();
        bundle.putString(QUERY_KEY, query);

        ContactablesLoaderCallbacks loaderCallbacks = new ContactablesLoaderCallbacks(this);
        //synchronized (PhoneContactFragment.mArrayAdapter) {

        // Start the loader with the new query, and an object that will handle all callbacks.
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(CONTACT_QUERY_LOADER, bundle, loaderCallbacks);

        //   PhoneContactFragment.mArrayAdapter.notifyAll();
        //}
       /* if (PhoneContactFragment.mArrayAdapter != null) {
          PhoneContactFragment.mArrayAdapter.notifyDataSetChanged();
        }
*/

    }
}
