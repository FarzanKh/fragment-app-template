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
		
		
		
		return inflater.inflate(R.layout.list_fragment, container, false);    	
	}

	@SuppressLint("NewApi")
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		DetailFragment fragment = (DetailFragment)getFragmentManager().findFragmentById(R.id.detail_fragment);
		if (fragment != null && fragment.isInLayout()) {
			v.setActivated(true);
			fragment.displayDetail(position);
		} else {			
			Intent intent = new Intent(getActivity(), DetailActivity.class);
			intent.putExtra("position", position);
			startActivity(intent);
		}	
	}
	
	public void setList(ListItem[] items) {
		setListAdapter(new ListAdapter(getActivity(), R.layout.list_item, items));
	}

	// Menu

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.events_menu, menu);
	}

}
