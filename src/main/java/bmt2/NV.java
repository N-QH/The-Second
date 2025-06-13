package bmt2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;;

public class NV {
    private String maNV;
    private String hoTen;
    private LocalDate ngayVaoLam;
    private double luongKhoiDiem;
    private String cachTra;

    public NV(String maNV, String hoTen, LocalDate ngayVaoLam, double luongKhoiDiem, String cachTra) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngayVaoLam = ngayVaoLam;
        this.luongKhoiDiem = luongKhoiDiem;
        this.cachTra = cachTra;
    }


    // Getter và Setter cho maNV
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }


    // Getter và Setter cho hoTen
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    // Getter và Setter cho ngayVaoLam
    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }
    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    // Getter và Setter cho luongKhoiDiem
    public double getLuongKhoiDiem() {
        return luongKhoiDiem;
    }
    public void setLuongKhoiDiem(double luongKhoiDiem) {
        this.luongKhoiDiem = luongKhoiDiem;
    }

    // Getter và Setter cho cachTra
    public String getCachTra() {
        return cachTra;
    }
    public void setCachTra(String cachTra) {
        this.cachTra = cachTra;
    }


    public static HashMap<String, NV> nhapDanhSachNhanVien() {
        HashMap<String, NV> dsNV = new HashMap<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            try {
                System.out.print("Nhập mã NV (hoặc '#' để kết thúc): ");
                String maNV = scanner.nextLine();
                if (maNV.equals("#")) break;


                System.out.print("Nhập họ tên: ");
                String hoTen = scanner.nextLine();


                System.out.print("Nhập ngày vào làm (yyyy-mm-dd): ");
                LocalDate ngayVaoLam = LocalDate.parse(scanner.nextLine());


                System.out.print("Nhập lương khởi điểm: ");
                double luongKhoiDiem = Double.parseDouble(scanner.nextLine());


                System.out.print("Nhập cách trả (duan/ngay): ");
                String cachTra = scanner.nextLine();


                NV nv = new NV(maNV, hoTen, ngayVaoLam, luongKhoiDiem, cachTra);
                dsNV.put(maNV, nv);
            } catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
            }
        }


        return dsNV;
    }

}






