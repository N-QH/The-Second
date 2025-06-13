package bmt2;
import java.util.HashMap;


public class HienThiNVDuAnCmd implements Command {
    private HashMap<String, NV> dsNV;


    public HienThiNVDuAnCmd(HashMap<String, NV> dsNV) {
        this.dsNV = dsNV;
    }


    @Override
    public void execute() {
        new Thread(() -> {
            System.out.println("Danh sách nhân viên trả theo dự án (duan):");
            dsNV.values().stream()
                .filter(nv -> "duan".equals(nv.getCachTra()))
                .forEach(nv -> System.out.println(
                    "Mã NV: " + nv.getMaNV() +
                    ", Họ tên: " + nv.getHoTen() +
                    ", Ngày vào làm: " + nv.getNgayVaoLam() +
                    ", Lương khởi điểm: " + nv.getLuongKhoiDiem() +
                    ", Cách trả: " + nv.getCachTra()
                ));
        }).start();
    }
}

