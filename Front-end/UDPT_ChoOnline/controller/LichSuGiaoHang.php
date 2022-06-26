<?php

class LichSuGiaoHangController
{

    public function deliveryhistory()
    {
        $taikhoan = TaiKhoanModel::getaccountbyusername($_SESSION["UserName"]);
        $dvvc = DonViVanChuyenModel::findonetransportbytaikhoan($taikhoan->ID);
        $data = LichSuGiaoHangModel::deliveryhistory($dvvc->MaDVVC);
        $VIEW = "./view/LichSuGiaoHang.phtml";
        require("./template/template.phtml");
    }

    
}
