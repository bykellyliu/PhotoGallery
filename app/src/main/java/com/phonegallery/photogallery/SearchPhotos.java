package com.phonegallery.photogallery;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import com.phonegallery.photogallery.model.Photo;

import java.util.ArrayList;

public class SearchPhotos extends AppCompatActivity {

    ListView lv;
    SearchView sv;

    String[] names = {"Hong Kong", "Taipei", "Tokyo", "Seoul"};
    int[] images = {R.drawable.hongkong, R.drawable.taipei, R.drawable.tokyo, R.drawable.seoul};
    float rating[] = {3, 4, 5, 3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchphotos);
        populateListView();
        //registerClickCallback();
    }

    private void populateListView() {
        lv = (ListView) findViewById(R.id.listView1);
        sv = (SearchView) findViewById(R.id.searchView1);

        //ADAPTER
        final Adapter adapter = new Adapter(this, getPhotos());
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String arg0) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // TODO Auto-generated method stub

                adapter.getFilter().filter(query);

                return false;
            }
        });
    }

   /** private void registerClickCallback() {
        lv = (ListView) findViewById(R.id.listView1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Integer selectedPos = (Integer) view.getTag();
                switch (selectedPos) {
                    case 0:
                        Intent HongKong = new Intent(view.getContext(), HongKong.class);
                        startActivity(HongKong);
                        break;
                    case 1:
                        Intent Taiwan = new Intent(view.getContext(), Taipei.class);
                        startActivity(Taiwan);
                        break;

                }
            }
        });
    }
*/

    private ArrayList<Photo> getPhotos() {
        ArrayList<Photo> photos = new ArrayList<Photo>();
        Photo p;

        for (int i = 0; i < names.length; i++) {
            p = new Photo(names[i], images[i], rating[i]);
            photos.add(p);
        }

        return photos;


    }
}
