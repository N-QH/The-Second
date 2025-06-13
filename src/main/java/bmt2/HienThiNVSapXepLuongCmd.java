package bmt2;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class HienThiNVSapXepLuongCmd implements Command {
    private HashMap<String, NV> dsNV;


    public HienThiNVSapXepLuongCmd(HashMap<String, NV> dsNV) {
        this.dsNV = dsNV;
    }


    @Override
    public void execute() {
        new Thread(() -> {
            System.out.println("Danh sách nhân viên sắp xếp tăng dần theo lương khởi điểm:");
            List<NV> sortedList = dsNV.values().stream()
                .sorted((nv1, nv2) -> Double.compare(nv1.getLuongKhoiDiem(), nv2.getLuongKhoiDiem()))
                .collect(Collectors.toList());
            sortedList.forEach(nv -> System.out.println(
                "Mã NV: " + nv.getMaNV() +
                ", Họ tên: " + nv.getHoTen() +
                ", Ngày vào làm: " + nv.getNgayVaoLam() +
                ", Lương khởi điểm: " + nv.getLuongKhoiDiem() +
                ", Cách trả: " + nv.getCachTra()
            ));
        }).start();
    }
}

