package com.vee.sample.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.vee.sample.gwt.client.data.GridConstants.ColumnConstants;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SampleGWT implements EntryPoint {
	
	public void onModuleLoad() {
		ColumnConstants columnContants  = new ColumnConstants();
		RootPanel.get("app").add(new SampleDataGrid(columnContants));
	}
}
