package org.helllabs.android.example.fragmentapp;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;


public class MainActivity extends SherlockFragmentActivity {
	
	public static ListItem[] items;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		items = new ListItem[3];
		items[0] = new ListItem("First item", "This is the first item");
		items[1] = new ListItem("Second item", "This is the second item");
		items[2] = new ListItem("Third item", "This is the third item");
		
		ListFragment fragment = (ListFragment)getSupportFragmentManager().findFragmentById(R.id.list_fragment);
		fragment.setList(items);
	}

	// Menu

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.base_menu, menu);
		return true;
	}
}
