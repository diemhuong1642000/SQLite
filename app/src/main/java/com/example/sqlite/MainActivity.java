package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnThem;
    private Button btnSua;
    private Button btnXoa;
    private EditText etId;
    private EditText etName;
    private EditText etToan;
    private EditText etLy;
    private EditText etHoa;
    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase = new MyDatabase(this);
        initView();
        intListener();
    }

    private void intListener() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String toan = etToan.getText().toString();
                String ly = etLy.getText().toString();
                String hoa = etHoa.getText().toString();
                boolean b1 = myDatabase.insertData(name,toan,ly,hoa);
                if (b1){
                    Toast.makeText(MainActivity.this,"Inserted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Inserted fail",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                String name = etName.getText().toString();
                String toan = etToan.getText().toString();
                String ly = etLy.getText().toString();
                String hoa = etHoa.getText().toString();
                boolean b1 = myDatabase.updateData(id,name,toan,ly,hoa);
                if (b1){
                    Toast.makeText(MainActivity.this,"Update",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Update fail",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                boolean b1 = myDatabase.deleteData(id);
                if (b1){
                    Toast.makeText(MainActivity.this,"Delete",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Delete fail",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void initView() {
            btnThem = (Button) findViewById(R.id.btn_them);
            btnSua = (Button) findViewById(R.id.btn_sua);
            btnXoa = (Button) findViewById(R.id.btn_xoa);
            etId = (EditText) findViewById(R.id.ed_id);
            etName = (EditText) findViewById(R.id.ed_name);
            etToan = (EditText) findViewById(R.id.ed_toan);
            etLy = (EditText) findViewById(R.id.ed_ly);
            etHoa = (EditText) findViewById(R.id.ed_hoa);
        }
}