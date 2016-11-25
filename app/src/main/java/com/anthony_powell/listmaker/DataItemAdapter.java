package com.anthony_powell.listmaker;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by SGT_POWELL on 11/21/2016.
 */

public class DataItemAdapter extends ArrayAdapter<String> {
 public DataItemAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
  super(context, resource, textViewResourceId, objects);
 }

 public DataItemAdapter(Context context, int resource) {
  super(context, resource);

 }

 public DataItemAdapter(Context context, int resource, int textViewResourceId) {
  super(context, resource, textViewResourceId);
 }

 public DataItemAdapter(Context context, int resource, List<String> objects) {
  super(context, resource, objects);
 }

 
}
