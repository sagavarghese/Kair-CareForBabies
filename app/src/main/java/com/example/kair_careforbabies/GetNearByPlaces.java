package com.example.kair_careforbabies;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetNearByPlaces extends AsyncTask<Object, String, String>
{
    GoogleMap mMap;
    String url;

    InputStream is;
    BufferedReader bufferedReader;
    StringBuilder stringBuilder;
    String data;


    @Override
    protected String doInBackground(Object... objects) {
        mMap = (GoogleMap)objects[0];
        url = (String) objects[1];
        try
        {
            URL myurl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)myurl.openConnection();
            httpURLConnection.connect();
            is = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(is));

            String line = "";
            stringBuilder = new StringBuilder();

            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
            data = stringBuilder.toString();

        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    protected void onPostExecute(String s)
    {
        try
        {
            JSONObject parentObject = new JSONObject(s);
            JSONArray resultArray = parentObject.getJSONArray("results");

            for(int i=0;i<resultArray.length();i++)
            {
                JSONObject jsonObject = resultArray.getJSONObject(i);
                JSONObject locationObj = jsonObject.getJSONObject("geometry").getJSONObject("location");

                String latitude = locationObj.getString("lat");
                String longtitude = locationObj.getString("lng");

                JSONObject nameObject = resultArray.getJSONObject(i);
                String name_hospital = nameObject.getString("name");
                String vicinity = nameObject.getString("vicinity");

                LatLng latLng = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longtitude));

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(name_hospital + "," + vicinity);
                mMap.addMarker(markerOptions);


            }

        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
    }
}
