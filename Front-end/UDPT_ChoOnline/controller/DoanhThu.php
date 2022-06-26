<?php

class DoanhThuController
{

    public function turnover()
    {
        $taikhoan = TaiKhoanModel::getaccountbyusername($_SESSION["UserName"]);
        $ncc = NhaCungCapModel::findonesupplierbytaikhoan($taikhoan->ID);
        $supplier = NhaCungCapModel::findonesupplier($ncc->MaNCC);
        $data = DoanhThuModel::getturnover(1);
        $datachart = DoanhThuModel::getturnoverpresent(1);
        $VIEW = "./view/DoanhThu.phtml";
        require("./template/template.phtml");
    }

    
}