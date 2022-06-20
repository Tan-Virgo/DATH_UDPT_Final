<?php

class LichSuGiaoHangController
{

    public function deliveryhistory()
    {
        $dvvc = DonViVanChuyenModel::findonetransport(1);
        $data = LichSuGiaoHangModel::deliveryhistory($dvvc->MaDVVC);
        $VIEW = "./view/LichSuGiaoHang.phtml";
        require("./template/template.phtml");
    }

    
}
