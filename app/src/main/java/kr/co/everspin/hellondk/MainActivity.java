package kr.co.everspin.hellondk;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import kr.co.everspin.hellondk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;

    private static final String DEBUG_TAG = "[DEBUG]";

    static {
        System.loadLibrary("sum");
        System.loadLibrary("hello");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMain(this);
    }

    /**
     * PlusResultButton click event method
     *
     * @param v View class
     */
    public void onPlusResultButtonClicked(View v) {
        int val1 = 0;
        int val2 = 0;
        int result = 0;

        if (binding.num1.getText().toString().equals("") || binding.num2.getText().toString().equals("")) {
            showToastAndLog(R.string.number_null);

            return;
        }

        try {
            val1 = Integer.parseInt(binding.num1.getText().toString());
            val2 = Integer.parseInt(binding.num2.getText().toString());
        } catch (NumberFormatException e) {
            showToastAndLog(R.string.number_exception);

            return;
        }

        result = getSum(val1, val2);

        if (result < 0) {
            showToastAndLog(R.string.big_exception);

            return;
        }

        showToastAndLog("result : " + result);

        binding.text.setText(getHelloWorld());
    }

    public boolean onPlusResultButtonLongClicked(View v) {
        binding.text.setText("");

        return true;
    }

    /**
     * show Toast & print Log method
     *
     * @param resId String Resource ID
     */
    public void showToastAndLog(int resId) {
        String message = getString(resId);

        Log.e(DEBUG_TAG, MainActivity.class.getName() + "/Message :" + message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * show Toast & print Log method
     *
     * @param message String message
     */
    public void showToastAndLog(String message) {
        Log.e(DEBUG_TAG, MainActivity.class.getName() + "/Message :" + message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * Get Sum value at native method
     *
     * @param val1 Int value1
     * @param val2 Int value2
     * @return Sum value
     */
    public native int getSum(int val1, int val2);

    /**
     * Get "Hello World" String at native method
     *
     * @return "Hello World"
     */
    public native String getHelloWorld();
}
