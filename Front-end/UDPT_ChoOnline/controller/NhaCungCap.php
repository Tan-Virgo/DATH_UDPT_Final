<?php

class NhaCungCapController
{

    public function listsupplier()
    {
        $data = NhaCungCapModel::listsupplier();
        $VIEW = "./view/DanhSachNCC.phtml";
        require("./template/template.phtml");
    }

    public function addsupplier()
    {
        if (isset($_REQUEST["tenNCC"]) && isset($_REQUEST["taiKhoan"]))
        {
            // Kiểm tra tài khoản có tồn tại không và đúng vai trò NCC chưa?
            $checkAcc = TaiKhoanModel::getaccountbyusername($_REQUEST["taiKhoan"]);
            if ($checkAcc)
            {

                $supplier = new NhaCungCapModel();
                $supplier->TenNCC = $_REQUEST["tenNCC"];
                $supplier->GiayPhepKinhDoanh = $_REQUEST["giayPhepKinhDoanh"];
                $supplier->SDT = $_REQUEST["sdt"];
                $supplier->DiaChi = $_REQUEST["diaChi"];
                $supplier->Email = $_REQUEST["email"];
                $supplier->SoTaiKhoanNganHang = $_REQUEST["soTaiKhoanNganHang"];
                $supplier->TaiKhoan = $checkAcc->ID;
                $supplier->XetDuyet = $_REQUEST["xetDuyet"];
                $res = NhaCungCapModel::addsupplier($supplier);
                if ($res)
                    echo "<script type='text/javascript'>alert('Thêm thành công');</script>";
                else
                    echo "<script type='text/javascript'>alert('Thêm thất bại');</script>";  
            }
            
        }
        $VIEW = "./view/ThemNCC.phtml";
        require("./template/template.phtml");
    }

    public function showtoupdatesupplier()
    {
        $supplier = NhaCungCapModel::findonesupplier($_REQUEST["mancc"]);
        $VIEW = "./view/CapNhatNCC.phtml";
        require("./template/template.phtml");
    }

    public function updatesupplier()
    {
        if ($_REQUEST["tenNCC"] && $_REQUEST["taiKhoan"])
        {
            $newsuppler = new NhaCungCapModel();
            $newsuppler->MaNCC = $_REQUEST["mancc"];
            $newsuppler->TenNCC = $_REQUEST["tenNCC"];
            $newsuppler->GiayPhepKinhDoanh = $_REQUEST["giayPhepKinhDoanh"];
            $newsuppler->SDT = $_REQUEST["sdt"];
            $newsuppler->DiaChi = $_REQUEST["diaChi"];
            $newsuppler->Email = $_REQUEST["email"];
            $newsuppler->SoTaiKhoanNganHang = $_REQUEST["soTaiKhoanNganHang"];
            $newsuppler->TaiKhoan = $_REQUEST["taiKhoan"];
            $newsuppler->XetDuyet = $_REQUEST["xetDuyet"];
            $res = NhaCungCapModel::updatesupplier($newsuppler);

            if ($res)
                echo "<script type='text/javascript'>alert('Cập nhật thành công');</script>";
            else
                echo "<script type='text/javascript'>alert('Cập nhật thất bại');</script>";
        }
        $data = NhaCungCapModel::listsupplier();
        $VIEW = "./view/DanhSachNCC.phtml";
        require("./template/template.phtml");
    }

    public function deletesupplier()
    {
        $supplier = NhaCungCapModel::findonesupplier($_REQUEST["mancc"]);
        if ($supplier)
        {
            NhaCungCapModel::deletesupplier($supplier);
            echo "<script type='text/javascript'>alert('Xóa thành công');</script>";
        }
        $data = NhaCungCapModel::listsupplier();
        $VIEW = "./view/DanhSachNCC.phtml";
        require("./template/template.phtml");
    }


    public function acceptsupplier()
    {
        $newsuppler = NhaCungCapModel::findonesupplier($_REQUEST["mancc"]);
            
        $newsuppler->XetDuyet = 1;

        $res = NhaCungCapModel::updatesupplier($newsuppler);

        if ($res)
            echo "<script type='text/javascript'>alert('Xét duyệt thành công');</script>";
        else
            echo "<script type='text/javascript'>alert('Xét duyệt thất bại');</script>";

        $data = NhaCungCapModel::listsupplier();
        $VIEW = "./view/DanhSachNCC.phtml";
        require("./template/template.phtml");
    }
}

