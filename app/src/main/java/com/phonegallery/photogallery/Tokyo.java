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

public class Tokyo extends AppCompatActivity {
    TextView tokyoPhotoTags;
    AlertDialog dialogTags;
    EditText editTags;

    TextView tokyoPhotoCategories;
    AlertDialog dialogCategories;
    EditText editCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tokyo);

        tokyoPhotoTags = (TextView) findViewById(R.id.tokyoPhotoTags);
        dialogTags = new AlertDialog.Builder(this).create();
        editTags = new EditText(this);

        tokyoPhotoCategories = (TextView) findViewById(R.id.tokyoPhotoCategories);
        dialogCategories = new AlertDialog.Builder(this).create();
        editCategories = new EditText(this);

        dialogTags.setTitle("Update Photo Tags");
        dialogTags.setView(editTags);

        dialogCategories.setTitle("Update Photo Categories");
        dialogCategories.setView(editCategories);

        dialogTags.setButton(DialogInterface.BUTTON_POSITIVE, "Update Tags", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tokyoPhotoTags.setText(editTags.getText());
            }
        });

        tokyoPhotoTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTags.setText(tokyoPhotoTags.getText());
                dialogTags.show();
            }
        });

        dialogCategories.setButton(DialogInterface.BUTTON_POSITIVE, "Update Categories", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tokyoPhotoCategories.setText(editCategories.getText());
            }
        });

        tokyoPhotoCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editCategories.setText(tokyoPhotoCategories.getText());
                dialogCategories.show();
            }
        });

    }
}
