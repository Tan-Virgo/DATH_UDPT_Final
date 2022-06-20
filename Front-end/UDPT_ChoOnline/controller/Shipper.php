<?php

class ShipperController
{
    public function listshipper()
    {   
        $madvvc = $_REQUEST['madvvc'];
        $data = ShipperModel::getListShipperOfTransport($madvvc);
        $transportObject = DonViVanChuyenModel::findonetransport($madvvc);
        $VIEW = "./view/DanhSachShipperOfDVVC.phtml";
        require("./template/template.phtml");
    }

    public function showtoaddshipper()
    {
        $dsDVVC = DonViVanChuyenModel::listtransport();
        $VIEW = "./view/ThemShipper.phtml";
        require("./template/template.phtml");
    }

    public function showtoupdateshipper()
    {
        $dsDVVC = DonViVanChuyenModel::listtransport();
        $shipper = ShipperModel::findoneshipper($_REQUEST["mashipper"]);
        $VIEW = "./view/CapNhatShipper.phtml";
        require("./template/template.phtml");
    }

    public function addshipper()
    {
        if ($_REQUEST["tenShipper"] && $_REQUEST["maDVVC"] && $_REQUEST["taiKhoan"])
        {
            // Kiểm tra tài khoản có tồn tại không và đúng vai trò NCC chưa?
            $checkAcc = TaiKhoanModel::getaccountbyusername($_REQUEST["taiKhoan"]);
            
            if ($checkAcc)
            {
                $shipper = new ShipperModel();
                
                $shipper->TenShipper = $_REQUEST["tenShipper"];
                $shipper->GioiTinh = $_REQUEST["gioiTinh"];
                $shipper->SDT = $_REQUEST["sdt"];
                $shipper->DiaChi = $_REQUEST["diaChi"];
                $shipper->Email = $_REQUEST["email"];
                $shipper->CMND = $_REQUEST["cmnd"];
                $shipper->NgaySinh = $_REQUEST["ngaySinh"];
                $shipper->MaDVVC = $_REQUEST["maDVVC"];
                $shipper->TaiKhoan = $checkAcc->ID;
                $shipper->XetDuyet = $_REQUEST["xetDuyet"];
                
                $res = ShipperModel::addshipper($shipper);
                if ($res)
                    echo "<script type='text/javascript'>alert('Thêm thành công');</script>";
                else
                    echo "<script type='text/javascript'>alert('Thêm thất bại');</script>";  
            }
            
        }

        $dsDVVC = DonViVanChuyenModel::listtransport();
        $VIEW = "./view/ThemShipper.phtml";
        require("./template/template.phtml");
    }

    public function updateshipper()
    {
        $madvvc = $_REQUEST['maDVVC'];
        //$shipperObject = ShipperModel::findoneshipper($mashipper);
        if ($_REQUEST["tenShipper"] && $_REQUEST["taiKhoan"])
        {
            $newshipper = new ShipperModel();
            $newshipper->MaShipper = $_REQUEST["mashipper"];
            $newshipper->TenShipper = $_REQUEST["tenShipper"];
            $newshipper->SDT = $_REQUEST["sdt"];
            $newshipper->DiaChi = $_REQUEST["diaChi"];
            $newshipper->Email = $_REQUEST["email"];
            $newshipper->GioiTinh = $_REQUEST["gioiTinh"];
            $newshipper->CMND = $_REQUEST["cmnd"];
            $newshipper->NgaySinh = $_REQUEST["ngaySinh"];
            $newshipper->MaDVVC = $_REQUEST["maDVVC"];
            $newshipper->TaiKhoan = $_REQUEST["taiKhoan"];
            $newshipper->XetDuyet = $_REQUEST["xetDuyet"];
            $res = ShipperModel::updateshipper($newshipper);

            if ($res)
                echo "<script type='text/javascript'>alert('Cập nhật thành công');</script>";
            else
                echo "<script type='text/javascript'>alert('Cập nhật thất bại');</script>";
        }
        
        $data = ShipperModel::getListShipperOfTransport($madvvc);
        $transportObject = DonViVanChuyenModel::findonetransport($madvvc);
        $VIEW = "./view/DanhSachShipperOfDVVC.phtml";
        require("./template/template.phtml");
    }

    public function deleteshipper()
    {
        
        $newshipper = ShipperModel::findoneshipper($_REQUEST["mashipper"]);
        if ($newshipper)
        {
            ShipperModel::deleteshipper($newshipper);

            echo "<script type='text/javascript'>alert('Xóa thành công');</script>";
        }
        $madvvc = $newshipper->MaDVVC;
        $data = ShipperModel::getListShipperOfTransport($madvvc);
        $transportObject = DonViVanChuyenModel::findonetransport($madvvc);
        $VIEW = "./view/DanhSachShipperOfDVVC.phtml";
        require("./template/template.phtml");
    }


    public function acceptshipper()
    {
        $newshipper = ShipperModel::findoneshipper($_REQUEST["mashipper"]);
        $newshipper->XetDuyet = 1;
        $res = ShipperModel::updateshipper($newshipper);

        if ($res)
            echo "<script type='text/javascript'>alert('Xét duyệt thành công');</script>";
        else
            echo "<script type='text/javascript'>alert('Xét duyệt thất bại');</script>";
        $madvvc = $newshipper->MaDVVC;
        $data = ShipperModel::getListShipperOfTransport($madvvc);
        $transportObject = DonViVanChuyenModel::findonetransport($madvvc);
        $VIEW = "./view/DanhSachShipperOfDVVC.phtml";
        require("./template/template.phtml");
    }

}