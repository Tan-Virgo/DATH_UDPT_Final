<?php

class PhanhoiController
{
    public function listphanhoi()
    {
        $data = phanhoiModel::listphanhoi();
        $VIEW = "./view/DSphanhoi.phtml";
        require("./template/template.phtml");
    }

    public function showtophanhoi()
    {
        $kh = KhachHangModel::findonecustomer(1);
        $dsNCC = NhaCungCapModel::listsupplier();
        $dsSP = SanPhamModel::getlistallproduct();
        $VIEW = "./view/ThemPH.phtml";
        require("./template/template.phtml");
    }

    public function createphanhoi()
    {
        $PH = new phanhoiModel();        
        $PH->chitiet = $_REQUEST["chitiet"];
        $PH->ngaytao = $_REQUEST["ngaytao"];
        $PH->nguoidung = $_REQUEST["nguoidung"];
        $PH->sanpham = $_REQUEST["sanpham"];
        $PH->nhacungcap = $_REQUEST["nhacungcap"];
        
        $res = phanhoiModel::createphanhoi($PH);

        if ($res)
            echo "<script type='text/javascript'>alert('Thêm thành công');</script>";
        else
            echo "<script type='text/javascript'>alert('Thêm thất bại');</script>";
    
        $data = phanhoiModel::listphanhoi();
        $VIEW = "./view/DSphanhoi.phtml";
        require("./template/template.phtml");
    }


}


?>