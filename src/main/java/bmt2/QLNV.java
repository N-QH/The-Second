package bmt2;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

interface QuanSat {
    void capNhat(String maNV, NV nv);
}

class ThongBaoHR implements QuanSat {
    public void capNhat(String maNV, NV nv) {
        System.out.println("Phòng nhân sự nhận thông báo về nhân viên mới: " + nv.getHoTen());
    }
}
class ThongBaoPM implements QuanSat {
    public void capNhat(String maNV, NV nv) {
        System.out.println("Đội dự án nhận thông báo về nhân viên mới: " + nv.getHoTen());
    }
}

public class QLNV {
    private static QLNV instance;
    private HashMap<String, NV> dsNV;
    private List<QuanSat> dsQS;


    private QLNV() {
        dsNV = new HashMap<>();
        dsQS = new ArrayList<>();
    }


    public static QLNV getInstance() {
        if (instance == null) {
            instance = new QLNV();
        }
        return instance;
    }


    public void themQuanSat(QuanSat qs) {
        dsQS.add(qs);
    }


    public HashMap<String, NV> getDsNV() {
        return dsNV;
    }


    public void themNhanVien(NV nv) {
        dsNV.put(nv.getMaNV(), nv);
        for (QuanSat qs : dsQS) {
            if ("duan".equals(nv.getCachTra()) && qs instanceof ThongBaoPM) {
                qs.capNhat(nv.getMaNV(), nv);
            } else if ("ngay".equals(nv.getCachTra()) && qs instanceof ThongBaoHR) {
                qs.capNhat(nv.getMaNV(), nv);
            }
        }
    }
}
