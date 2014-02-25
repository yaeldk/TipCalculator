package il.ac.huji.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public final static String EXTRA_TEXT_ENTERED = "il.ac.huji.tipcalculator.TEXT_ENTERED";

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /**
     * Called when the user clicks Calculate button
     * @param view
     */
    public void calculate ( View view)
    {
    	EditText editText = (EditText) findViewById(R.id.edit_bill_amount);
    	String textEntered = editText.getText().toString();
    	float numEntered = 0.0f;
    	
    	TextView tipText = (TextView) findViewById(R.id.tip_text);
    	
    	
    	try 
    	{
    		numEntered = Float.parseFloat(textEntered);
    	} 
    	catch( NumberFormatException nfe ) 
    	{
    		tipText.setText ( getString ( R.string.error_not_number) );
    		return;
    	}
    	if ( numEntered < 0 )
    	{
    		tipText.setText ( getString ( R.string.error_negative_number) );
    		return;
    	}
    	
    	float tip = numEntered * 0.12f;
    	
    	final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_round);
        if (checkBox.isChecked()) 
        {
            int tipRound = (int)Math.round(tip);
            tipText.setText ( getString ( R.string.tip_text ) + tipRound ); 
        }
        else
        {
        	tip = (float)Math.round(tip * 100) / 100;
        	tipText.setText ( getString ( R.string.tip_text ) + tip ); 
        }
    }
    
    public void onCheckboxClicked(View view) 
    {
    	
    }

    
}
