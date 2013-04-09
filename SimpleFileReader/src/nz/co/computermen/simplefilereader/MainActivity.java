package nz.co.computermen.simplefilereader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

//import com.example.mysecondapp.R;

public class MainActivity extends Activity {
	private TextView fileTextView;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	InputStreamReader is = new InputStreamReader(this.getResources().openRawResource(R.raw.samplefile));
    	BufferedReader reader = new BufferedReader(is);
    	StringBuilder finalText = new StringBuilder();
    	String line;
    	try {
			while ((line = reader.readLine()) != null) {
			    finalText.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

    	fileTextView = (TextView)findViewById(R.id.fileText);
    	fileTextView.setText(finalText.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
