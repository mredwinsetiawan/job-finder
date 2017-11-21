package org.santrenkoding.sekolahku;

/**
 * Created by edwin on 06/11/2017.
 */

public class Siswa {
    private String nama_pekerjaan;
    private String nama_perusahaan;
    private String alamat;
    private String foto_perusahaan;
    private String gaji;
    private String closed;
    private String experience;
    private String deskripsi;
    public Siswa(String nama_pekerjaan, String nama_perusahaan, String alamat, String foto_perusahaan, String gaji, String closed, String experience, String deskripsi) {
        this.nama_pekerjaan = nama_pekerjaan;
        this.nama_perusahaan = nama_perusahaan;
        this.alamat = alamat;
        this.foto_perusahaan = foto_perusahaan;
        this.gaji = gaji;
        this.closed = closed;
        this.experience = experience;
        this.deskripsi = deskripsi;
    }
    public String getNama() {
        return nama_pekerjaan;
    }
    public String getNis() {
        return nama_perusahaan;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getIdPhoto() {
        return foto_perusahaan;
    }
    public String getGaji() {
        return gaji;
    }
    public String getClosed() {
        return closed;
    }
    public String getExperience() {
        return experience;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
}

