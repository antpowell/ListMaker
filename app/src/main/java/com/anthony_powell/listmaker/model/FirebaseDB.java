package com.anthony_powell.listmaker.model;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SGT_POWELL on 11/23/2016.
 */

public class FirebaseDB {
 private Context c;
 private List<String> resultsList = new ArrayList<>();
 private HashMap<String,String> resultsMap = new HashMap<>();
 private Object resultsObject = new Object();
 private FirebaseDatabase database;
 private DatabaseReference mRef;


 private FirebaseDB(){
  database = FirebaseDatabase.getInstance();
  mRef = database.getReference();
 }

 private FirebaseDB(Context context){
  this.c = context;
  database = FirebaseDatabase.getInstance();
  mRef = database.getReference();
 }

 public void getData(){

 }
}
