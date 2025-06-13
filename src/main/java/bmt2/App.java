package bmt2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        QLNV qlnv = QLNV.getInstance();


        qlnv.themQuanSat(new ThongBaoHR());
        qlnv.themQuanSat(new ThongBaoPM());


        HashMap<String, NV> danhSachNV = NV.nhapDanhSachNhanVien();
        for (NV nv : danhSachNV.values()) {
            qlnv.themNhanVien(nv);
        }
        // Tạo Dispatcher
        XuLyLenh xuLyLenh = new XuLyLenh(danhSachNV);


        // Nhận lệnh từ người dùng
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập lệnh (1: Hiển thị NV 'duan', 2: Sắp xếp theo lương, 0: Thoát): ");
            String lenh = scanner.nextLine();
            if (lenh.equals("0")) break;
            xuLyLenh.xuLyLenh(lenh);
        }

    }
}
