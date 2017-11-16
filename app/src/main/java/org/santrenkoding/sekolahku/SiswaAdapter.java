package org.santrenkoding.sekolahku;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by edwin on 06/11/2017.
 */

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.SiswaViewHolder> {

    private Context context;
    private ArrayList<Siswa> listSiswa;

    public SiswaAdapter(Context context, ArrayList<Siswa> listSiswa) {
        this.context = context;
        this.listSiswa = listSiswa;
    }

    @Override
    public SiswaAdapter.SiswaViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_siswa,
                        parent,
                        false);
        return new SiswaViewHolder(view);
    }

    public class SiswaViewHolder extends RecyclerView.ViewHolder {
//        ImageView imSiswa;
        TextView tvNama, tvNis, tvAlamat;

        public SiswaViewHolder(View itemView) {
            super(itemView);
//            imSiswa = (ImageView) itemView.findViewById(R.id.im_siswa);
            tvNama = (TextView) itemView.findViewById(R.id.tv_value_data_siswa_nama);
            tvNis = (TextView) itemView.findViewById(R.id.tv_value_data_siswa_nis);
            tvAlamat = (TextView) itemView
                    .findViewById(R.id.tv_value_data_siswa_alamat);
        }
    }

    @Override
    public void onBindViewHolder(SiswaAdapter.SiswaViewHolder holder, final int position) {
//        String idPhoto = listSiswa.get(position).getIdPhoto();
//        Glide.with(context)
//                .load("https://drive.google.com/thumbnail?id=" + idPhoto)
//                .into(holder.imSiswa);
        holder.tvNama.setText(listSiswa.get(position).getNama());
        holder.tvNis.setText(listSiswa.get(position).getNis());
        holder.tvAlamat.setText(listSiswa.get(position).getAlamat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, DetailActivity.class);
                Bundle data = new Bundle();
                data.putString(Konstanta.DATA_NAMA, listSiswa.get(position).getNama());
                data.putString(Konstanta.DATA_NIS, listSiswa.get(position).getNis());
                data.putString(Konstanta.DATA_ALAMAT, listSiswa.get(position).getAlamat());
                data.putString(Konstanta.DATA_PHOTO, listSiswa.get(position).getIdPhoto());
                data.putString(Konstanta.DATA_GAJI, listSiswa.get(position).getGaji());
                data.putString(Konstanta.DATA_CLOSED, listSiswa.get(position).getClosed());
                data.putString(Konstanta.DATA_EXPERIENCE, listSiswa.get(position).getExperience());
                data.putString(Konstanta.DATA_DESKRIPSI, listSiswa.get(position).getDeskripsi());
                pindah.putExtras(data);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listSiswa.size();
    }
}


