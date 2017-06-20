package com.phonegallery.photogallery;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kellyliu on 2017-06-03.
 */

public class HongKong extends AppCompatActivity{

    TextView hkPhotoTags;
    AlertDialog dialogTags;
    EditText editTags;

    TextView hkPhotoCategories;
    AlertDialog dialogCategories;
    EditText editCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hongkong);

        hkPhotoTags = (TextView) findViewById(R.id.hkPhotoTags);
        dialogTags = new AlertDialog.Builder(this).create();
        editTags = new EditText(this);

        hkPhotoCategories = (TextView) findViewById(R.id.hkPhotoCategories);
        dialogCategories = new AlertDialog.Builder(this).create();
        editCategories = new EditText(this);

        dialogTags.setTitle("Update Photo Tags");
        dialogTags.setView(editTags);

        dialogCategories.setTitle("Update Photo Categories");
        dialogCategories.setView(editCategories);

        dialogTags.setButton(DialogInterface.BUTTON_POSITIVE, "Update Tags", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                hkPhotoTags.setText(editTags.getText());
            }
        });

        hkPhotoTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTags.setText(hkPhotoTags.getText());
                dialogTags.show();
            }
        });

        dialogCategories.setButton(DialogInterface.BUTTON_POSITIVE, "Update Categories", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                hkPhotoCategories.setText(editCategories.getText());
            }
        });

        hkPhotoCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editCategories.setText(hkPhotoCategories.getText());
                dialogCategories.show();
            }
        });
    }
}
