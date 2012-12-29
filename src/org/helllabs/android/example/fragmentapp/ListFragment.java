package org.helllabs.android.example.fragmentapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;


public class ListFragment extends SherlockListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		ListItem[] items = {
				new ListItem("First item", "This is the first item"),
				new ListItem("Second item", "This is the second item"),
				new ListItem("Third item", "This is the third item")
		};
		
		setListAdapter(new ListAdapter(getActivity(), R.layout.list_item, items));
		
		return inflater.inflate(R.layout.list_fragment, container, false);    	
	}

	@SuppressLint("NewApi")
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		DetailFragment fragment = (DetailFragment)getFragmentManager().findFragmentById(R.id.detail_fragment);
		if (fragment != null && fragment.isInLayout()) {
			v.setActivated(true);
			fragment.displayDetail((ListItem)l.getItemAtPosition(position));
		} else {			
			Intent intent = new Intent(getActivity(), DetailActivity.class);
			intent.putExtra("item", ((ListItem)l.getItemAtPosition(position)));
			startActivity(intent);
		}	
	}

	// Menu

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.events_menu, menu);
	}

}
