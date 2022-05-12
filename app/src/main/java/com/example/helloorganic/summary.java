package com.example.helloorganic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.helloorganic.Database.OrderContract;

public class summary extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public  CardAdapter madapter;
    public static final int LOADER=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        getLoaderManager().initLoader(LOADER,null,this);
        ListView listView=findViewById(R.id.list);
        madapter=new CardAdapter(this,null);
        listView.setAdapter(madapter);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] project={
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
               // OrderContract.OrderEntry.COLUMN_BAG,
             //   OrderContract.OrderEntry.COLUMN_BASKET

        };

        return new CursorLoader(this,OrderContract.OrderEntry.CONTENT_URI,project,null,null,null);
        // return new CursorLoader(this,OrderContract.OrderEntry.CONTENT_URI,
         //       project,
           //     null,
             //   null,
               // null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
          madapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        madapter.swapCursor(null);
    }
}