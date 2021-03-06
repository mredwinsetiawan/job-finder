package org.santrenkoding.sekolahku;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataSiswaActivity extends AppCompatActivity {
    RecyclerView rvDataSiswa;
    ArrayList<Siswa> listSiswa = new ArrayList<>();
    final String url = "https://script.google.com/macros/s/AKfycbwzMeQ2doGqRO9KLyl2I7EUg4xK7_XGbNaIqqrOAwgemBa5zytV/exec?id=1ZqJKroIw0lwEVPDfmdKknOyxGIbBFgSiaML_FaE2COg&sheet=sheet1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_siswa);
        rvDataSiswa = (RecyclerView)findViewById(R.id.rv_data_siswa);
        final ProgressDialog progressDialog = new
                ProgressDialog(DataSiswaActivity.this);
        progressDialog.setMessage("Menyambung Server");
        progressDialog.show();
        LinearLayoutManager llm = new LinearLayoutManager(DataSiswaActivity.this);
        rvDataSiswa.setLayoutManager(llm);
        OkHttpClient network = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        network.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                progressDialog.dismiss();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(DataSiswaActivity.this,
                                "Connection Failed",Toast.LENGTH_LONG).show();
                    }

                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                progressDialog.dismiss();
                String jsonData = response.body().string();
//                Log.d("DATA_SISWA", jsonData);
//                Log.d("DATA_SISWA", url);
                try {
                    JSONObject jsonObject = new JSONObject(jsonData);
                    JSONArray jsonArray = jsonObject.getJSONArray("records");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject data = jsonArray.getJSONObject(i);
                        String nama_pekerjaan = data.getString("nama_pekerjaan");
                        String nama_perusahaan = data.getString("nama_perusahaan");
                        String alamat = data.getString("alamat");
                        String idPhoto = data.getString("foto_perusahaan");
                        Log.d("idPhoto",idPhoto);
                        String gaji = data.getString("gaji");
                        String closed = data.getString("closed");
                        String experience = data.getString("experience");
                        String deskripsi = data.getString("deskripsi");
                        Siswa siswa = new Siswa(nama_pekerjaan, nama_perusahaan, alamat, idPhoto, gaji, closed, experience, deskripsi);
                        listSiswa.add(siswa);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        SiswaAdapter adapter = new
                                SiswaAdapter(DataSiswaActivity.this,
                                listSiswa);
                        rvDataSiswa.setAdapter(adapter);
                    }
                });
            }
        });
    }
}

