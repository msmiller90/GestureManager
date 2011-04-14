package net.miller;

import net.miller.R;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class Gesturer extends TabActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get icons
        TabHost tabHost = getTabHost();  // The activity TabHost
        
        TabHost.TabSpec spec;  // Reusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab
        
        // Do the same for the other tabs
        intent = new Intent().setClass(this, GestureBuilderActivity.class);
        spec = tabHost.newTabSpec("builder").setIndicator("",
                          res.getDrawable(R.drawable.ic_tabs_builder))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, GesturesActivity.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("gestures").setIndicator("",
                          res.getDrawable(R.drawable.ic_tabs_gesture))
                      .setContent(intent);
        tabHost.addTab(spec);

       tabHost.setCurrentTab(0);
    }
}