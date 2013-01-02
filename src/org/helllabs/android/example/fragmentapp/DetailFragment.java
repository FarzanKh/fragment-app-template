package org.helllabs.android.example.fragmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;


public class DetailFragment extends SherlockFragment {
	private ShareActionProvider shareActionProvider;
	private ListItem currentItem = null;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.detail_fragment, container, false);
		return view;
	}

	public void displayDetail(int position) {
		ListItem item = MainActivity.items[position];
		setShareIntent();

		View view = getView();

		TextView nameText = (TextView)view.findViewById(R.id.name);
		nameText.setText(item.getName());
		TextView descriptionText = (TextView)view.findViewById(R.id.description);
		descriptionText.setText(item.getDescription());
		
		currentItem = item;
	}


	// Menu

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.detail_menu, menu);

		MenuItem menuItem = menu.findItem(R.id.menu_share);		
		shareActionProvider = (ShareActionProvider)menuItem.getActionProvider();
		setShareIntent();
	}


	// Sharing

	private void setShareIntent(){
		if (shareActionProvider != null && currentItem != null) {
			Intent shareIntent = new Intent(Intent.ACTION_SEND);
			shareIntent.setType("text/plain");
			shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
			shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
					getString(R.string.app_name) + ": " + currentItem.getName());
			shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, currentItem.getDescription());	    	

			shareActionProvider.setShareIntent(shareIntent);
		}
	}
}
