package com.example.cardiaz.notedispatcher;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.cardiaz.notedispatcher.AddContact.SelectContact;
import com.example.cardiaz.notedispatcher.dummy.DummyContent;


public class MyActivity extends ActionBarActivity
    implements GetMessageFragment.OnFragmentInteractionListener, ContactListFragment.OnFragmentInteractionListener{
    //Git-hub-test
    public final static String EXTRA_MESSAGE = "com.example.cardiaz.notedispatcher.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread myThread, Throwable e) {
                System.out.println(myThread.getName() + " throws exception: " + e);
                e.printStackTrace();
                return;
            }
        });




        setContentView(R.layout.activity_my);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ContactListFragment contactListFragment = new ContactListFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            contactListFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, contactListFragment).addToBackStack(null).commit();
        }

    }

    public void onSwitchGetMessageFragment()
    {
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

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
            transaction.replace(R.id.fragment_container, getMessageFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       /* getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;*/
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                //openSearch();
                return true;
            case R.id.action_settings:
                //openSettings();
                return true;
            case R.id.action_quit:
                finish();
                return true;
            case R.id.action_send_message:
                onSwitchGetMessageFragment();
                return true;
            case R.id.action_add_contact:
                addContact();
                return true;
            default:
                return true;
        }
    }

   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            //toggleActionBar();
        }
        return true;
    }

    private void toggleActionBar() {
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null) {
            if(actionBar.isShowing()) {
                actionBar.hide();
            }
            else {
                actionBar.show();
            }
        }
    }*/

    /** Called when the fragment sends the message string */
    public void sendMessage(String message) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the add contact action is clicked from the ActionBar */
    public void addContact() {

        Intent intent = new Intent(this, SelectContact.class);
        startActivity(intent);

    }
    @Override
    public void onGetMessageFragmentInteraction(String message)
    {

        sendMessage(message);
    }

    @Override
    public void onContactListSelectItemFragmentInteraction(int position) {
        showAlertBox.Show(DummyContent.ITEMS.get(position).content,"Selected:",this);
    }



}
