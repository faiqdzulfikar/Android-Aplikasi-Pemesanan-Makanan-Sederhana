package cassanova.com.tutorialuserinput;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mainEdtNama;
    EditText mainEdtAlamat;
    RadioGroup mainRgGender;
    Button mainBtnKurang;
    TextView mainTvJumlah;
    Button mainBtnTambah;
    TextView tvHargaSatuan;
    TextView tvHargaTotal;
    Button btnPesan;

    int jumlahPesanan;
    int hargaSatuan;
    int hargaTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainEdtNama = findViewById(R.id.main_edt_nama);
        mainEdtAlamat = findViewById(R.id.main_edt_alamat);
        mainRgGender = findViewById(R.id.main_rg_gender);
        mainBtnKurang = findViewById(R.id.main_btn_kurang);
        mainTvJumlah = findViewById(R.id.main_tv_jumlah);
        mainBtnTambah = findViewById(R.id.main_btn_tambah);
        tvHargaSatuan = findViewById(R.id.tv_harga_satuan);
        tvHargaTotal = findViewById(R.id.tv_harga_total);
        btnPesan = findViewById(R.id.btn_pesan);

        jumlahPesanan = 0;
        hargaSatuan = 20000;
        hargaTotal = 0;

        mainTvJumlah.setText("" + jumlahPesanan);
        tvHargaSatuan.setText("" + hargaSatuan);
        tvHargaTotal.setText("" + hargaTotal);

        //Kasih Handler pada tiap Tombol
        mainBtnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlahPesanan = jumlahPesanan + 1;
                hargaTotal = hargaSatuan *jumlahPesanan;
                mainTvJumlah.setText(""+jumlahPesanan);
                tvHargaTotal.setText(""+hargaTotal);
            }
        });

        mainBtnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jumlahPesanan == 0) {
                    Toast.makeText(MainActivity.this, "Jumlah 0", Toast.LENGTH_SHORT).show();
                } else {
                    jumlahPesanan = jumlahPesanan - 1;
                    hargaTotal = hargaSatuan*jumlahPesanan;
                    mainTvJumlah.setText(""+jumlahPesanan);
                    tvHargaTotal.setText(""+hargaTotal);
                }
            }
        });

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama;
                String alamat;
                String jeniskelamin;

                nama = mainEdtNama.getText().toString();
                alamat = mainEdtAlamat.getText().toString();

                int checkedRB = mainRgGender.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(checkedRB);
                jeniskelamin = radioButton.getText().toString();

                Intent i = new Intent(MainActivity.this,HasilActivity.class);
                i.putExtra("namaPesanan",nama);
                i.putExtra("alamat",alamat);
                i.putExtra("gender",jeniskelamin);
                i.putExtra("jumlah",jumlahPesanan);
                i.putExtra("hargaSatuan",hargaSatuan);
                i.putExtra("hargaTotal",hargaTotal);
                startActivity(i);
            }
        });
    }
}
