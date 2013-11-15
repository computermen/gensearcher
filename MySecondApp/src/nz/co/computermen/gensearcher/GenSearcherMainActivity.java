package nz.co.computermen.gensearcher;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.webkit.WebView;
import android.widget.EditText;

public class GenSearcherMainActivity extends Activity {
	// Declare the widgets
	TextView searchstringtextView;
	EditText firstnameeditText, surnameeditText, marriednameText, othertermText;
	CheckBox reverseBox, marriedBox, othertermBox;
	WebView webView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gensearcher_main);
        
        // Instantiate the widgets
        reverseBox = (CheckBox) findViewById(R.id.reverseBox);
        marriedBox = (CheckBox) findViewById(R.id.marriedBox);
        othertermBox = (CheckBox) findViewById(R.id.othertermBox);
        searchstringtextView = (TextView) findViewById(R.id.searchstringtextView);
        firstnameeditText = (EditText) findViewById(R.id.firstnameeditText);
        surnameeditText = (EditText) findViewById(R.id.surnameeditText);
        marriednameText = (EditText) findViewById(R.id.marriednameText);
        othertermText = (EditText) findViewById(R.id.othertermText);
        webView = (WebView) findViewById(R.id.webView1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    // Hard coded strings need fixing
    public void onSearchButtonClick(View view) {
    	StringBuilder str = new StringBuilder("");
    	str.append("\"");
    	str.append(firstnameeditText.getText());
    	str.append(" ");
    	str.append(surnameeditText.getText());
    	str.append("\"");
    	if (marriedBox.isChecked()) {
    		str.append(" ");
        	str.append("OR");
        	str.append(" ");
    		str.append("\"");
        	str.append(firstnameeditText.getText());
        	str.append(" ");
        	str.append(marriednameText.getText());
        	str.append("\"");
    		}
    	
    	if (reverseBox.isChecked()) {
        	str.append(" ");
        	str.append("OR");
        	str.append(" ");
        	str.append("\"");
        	str.append(surnameeditText.getText());
        	str.append(",");
        	str.append(" ");
        	str.append(firstnameeditText.getText());
        	str.append("\"");
        	if (marriedBox.isChecked()) {
        		str.append(" ");
            	str.append("OR");
            	str.append(" ");
        		str.append("\"");
        		str.append(marriednameText.getText());
        		str.append(",");
            	str.append(" ");
            	str.append(firstnameeditText.getText());
            	str.append("\"");
        		}
        
    		}
    	if (othertermBox.isChecked()) {
        	str.append(" ");
           	str.append(othertermText.getText());
        }
    	searchstringtextView.setText(str);
    	webView.loadUrl ("http://www.google.com/search?q=" + str.toString());
    }
 }

