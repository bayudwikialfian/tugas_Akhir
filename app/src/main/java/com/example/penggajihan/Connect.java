package com.example.penggajihan;

public class Connect{


    private String tunjnganmakan;
    private String key;

    private String nik;
    private String nama;
    private String alamat;
    private String jabatan;
    private String email;
    private String password;
    private String username;


    private String hari;
    private String totalgaji;
    private String gajipokok;
    private String gajibersih;
    private String gajikotor;
    private String tunjangankesehatan;
    private String tunjangantransport;
    private String tunjanganmakan;


    public Connect(String nik, String nama, String alamat, String jabatan) {
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.jabatan = jabatan;
    }

    public Connect(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public Connect(String nama, String nik, String hari, String gajipokok, String gajibersih, String gajikotor, String tunjangantransport, String tunjanganmakan, String tunjanganjabatan, String tunjangankesehatan) {
        this.nama = nama;
        this.nik = nik;
        this.hari = hari;
        this.hari = hari;
        this.gajibersih = gajibersih;
        this.gajipokok = gajipokok;
        this.gajikotor = gajikotor;
        this.tunjangantransport = tunjangantransport;
        this.tunjanganmakan = tunjanganmakan;
        this.tunjnganmakan = tunjanganjabatan;
        this.tunjangankesehatan = tunjangankesehatan;
    }


    public String getTunjnganmakan() {
        return tunjnganmakan;
    }

    public void setTunjnganmakan(String tunjnganmakan) {
        this.tunjnganmakan = tunjnganmakan;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getTotalgaji() {
        return totalgaji;
    }

    public void setTotalgaji(String totalgaji) {
        this.totalgaji = totalgaji;
    }

    public String getGajipokok() {
        return gajipokok;
    }

    public void setGajipokok(String gajipokok) {
        this.gajipokok = gajipokok;
    }

    public String getGajibersih() {
        return gajibersih;
    }

    public void setGajibersih(String gajibersih) {
        this.gajibersih = gajibersih;
    }

    public String getGajikotor() {
        return gajikotor;
    }

    public void setGajikotor(String gajikotor) {
        this.gajikotor = gajikotor;
    }

    public String gettunjangankesehatan() {
        return tunjangankesehatan;
    }

    public void settunjangankesehatan(String tunjangankesehatan) {
        this.tunjangankesehatan = tunjangankesehatan;
    }

    public String getTunjangantransport() {
        return tunjangantransport;
    }

    public void setTunjangantransport(String tunjangantransport) {
        this.tunjangantransport = tunjangantransport;
    }


}