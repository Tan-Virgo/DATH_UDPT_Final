<?php

class DonViVanChuyenController
{
    public function listtransport()
    {      
        $data = DonViVanChuyenModel::listtransport();
        $VIEW = "./view/DanhSachDVVC.phtml";
        require("./template/template.phtml");
    }

    public function addtransport()
    {
        if (isset($_REQUEST["tenDVVC"]) && isset($_REQUEST["taiKhoan"]))
        {
            // Kiểm tra tài khoản có tồn tại không và đúng vai trò NCC chưa?
            $checkAcc = TaiKhoanModel::getaccountbyusername($_REQUEST["taiKhoan"]);
            if ($checkAcc)
            {
                $transport = new DonViVanChuyenModel();
                $transport->TenDVVC = $_REQUEST["tenDVVC"];
                $transport->GiayPhepKinhDoanh = $_REQUEST["giayPhepKinhDoanh"];
                $transport->SDT = $_REQUEST["sdt"];
                $transport->DiaChi = $_REQUEST["diaChi"];
                $transport->Email = $_REQUEST["email"];
                $transport->SoTaiKhoanNganHang = $_REQUEST["soTaiKhoanNganHang"];
                $transport->TaiKhoan = $checkAcc->ID;
                $transport->PhiVanChuyen_KM = $_REQUEST["phiVanChuyen_KM"];
                $transport->XetDuyet = $_REQUEST["xetDuyet"];
                $res = DonViVanChuyenModel::addtransport($transport);
                if ($res)
                    echo "<script type='text/javascript'>alert('Thêm thành công');</script>";
                else
                    echo "<script type='text/javascript'>alert('Thêm thất bại');</script>";  
            }
            
        }
        $VIEW = "./view/ThemDVVC.phtml";
        require("./template/template.phtml");
    }

    public function showtoupdatetransport()
    {
        $transport = DonViVanChuyenModel::findonetransport($_REQUEST["madvvc"]);
        $VIEW = "./view/CapNhatDVVC.phtml";
        require("./template/template.phtml");
    }

    public function updatetransport()
    {
        if ($_REQUEST["tenDVVC"] && $_REQUEST["taiKhoan"])
        {
            $newtransport = new DonViVanChuyenModel();
            $newtransport->MaDVVC = $_REQUEST["madvvc"];
            $newtransport->TenDVVC = $_REQUEST["tenDVVC"];
            $newtransport->GiayPhepKinhDoanh = $_REQUEST["giayPhepKinhDoanh"];
            $newtransport->SDT = $_REQUEST["sdt"];
            $newtransport->DiaChi = $_REQUEST["diaChi"];
            $newtransport->Email = $_REQUEST["email"];
            $newtransport->SoTaiKhoanNganHang = $_REQUEST["soTaiKhoanNganHang"];
            $newtransport->TaiKhoan = $_REQUEST["taiKhoan"];
            $newtransport->PhiVanChuyen_KM = $_REQUEST["phiVanChuyen_KM"];
            $newtransport->XetDuyet = $_REQUEST["xetDuyet"];
            $res = DonViVanChuyenModel::updatetransport($newtransport);

            if ($res)
                echo "<script type='text/javascript'>alert('Cập nhật thành công');</script>";
            else
                echo "<script type='text/javascript'>alert('Cập nhật thất bại');</script>";
        }
        $data = DonViVanChuyenModel::listtransport();
        $VIEW = "./view/DanhSachDVVC.phtml";
        require("./template/template.phtml");
    }

    public function deletetransport()
    {
        $transport = DonViVanChuyenModel::findonetransport($_REQUEST["madvvc"]);
        if ($transport)
        {
            DonViVanChuyenModel::deletetransport($transport);

            echo "<script type='text/javascript'>alert('Xóa thành công');</script>";
        }
        $data = DonViVanChuyenModel::listtransport();
        $VIEW = "./view/DanhSachDVVC.phtml";
        require("./template/template.phtml");
    }

    public function accepttranport()
    {
        $newtransport = DonViVanChuyenModel::findonetransport($_REQUEST["madvvc"]);
        $newtransport->XetDuyet = 1;
        $res = DonViVanChuyenModel::updatetransport($newtransport);

        if ($res)
            echo "<script type='text/javascript'>alert('Xét duyệt thành công');</script>";
        else
            echo "<script type='text/javascript'>alert('Xét duyệt thất bại');</script>";
        
        $data = DonViVanChuyenModel::listtransport();
        $VIEW = "./view/DanhSachDVVC.phtml";
        require("./template/template.phtml");
    }

    
}
