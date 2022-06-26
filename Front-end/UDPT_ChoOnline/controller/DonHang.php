
<?php

class DonHangController
{

    public function deliveryconfirmation()
    {
        $data = DonHangModel::deliveryconfirmation();
        $VIEW = "./view/XacNhanGiaoHang.phtml";
        require("./template/template.phtml");
    }

    public function confirmorder()
    {
        $data = array();
        $dataFull = DonHangModel::confirmorder();
        foreach ($dataFull as $item)
        {
            if ($item->TrangThai === "Đang đóng gói")
                $data[] = $item;
        }
        
        $VIEW = "./view/TiepNhanYCVC.phtml";
        require("./template/template.phtml");
    }

    public function showtoupdateorder()
    {
        
        $order = DonHangModel::findoneorder($_REQUEST["madh"]);
        $VIEW = "./view/CapNhatGiaoHang.phtml";
        require("./template/template.phtml");
    }

    public function showtoconfirmorder()
    {
        $order = DonHangModel::findoneorder($_REQUEST["madh"]);
        $dvvc = DonViVanChuyenModel::findonetransport(1);
        $shipper = ShipperModel::findoneshipper($order->MaShipper);
        $dsShipper = ShipperModel::getListShipperOfTransport($dvvc->MaDVVC);
        
        $VIEW = "./view/CapNhatTiepNhanYCVC.phtml";
        require("./template/template.phtml");
    }

    public function updateorder()
    {
        $order = DonHangModel::findoneorder($_REQUEST["madh"]);

        if (isset($_REQUEST["madh"]))
        {
            $neworder = new DonHangModel();
            $neworder->MaDH =  $_REQUEST["madh"];
            $neworder->NgayLap = $_REQUEST["ngayLap"];
            $neworder->TongTien = $_REQUEST["tongTien"];
            $neworder->TrangThai = $_REQUEST["trangThai"];
            $neworder->MaKH = $_REQUEST["maKH"];
            $neworder->HinhThucThanhToan = $_REQUEST["hinhThucThanhToan"];
            $neworder->MaShipper = $_REQUEST["maShipper"];


            $res = DonHangModel::updateorder($neworder);

            if ($res)
                echo "<script type='text/javascript'>alert('Cập nhật thành công');</script>";
            else
                echo "<script type='text/javascript'>alert('Cập nhật thất bại');</script>";
        }

        $data = DonHangModel::deliveryconfirmation();
        $VIEW = "./view/XacNhanGiaoHang.phtml";
        require("./template/template.phtml");
    }

    public function updateconfirmorder()
    {
        $order = DonHangModel::findoneorder($_REQUEST["madh"]);

        if (isset($_REQUEST["madh"]))
        {
            $neworder = new DonHangModel();
            $neworder->MaDH =  $_REQUEST["madh"];
            $neworder->NgayLap = $_REQUEST["ngayLap"];
            $neworder->TongTien = $_REQUEST["tongTien"];
            $neworder->TrangThai = $_REQUEST["trangThai"];
            $neworder->MaKH = $_REQUEST["maKH"];
            $neworder->HinhThucThanhToan = $_REQUEST["hinhThucThanhToan"];
            $neworder->MaShipper = $_REQUEST["maShipper"];


            $res = DonHangModel::updateorder($neworder);

            if ($res)
                echo "<script type='text/javascript'>alert('Cập nhật thành công');</script>";
            else
                echo "<script type='text/javascript'>alert('Cập nhật thất bại');</script>";
        }
        $data = array();
        $dataFull = DonHangModel::confirmorder();
        foreach ($dataFull as $item)
        {
            if ($item->TrangThai === "Đang đóng gói")
                $data[] = $item;
        }
        $VIEW = "./view/TiepNhanYCVC.phtml";
        require("./template/template.phtml");
    }
















    public function listdonhang()
    {
        $taikhoan = TaiKhoanModel::getaccountbyusername($_SESSION["UserName"]);
        $kh = KhachHangModel::findonecustomerbytaikhoan($taikhoan->ID);
        $data = DonHangModel::listdonhang($kh->MaKH);
        $VIEW = "./view/DSDonhang.phtml";
        require("./template/template.phtml");
    }

    public function showtoupdatedonhang()
    {
        $DH = DonHangModel::findoneorder($_REQUEST["madh"]);
        $VIEW = "./view/capnhatDH.phtml";
        require("./template/template.phtml");
    }


    public function updatedonhang()
    {
        $DH = new DonHangModel();
        if (isset($_REQUEST["madh"]))
        {
            $DH->MaDH = $_REQUEST["madh"];
            $DH->TrangThai = $_REQUEST["TrangThai"];
            $DH->NgayLap = $_REQUEST["NgayLap"];
            $DH->TongTien = $_REQUEST["TongTien"];
            $DH->MaKH = $_REQUEST["MaKH"];
            $DH->MaShipper = $_REQUEST["MaShipper"];
            $DH->HinhThucThanhToan = $_REQUEST["HinhThuc"]; 
            
            $res = DonHangModel::updateorder($DH);

            if ($res)
                echo "<script type='text/javascript'>alert('Cập nhật thành công');</script>";
            else
                echo "<script type='text/javascript'>alert('Cập nhật thất bại');</script>";
        
        }

        $makh = KhachHangModel::findonecustomer(1);
        $data = DonHangModel::listdonhang($makh->MaKH);
        $VIEW = "./view/DSDonhang.phtml";
        require("./template/template.phtml");
    }
}