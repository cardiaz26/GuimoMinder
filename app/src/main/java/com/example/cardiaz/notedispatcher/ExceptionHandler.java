package com.example.cardiaz.notedispatcher;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;


/**
 * Created by cardiaz on 3/19/2015.
 */
public  class ExceptionHandler {



    public ExceptionHandler(Exception ex, Context Con)
    {
        handleException(ex,Con);
    }

    private void handleException(Exception ex, Context Con)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(Con).create();
        alertDialog.setTitle("Exception!");
        alertDialog.setMessage("Message: " + ex.getMessage() + "\nStackTrace: " + ex.getStackTrace().toString());

        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.show();
    }
}
