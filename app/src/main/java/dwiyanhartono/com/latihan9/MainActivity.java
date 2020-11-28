package dwiyanhartono.com.latihan9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar Rate;
    Button BtnSubmit;
    Button BtnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Rate = findViewById(R.id.rating);
        BtnSubmit = findViewById(R.id.button_Submit);
        BtnExit = findViewById(R.id.button_Exit);

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float Rating = Rate.getRating();
                String Kategori = "";
                if(Rating >= 5) {
                    Kategori = "Sangat Setuju";
                } else if(Rating >= 4) {
                    Kategori = "Setuju";
                } else if(Rating >= 3) {
                    Kategori = "Kurang Setuju";
                } else if(Rating >= 2) {
                    Kategori = "Tidak Setuju";
                } else {
                    Kategori = "Sangat Tidak Setuju";
                }
                String Pesan = "Nilai rating adalah " + Rating +
                        " yang artinya saya " + Kategori;
                Toast.makeText(MainActivity.this, Pesan, Toast.LENGTH_LONG).show();
            }
        });
        BtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Konfirmasi = getResources().getString(R.string.Konfirmasi);
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage(Konfirmasi)
                        .setCancelable(false)
                        .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Nggak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Konfirmasi");
                alert.show();
            }
        });
    }
}