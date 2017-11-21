package org.santrenkoding.sekolahku;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ArrayList<Siswa> listData = new ArrayList<>();
    private static final String TAG = "DetailWisataActivity";
    private ImageView ivDetailGambar;
    private TextView tvDetailDeskripsi,  tvDetailNis, tvDetailNama, tvDetailExperience, tvDetailGaji;
    private TextView tvDetailAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();

        Bundle data = getIntent().getExtras();
        String namaWisata = data.getString(Konstanta.DATA_NAMA);
        String nisWisata = data.getString(Konstanta.DATA_NIS);
        String alamatWisata = data.getString(Konstanta.DATA_ALAMAT);
        String gambarWisata = data.getString(Konstanta.DATA_PHOTO);
        String gajiWisata = data.getString(Konstanta.DATA_GAJI);
        String closedWisata = data.getString(Konstanta.DATA_CLOSED);
        String experienceWisata = data.getString(Konstanta.DATA_EXPERIENCE);
        String deskripsiWisata = data.getString(Konstanta.DATA_DESKRIPSI);

        getSupportActionBar().setTitle(namaWisata);
        tvDetailAlamat.setText(alamatWisata);
        tvDetailDeskripsi.setText(deskripsiWisata);
        tvDetailNis.setText(nisWisata);
        tvDetailNama.setText(namaWisata);
        tvDetailGaji.setText(gajiWisata);
        tvDetailExperience.setText(experienceWisata);
        String sl = (gambarWisata);
        String dl = (sl.substring(33));
        Glide.with(this)
                .load("https://drive.google.com/thumbnail?id=" + dl)
                .placeholder(R.drawable.no_image_found)
                .error(R.drawable.no_image_found)
                .into(ivDetailGambar);
    }

    private void initView() {
        ivDetailGambar = (ImageView) findViewById(R.id.iv_detail_gambar);
        tvDetailDeskripsi = (TextView) findViewById(R.id.tv_detail_deskripsi);
        tvDetailAlamat = (TextView) findViewById(R.id.tv_value_data_siswa_alamat);
        tvDetailNis = (TextView) findViewById(R.id.tv_value_data_siswa_nis);
        tvDetailNama = (TextView) findViewById(R.id.tv_value_data_siswa_nama);
        tvDetailGaji = (TextView) findViewById(R.id.tv_value_data_siswa_gaji);
        tvDetailExperience = (TextView) findViewById(R.id.tv_value_data_siswa_experience);
    }
}

