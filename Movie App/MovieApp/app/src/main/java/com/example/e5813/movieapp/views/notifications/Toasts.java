package com.example.e5813.movieapp.views.notifications;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e5813.movieapp.R;

public class  Toasts extends AppCompatActivity {



    public Toast NoInternetConnection(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View layout = inflater.inflate(R.layout.toast_no_internet_connection, null);
        TextView text = (TextView) layout.findViewById(R.id.tv_no_internet_connection);
        text.setText(R.string.erro_no_internet_connection);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        return toast;
    }
}