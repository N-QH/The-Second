package bmt;

import java.util.HashMap;

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
    }
}
