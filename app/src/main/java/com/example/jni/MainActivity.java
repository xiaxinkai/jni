package com.example.jni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        Button btnClick = findViewById(R.id.button);//控件的获取
        btnClick.setOnClickListener(MainActivity.this);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                //里面写点击后想要实现的效果
                Toast.makeText(MainActivity.this, "按钮被点击", Toast.LENGTH_SHORT).show();
                //这里是弹出一个消息---"按钮被点击"
        }
    }
}