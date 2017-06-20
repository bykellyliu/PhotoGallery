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

public class Seoul extends AppCompatActivity {


    TextView seoulPhotoTags;
    AlertDialog dialogTags;
    EditText editTags;

    TextView seoulPhotoCategories;
    AlertDialog dialogCategories;
    EditText editCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seoul);

        seoulPhotoTags = (TextView) findViewById(R.id.seoulPhotoTags);
        dialogTags = new AlertDialog.Builder(this).create();
        editTags = new EditText(this);

        seoulPhotoCategories = (TextView) findViewById(R.id.seoulPhotoCategories);
        dialogCategories = new AlertDialog.Builder(this).create();
        editCategories = new EditText(this);

        dialogTags.setTitle("Update Photo Tags");
        dialogTags.setView(editTags);

        dialogCategories.setTitle("Update Photo Categories");
        dialogCategories.setView(editCategories);

        dialogTags.setButton(DialogInterface.BUTTON_POSITIVE, "Update Tags", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                seoulPhotoTags.setText(editTags.getText());
            }
        });

        seoulPhotoTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTags.setText(seoulPhotoTags.getText());
                dialogTags.show();
            }
        });

        dialogCategories.setButton(DialogInterface.BUTTON_POSITIVE, "Update Categories", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                seoulPhotoCategories.setText(editCategories.getText());
            }
        });

        seoulPhotoCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editCategories.setText(seoulPhotoCategories.getText());
                dialogCategories.show();
            }
        });

    }
}
