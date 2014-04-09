package com.example.wuerfel;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    int rollDice(int seitenzahl)
	{
		double randomZahl = Math.random();
		
		int wuerfelergebniss = (int)(1+Math.floor(randomZahl*(seitenzahl)));
		
		/*for(int i = 1; i <= seitenzahl; i++){
			
			if(randomZahl < 1 * i/(seitenzahl)){
				wuerfelergebniss = i;
				break;
			}
		}*/
		return wuerfelergebniss;
	}
	
	public void rollTheDice(View view){
		EditText editText = (EditText) findViewById(R.id.eTSeitenzahl);
		String sSeitenzahl = editText.getText().toString();
		int iSeitenzahl = Integer.parseInt(sSeitenzahl);
		int ergebniss = rollDice(iSeitenzahl);
		TextView textView = (TextView) findViewById(R.id.tVResult);
		textView.setText(""+ergebniss);
		
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
