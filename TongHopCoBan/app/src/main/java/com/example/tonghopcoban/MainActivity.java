package com.example.tonghopcoban;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtCMND, edtBoSung, edtHoTen;
    Button btnGui;
    RadioGroup idGroup;
    CheckBox chkdocbao, chkdocsach, chkcoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // ánh xạ id
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCMND = findViewById(R.id.edtCMND);
        edtBoSung = findViewById(R.id.edtBoSung);
        btnGui = findViewById(R.id.btnGui);
        idGroup = findViewById(R.id.idGroup);
        chkcoding = findViewById(R.id.chkCoding);
        chkdocbao = findViewById(R.id.chkDocBao);
        chkdocsach = findViewById(R.id.chkDocSach);
        // xử lí click
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy thông tin họ tên
                String hoTen = edtHoTen.getText().toString();
                if (hoTen.length() < 3) {
                    Toast.makeText(MainActivity.this, "họ tên phải >=3 ký tự", Toast.LENGTH_LONG).show();
                    edtHoTen.requestFocus();  // cho phép nhập văn bản
                    edtHoTen.selectAll();  // cho phép thay đổi nội dung
                    return;
                }
//                // lấy thông tin CMND
                String CMND = edtCMND.getText().toString();
                if (CMND.length() != 9) {
                    Toast.makeText(MainActivity.this, "CMND phải đúng 9 số", Toast.LENGTH_LONG).show();
                    edtCMND.requestFocus();
                    edtCMND.selectAll();
                    return;
                }

                // lấy thông tin bằng cấp
                int idselect = idGroup.getCheckedRadioButtonId();
                RadioButton radselect = findViewById(idselect);
                String bangcap = radselect.getText().toString();

                // lấy thông tin sở thích
                String soThich ="";
                if(chkdocsach.isSelected())
                    soThich+= chkdocsach.getText().toString()+"-";

                if(chkdocbao.isSelected())
                    soThich+= chkdocbao.getText().toString()+"-";

                if(chkcoding.isSelected())
                    soThich+= chkcoding.getText().toString();

                // lấy thông tin bổ sung
                String bosung = edtBoSung.getText().toString();
                String tonghop = hoTen+"\n"+CMND+"\n"+bangcap+"\n"+soThich+"\n";
                tonghop+= "----------THÔNG TIN BỔ SUNG-----------\n";
                tonghop+=bosung+"\n";
                tonghop+="---------------------------------------------------";
                // Tạo Dialog và hiển thị thông tin tổng hợp lên
                AlertDialog.Builder mydialog= new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("THÔNG TIN CÁ NHÂN");
                mydialog.setMessage(tonghop);
                mydialog.setPositiveButton("ĐÓNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                mydialog.create().show();
            }
        });
    }
}