package com.example.ricardo.calculadora;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    boolean dec = false;
    boolean sum = false;
    boolean sub = false;
    boolean div = false;
    boolean mult = false;
    Double[] numero = new Double[20];
    Double result = 0.0;
    int l=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout T = (TableLayout) this.findViewById(R.id.but);

       final TextView Text = (TextView) findViewById(R.id.OutputNum);

        Button Clear = (Button) findViewById(R.id.clear);

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Text.getText().equals("") || Text.getText().equals(null)){
                    Text.setText("");
                }else{
                   String c = Text.getText().toString();
                   Text.setText(c.substring(0,c.length()-1));
                }
                dec=false;

            }
        });


        for(int i=1;i<T.getChildCount();i++)
        {
            TableRow rs = (TableRow) T.getChildAt(i);
           for (int j=0;j<rs.getChildCount();j++){

               final   Button B = (Button) rs.getChildAt(j);
               final Button Bt = (Button) rs.getChildAt(j);
               ImageButton IB = (ImageButton) findViewById(R.id.imageButton);

               IB.setOnTouchListener(new View.OnTouchListener() {
                   @Override
                   public boolean onTouch(View v1, MotionEvent event) {


                       Text.setText("");
                       dec=false;
                       return true;
                   }
               });
              B.setOnTouchListener(new View.OnTouchListener() {
                  @Override
                  public boolean onTouch(View v, MotionEvent event) {

                        if(v.getTag().equals("Numero")) {
                            switch (event.getAction()) {

                                case MotionEvent.ACTION_DOWN:
                                    v.setBackgroundResource(R.drawable.backcolor);
                                    break;
                                case MotionEvent.ACTION_UP:
                                    v.setBackgroundResource(R.drawable.backgroundcolor);
                                    break;
                            }
                        }else{
                            if(v.getTag().equals("op")) {
                                switch (event.getAction()) {

                                    case MotionEvent.ACTION_DOWN:
                                        v.setBackgroundResource(R.drawable.backcolor);
                                        break;
                                    case MotionEvent.ACTION_UP:
                                        v.setBackgroundResource(R.drawable.backgroundcolor2);
                                        break;
                                }
                            }
                        }

                      return false;
                  }
              });
              B.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {


                        String val = Text.getText().toString();

                                switch (v.getId()) {

                                    case R.id.bt0:
                                        Text.setText(val+"0");

                                        break;
                                    case R.id.bt1:
                                       Text.setText(val+"1");

                                        break;
                                    case R.id.bt2:

                                        Text.setText(val+"2");

                                        break;
                                    case R.id.bt3:
                                       Text.setText(val+"3");
                                        break;
                                    case R.id.bt4:

                                        Text.setText(val+"4");

                                        break;
                                    case R.id.bt5:
                                        Text.setText(val+"5");
                                        break;
                                    case R.id.bt6:

                                        Text.setText(val+"6");

                                        break;
                                    case R.id.bt7:
                                        Text.setText(val+"7");
                                        break;
                                    case R.id.bt8:

                                        Text.setText(val+"8");

                                        break;
                                    case R.id.bt9:
                                        Text.setText(val+"9");
                                        break;
                                    case R.id.btigual:
                                        numero[1] = Double.parseDouble(val);
                                        if(sum == true)
                                        {     result = numero[0] + numero[1];
                                              Text.setText(String.valueOf(result));

                                        }else{
                                                if(sub == true){
                                                    result = numero[0] - numero[1];
                                                    Text.setText(String.valueOf(result));

                                                    }else{
                                                             if(mult == true){
                                                                 result = numero[0] * numero[1];
                                                                 Text.setText(String.valueOf(result));

                                                             }else{
                                                                 if(div == true){
                                                                     result = numero[0] / numero[1];
                                                                     Text.setText(String.valueOf(result));

                                                                 }
                                                             }
                                                }
                                                }
                                        dec=false;sum=false;sub=false;mult=false;div=false;

                                        break;
                                    case R.id.div:
                                       div = true;
                                        numero[0] = Double.parseDouble(val);
                                        Text.setText("");
                                        dec = false;
                                        //Division
                                        break;
                                    case R.id.mult:
                                        numero[0] = Double.parseDouble(val);
                                        Text.setText("");
                                        mult = true;
                                        dec = true;
                                       //multiplicacion

                                        break;
                                    case R.id.sub:
                                        sub = true;
                                        numero[0] = Double.parseDouble(val);
                                        Text.setText("");
                                        dec = true;
                                        //Resta
                                        break;
                                    case R.id.plus:
                                        sum = true;
                                        numero[0] = Double.parseDouble(val);
                                        Text.setText("");
                                        dec = true;
                                        //Suma

                                        break;
                                    case R.id.point:
                                       if(dec==false){
                                           Text.setText(val+".");
                                           dec=true;
                                       }else{
                                           return;
                                       }
                                        break;

                                }







                   }
               });


           }

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
