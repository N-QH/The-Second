package bmt2;


import java.util.HashMap;


public class XuLyLenh {
    private Command hienThiNVDuAnCmd;
    private Command hienThiNVSapXepLuongCmd;


    public XuLyLenh(HashMap<String, NV> dsNV) {
        this.hienThiNVDuAnCmd = new HienThiNVDuAnCmd(dsNV);
        this.hienThiNVSapXepLuongCmd = new HienThiNVSapXepLuongCmd(dsNV);
    }


    public void xuLyLenh(String lenh) {
        switch (lenh) {
            case "1":
                hienThiNVDuAnCmd.execute();
                break;
            case "2":
                hienThiNVSapXepLuongCmd.execute();
                break;
            default:
                System.out.println("Lệnh không hợp lệ!");
                break;
        }
    }
}
