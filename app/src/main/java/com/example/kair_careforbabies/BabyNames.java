package com.example.kair_careforbabies;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BabyNames extends AppCompatActivity
{

    String json = null;
    String fileName,alpha;
    int status = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_names);

        final RadioButton boy = (RadioButton) findViewById(R.id.rbBoyNames);
        final RadioButton girl = (RadioButton) findViewById(R.id.rbGirlNames);
        Button view = (Button) findViewById(R.id.buttonView);
        final Button A = (Button) findViewById(R.id.buttonA);
        final Button B = (Button) findViewById(R.id.buttonB);
        final Button C = (Button) findViewById(R.id.buttonC);
        final Button D = (Button) findViewById(R.id.buttonD);
        final Button E = (Button) findViewById(R.id.buttonE);
        final Button F = (Button) findViewById(R.id.buttonF);
        final Button G = (Button) findViewById(R.id.buttonG);
        final Button H = (Button) findViewById(R.id.buttonH);
        final Button I = (Button) findViewById(R.id.buttonI);
        final Button J = (Button) findViewById(R.id.buttonJ);
        final Button K = (Button) findViewById(R.id.buttonK);
        final Button L = (Button) findViewById(R.id.buttonL);
        final Button M = (Button) findViewById(R.id.buttonM);
        final Button N = (Button) findViewById(R.id.buttonN);
        final Button O = (Button) findViewById(R.id.buttonO);
        final Button P = (Button) findViewById(R.id.buttonP);
        final Button Q = (Button) findViewById(R.id.buttonQ);
        final Button r = (Button) findViewById(R.id.buttonR);
        final Button S = (Button) findViewById(R.id.buttonS);
        final Button T = (Button) findViewById(R.id.buttonT);
        final Button U = (Button) findViewById(R.id.buttonU);
        final Button V = (Button) findViewById(R.id.buttonV);
        final Button W = (Button) findViewById(R.id.buttonW);
        final Button X = (Button) findViewById(R.id.buttonX);
        final Button Y = (Button) findViewById(R.id.buttonY);
        final Button Z = (Button) findViewById(R.id.buttonZ);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = A.getText().toString();
                status = 1;
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = B.getText().toString();
                status = 1;
            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = C.getText().toString();
                status = 1;
            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = D.getText().toString();
                status = 1;
            }
        });
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = E.getText().toString();
                status = 1;
            }
        });
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = F.getText().toString();
                status = 1;
            }
        });
        G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = G.getText().toString();
                status = 1;
            }
        });
        H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = H.getText().toString();
                status = 1;
            }
        });
        I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = I.getText().toString();
                status = 1;
            }
        });
        J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = J.getText().toString();
                status = 1;
            }
        });
        K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = K.getText().toString();
                status = 1;
            }
        });
        L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = L.getText().toString();
                status = 1;
            }
        });
        M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = M.getText().toString();
                status = 1;
            }
        });
        N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = N.getText().toString();
                status = 1;
            }
        });
        O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = O.getText().toString();
                status = 1;
            }
        });
        P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = P.getText().toString();
                status = 1;
            }
        });
        Q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = Q.getText().toString();
                status = 1;
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = r.getText().toString();
                status = 1;
            }
        });
        S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = S.getText().toString();
                status = 1;
            }
        });
        T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = T.getText().toString();
                status = 1;
            }
        });
        U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = U.getText().toString();
                status = 1;
            }
        });
        V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = V.getText().toString();
                status = 1;
            }
        });
        W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = W.getText().toString();
                status = 1;
            }
        });
        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = X.getText().toString();
                status = 1;
            }
        });
        Y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = Y.getText().toString();
                status = 1;
            }
        });
        Z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha = Z.getText().toString();
                status = 1;
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boy.isChecked() == true || girl.isChecked() == true)
                {
                    if(status ==1) {
                        if (boy.isChecked()) {
                            fileName = "BoyNames.json";

                        } else if (girl.isChecked()) {
                            fileName = "GirlNames.json";

                        }
                        try {
                            InputStream is = getAssets().open(fileName);
                            int size = is.available();
                            byte[] buffer = new byte[size];
                            is.read(buffer);
                            is.close();
                            json = new String(buffer, "UTF-8");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        final ArrayList<Names> n = processData();
                    }
                    else
                        Toast.makeText(BabyNames.this, "Choose an alphabet", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(BabyNames.this, "Select a gender", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private ArrayList<Names> processData()
    {
        ArrayList<Names> temp = new ArrayList<>();
        final TextView t = (TextView) findViewById(R.id.txtDisplay);
        t.setMovementMethod(new ScrollingMovementMethod());
        try
        {
            JSONObject obj = new JSONObject(json);
            String nms ="";

            JSONArray array = obj.getJSONArray(alpha);
            for(int i=0;i<array.length();i++)
            {
                nms = nms + "\n" +array.getString(i);
            }
            t.setText(nms);

            return temp;
        } catch (JSONException e) {
            Log.d("MainActivity", e.getMessage());
        }
        return null;
    }
}
