package com.example.thuchanh3 // Đổi tên package cho đúng

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Khai báo biến toàn cục để dùng chung
    private lateinit var edtNumber1: EditText
    private lateinit var edtNumber2: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Ánh xạ View
        edtNumber1 = findViewById(R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)
        tvResult = findViewById(R.id.tvResult)

        val btnCong = findViewById<Button>(R.id.btnCong)
        val btnTru = findViewById<Button>(R.id.btnTru)
        val btnNhan = findViewById<Button>(R.id.btnNhan)
        val btnChia = findViewById<Button>(R.id.btnChia)

        // 2. Xử lý sự kiện cho từng nút
        btnCong.setOnClickListener { xuLyPhepTinh("+") }
        btnTru.setOnClickListener { xuLyPhepTinh("-") }
        btnNhan.setOnClickListener { xuLyPhepTinh("*") }
        btnChia.setOnClickListener { xuLyPhepTinh("/") }
    }

    // Hàm xử lý chung cho mọi phép tính
    private fun xuLyPhepTinh(phepTinh: String) {
        val str1 = edtNumber1.text.toString()
        val str2 = edtNumber2.text.toString()

        // Kiểm tra dữ liệu rỗng
        if (str1.isEmpty() || str2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số", Toast.LENGTH_SHORT).show()
            return // Dừng hàm lại, không tính tiếp
        }

        // Chuyển sang số thực (Double) để tính toán chính xác phép chia
        val so1 = str1.toDouble()
        val so2 = str2.toDouble()
        var ketQua = 0.0

        // Kiểm tra loại phép tính
        when (phepTinh) {
            "+" -> ketQua = so1 + so2
            "-" -> ketQua = so1 - so2
            "*" -> ketQua = so1 * so2
            "/" -> {
                if (so2 == 0.0) {
                    tvResult.text = "Kết quả: Không thể chia cho 0"
                    return
                }
                ketQua = so1 / so2
            }
        }

        // Hiển thị kết quả
        tvResult.text = "Kết quả: $ketQua"
    }
}