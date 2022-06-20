<?php

class TaiKhoanController
{
    public function addaccount()
    {   
        if (isset($_REQUEST["Username"]) && isset($_REQUEST["Password"]))
        {
            $acc = new TaiKhoanModel();
            $acc->Username = $_REQUEST["Username"];
            $acc->Password = $_REQUEST["Password"];
            $acc->VaiTro = $_REQUEST["vaiTro"];
            $acc->TrangThai = $_REQUEST["trangThai"];
            $res = TaiKhoanModel::addaccount($acc);
            if ($res)
                echo "<script type='text/javascript'>alert('Thêm thành công');</script>";
            else
                echo "<script type='text/javascript'>alert('Thêm thất bại');</script>";  
        }
        $VIEW = "./view/DangKyTaiKhoan.phtml";
        require("./template/template.phtml");
    }
}
