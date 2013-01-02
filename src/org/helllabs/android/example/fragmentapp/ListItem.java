package org.helllabs.android.example.fragmentapp;

import android.os.Parcel;


public class ListItem implements Comparable<ListItem> {

	private String name;
	private String description;

	public ListItem(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public ListItem(Parcel in) {
		name = in.readString();
		description = in.readString();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	// Comparable methods

	@Override
	public int compareTo(ListItem item) {
		return this.name.compareTo(item.name);
	}
}
