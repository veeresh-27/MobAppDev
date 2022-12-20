package com.example.graphicflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new myview(this));
    }
    public class myview extends View {
        public myview(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setColor(Color.rgb(237,64,9));
            canvas.drawRect(100,100,1000,270,p);

            Paint p1 = new Paint();
            p1.setColor(Color.BLUE);
            canvas.drawCircle(550, 375,102.5F,p1);

            Paint p2 = new Paint();
            p2.setColor(Color.GREEN);
            canvas.drawRect(100,480,1000,650,p2);

            Paint p3 = new Paint();
            p3.setColor(Color.DKGRAY);
            canvas.drawRect(50,100,100,1350,p3);
        }
    }
}