package com.phonegallery.photogallery;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Taipei extends AppCompatActivity {

    TextView  taipeiPhotoTags;
    AlertDialog dialogTags;
    EditText editTags;

    TextView taipeiPhotoCategories;
    AlertDialog dialogCategories;
    EditText editCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taipei);

        taipeiPhotoTags = (TextView) findViewById(R.id.taipeiPhotoTags);
        dialogTags = new AlertDialog.Builder(this).create();
        editTags = new EditText(this);

        taipeiPhotoCategories = (TextView) findViewById(R.id.taipeiPhotoCategories);
        dialogCategories = new AlertDialog.Builder(this).create();
        editCategories = new EditText(this);

        dialogTags.setTitle("Update Photo Tags");
        dialogTags.setView(editTags);

        dialogCategories.setTitle("Update Photo Categories");
        dialogCategories.setView(editCategories);

        dialogTags.setButton(DialogInterface.BUTTON_POSITIVE, "Update Tags", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                taipeiPhotoTags.setText(editTags.getText());
            }
        });

        taipeiPhotoTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTags.setText(taipeiPhotoTags.getText());
                dialogTags.show();
            }
        });

        dialogCategories.setButton(DialogInterface.BUTTON_POSITIVE, "Update Categories", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                taipeiPhotoCategories.setText(editCategories.getText());
            }
        });

        taipeiPhotoCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editCategories.setText(taipeiPhotoCategories.getText());
                dialogCategories.show();
            }
        });
    }
}
