package com.ismailhakkiaydin.portraitlandscapeview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private View PortraitDesign(){
        LinearLayout pnl = new LinearLayout(this);
        pnl.setBackgroundColor(Color.CYAN);

        Button btn = new Button(this);
        btn.setText("Portrait Mode");
        pnl.addView(btn);

        return pnl;
    }

    private View LandscapreDesign(){
        LinearLayout pnl = new LinearLayout(this);
        pnl.setBackgroundColor(Color.MAGENTA);
        CheckBox cb = new CheckBox(this);
        cb.setText("Lanscape Mode");
        pnl.addView(cb);

        return pnl;
    }

    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);

        Display dsp = wm.getDefaultDisplay();

        if(dsp.getHeight()>dsp.getWidth()){
            setContentView(PortraitDesign());
        }else {
            setContentView(LandscapreDesign());
        }

        ++count;
        //this.setTitle("Rotate : "+ count);

        if(savedInstanceState != null && savedInstanceState.containsKey("rotate")){
            count = savedInstanceState.getInt("rotate");
            savedInstanceState.putInt("rotate",++count);
        }else {
            count = 1;
        }

        this.setTitle("Rotate : " + count);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putInt("rotate",count);
        super.onSaveInstanceState(outState);
    }

}
