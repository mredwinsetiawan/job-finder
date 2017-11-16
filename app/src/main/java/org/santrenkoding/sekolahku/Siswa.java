package org.santrenkoding.sekolahku;

/**
 * Created by edwin on 06/11/2017.
 */

public class Siswa {
    private String nama;
    private String nis;
    private String alamat;
    private String idPhoto;
    private String gaji;
    private String closed;
    private String experience;
    private String deskripsi;
    public Siswa(String nama, String nis, String alamat, String idPhoto, String gaji, String closed, String experience, String deskripsi) {
        this.nama = nama;
        this.nis = nis;
        this.alamat = alamat;
        this.idPhoto = idPhoto;
        this.gaji = gaji;
        this.closed = closed;
        this.experience = experience;
        this.deskripsi = deskripsi;
    }
    public String getNama() {
        return nama;
    }
    public String getNis() {
        return nis;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getIdPhoto() {
        return idPhoto;
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

