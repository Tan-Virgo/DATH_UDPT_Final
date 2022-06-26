<?php

class LichSuMuaHangController
{

    public function purchasinghistory()
    {
        $taikhoan = TaiKhoanModel::getaccountbyusername($_SESSION["UserName"]);
        $kh = KhachHangModel::findonecustomerbytaikhoan($taikhoan->ID);
        $data = LichSuMuaHangModel::purchasinghistory($kh->MaKH);
        $VIEW = "./view/LichSuMuaHang.phtml";
        require("./template/template.phtml");
    }

    
}
