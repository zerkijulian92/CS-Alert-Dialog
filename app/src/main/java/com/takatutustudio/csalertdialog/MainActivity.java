package com.takatutustudio.csalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExit = findViewById(R.id.btn_exit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit(); // Memanggil Class Function Exit
            }
        });

    }

    // FUNCTION BUTTON YANG ADA DI SMARTPHONE
    /** Catt:
     * Jika tidak ingin menggunakan fucntion ini silahkan dinonaktifkan atau sebaliknya
     * Untuk membuat function ini harus diluar dari onCreate
     * Menggunakan @Override
     */

    @Override
    public void onBackPressed() {
        exit(); // Memanggil Class Function Exit
    }

    // MEMBUAT CLASS FUNCTION EXIT
    public void exit() {
        AlertDialog.Builder alertDialaogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Judul
        alertDialaogBuilder.setTitle("Konfirmasi Keluar");

        // Setting Alert Dialog Pesan
        alertDialaogBuilder.setMessage("Apakah anda yakin akan keluar dari aplikasi ?");
        alertDialaogBuilder.setCancelable(false);

        // Membuat Function YES, NO, CANCEL
        /** Catt:
         * Jika tidak ingin menggunakan function CANCEL silahkan dinonaktifkan atau sebaliknya
         */

        // Membuat Function YES (setPositiveButton)
        alertDialaogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish(); // Fungsi ini berguna untuk keluar dari activity dan menghapusnya.
                // Jika Ingin Keluar dan menghapus seluruh session activity
                // Pastekan Kode disini!!.
            }
        });

        // Membuat Function No (setNegativeButton)
        alertDialaogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Anda Menekan Tombol No", Toast.LENGTH_SHORT).show();
            }
        });

        // Membuat Function Cancel (setNeutralButton)
        alertDialaogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Anda Menekan Tombol Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        // Memunculkan PopUp Alert
        AlertDialog alertDialog = alertDialaogBuilder.create();
        alertDialog.show();
    }
}
