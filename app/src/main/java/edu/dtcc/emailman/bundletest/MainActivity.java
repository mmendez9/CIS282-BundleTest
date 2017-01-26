package edu.dtcc.emailman.bundletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Define two keys for the bundle
    private final String AREA_KEY = "area_value";
    private final String PERIMETER_KEY = " perimeter_value";

    // Define variables for area and perimeter
    private double area;
    private double perimeter;

    // Define the input fields for length and width
    private EditText etLength;
    private EditText etWidth;

    // Define the output fields for area and perimeter
    private TextView tvArea;
    private TextView tvPerimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the output fields
        tvArea = (TextView) findViewById(R.id.tvArea);
        tvPerimeter = (TextView) findViewById(R.id.tvPerimeter);

        etLength = (EditText) findViewById(R.id.etLength);
        etWidth = (EditText) findViewById(R.id.etWidth);


        // Is there a saved bundle?
        if (savedInstanceState != null) {
            // Restore the saved data
            area = savedInstanceState.getDouble(AREA_KEY);
            perimeter = savedInstanceState.getDouble(PERIMETER_KEY);

            tvArea.setText(Double.toString(area));
            tvPerimeter.setText(Double.toString(perimeter));
            Log.d("ERIC", "bundle restored");
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putDouble(AREA_KEY, area);
        outState.putDouble(PERIMETER_KEY, perimeter);

        Log.d("ERIC","bundle saved");
    }


    public void onCalcClick(View view) {

        try {
            // Read the input fields
            double length = Double.parseDouble(etLength.getText().toString());
            double width = Double.parseDouble(etWidth.getText().toString());

            // Do the calculations
            area = length * width;
            perimeter = 2 * (length + width);

            // Put the results in the output fields
            tvArea.setText(Double.toString(area));
            tvPerimeter.setText(Double.toString(perimeter));
        }
        catch (Exception e ){
            Toast.makeText(MainActivity.this, "Missing Input", Toast.LENGTH_LONG).show();
            // Clear the output fields
            tvArea.setText("");
            tvPerimeter.setText("");
        }
    }
}
