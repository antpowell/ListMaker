package com.anthony_powell.listmaker;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView tv;
 ListView listViewCompat;
 List<String> itemNames;

 DatabaseReference mRef;


 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

//  Picasso.with(this).load("http://image.flaticon.com/icons/svg/254/254032.svg").into(searchIcon);

  setupListItems();
  adaptorSetup();


  FirebaseDatabase database = FirebaseDatabase.getInstance();
  mRef = database.getReference("Courses").child("Codes");

  final ProgressDialog progressDialog = new ProgressDialog(this);
//  mRef.setValue("Hello, World.");

  tv = (TextView)findViewById(R.id.main_text_view);
  tv.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {

    progressDialog.show();



    mRef.addListenerForSingleValueEvent(new ValueEventListener() {
     @Override
     public void onDataChange(DataSnapshot dataSnapshot) {
            itemNames.addAll((ArrayList<String>)dataSnapshot.getValue());
            listViewCompat.setAdapter(null);
            adaptorSetup();
            progressDialog.dismiss();

     }


     @Override
     public void onCancelled(DatabaseError databaseError) {
    Toast.makeText(MainActivity.this, "Failed to read value", Toast.LENGTH_SHORT).show();
     }
    });

   }
  });


 }

 protected void setupListItems(){
  itemNames = new ArrayList<>();
//  for(int i = 1; i <=25; i++){
//   itemNames.add("Item here -> "+i);
//  }
 }


 protected void adaptorSetup(){
  DataItemAdapter  adapter = new DataItemAdapter(this, android.R.layout.simple_expandable_list_item_1, itemNames);
//  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemNames);
  listViewCompat = (ListView)findViewById(android.R.id.list);
  listViewCompat.setAdapter(adapter);

 }


}
