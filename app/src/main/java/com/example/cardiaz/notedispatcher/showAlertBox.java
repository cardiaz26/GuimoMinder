package com.example.cardiaz.notedispatcher;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by cardiaz on 3/20/2015.
 */
public class  showAlertBox {


    public static void Show(String Message, Context Con)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(Con).create();
        alertDialog.setTitle("Alert!");
        alertDialog.setMessage("Message: " + Message);

        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.show();
    }

    public static void Show(String Message, String Title, Context Con)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(Con).create();
        alertDialog.setTitle(Title);
        alertDialog.setMessage(Message);

        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.show();
    }
}
