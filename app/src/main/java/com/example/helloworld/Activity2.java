package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Activity2 extends AppCompatActivity {
    private  Button quotebut;
    private TextView quote;
    private  TextView recom;
    private  Button horror;
    private  Button romance;
    private  Button fantasy;
    private  Button science;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        quotebut=(Button) findViewById(R.id.welcome);
        quote=(TextView) findViewById(R.id.quote);
        science=(Button)  findViewById(R.id.science);
        recom= (TextView) findViewById(R.id.recom);
        horror=(Button)findViewById(R.id.horror) ;
        romance=(Button)  findViewById(R.id.romance);
        fantasy= (Button) findViewById(R.id.fantasy);
        quotebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(Activity2.this);
                String url = "https://zenquotes.io/api/random";

                JsonArrayRequest arrRequest = new JsonArrayRequest(Request.Method.GET, url,null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                String author;
                                String quotetext;

                                try {
                                    JSONObject quoteinfo=response.getJSONObject(0);
                                    quotetext= quoteinfo.getString("q");
                                    author=quoteinfo.getString("a");
                                    quote.setText(quotetext+"\n \n-"+author);
                                    quote.setTextColor(Color.parseColor("#B8E6F2"));
                                } catch (JSONException e) {
                                    Toast.makeText(Activity2.this,"Failed",Toast.LENGTH_SHORT).show();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Activity2.this,"Some Error has occured",Toast.LENGTH_LONG).show();
                    }
                });

                queue.add(arrRequest);
            }
        });

        horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(Activity2.this);
                String url = "https://openlibrary.org/search.json?subject=horror";

                JsonObjectRequest arrRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                String author;
                                String book;

                                try {
                                    JSONObject bookinfo=response.getJSONObject("docs");
                                    book= bookinfo.getString("title");
                                    author=bookinfo.getString("author_name");
                                    recom.setText(book + "-" +author);
                                    recom.setTextColor(Color.parseColor("#B8E6F2"));
                                } catch (JSONException e) {
                                    Toast.makeText(Activity2.this,"Failed",Toast.LENGTH_SHORT).show();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Activity2.this,"Some Error has occured",Toast.LENGTH_LONG).show();
                    }
                });

                queue.add(arrRequest);
            }
        });

    }
}