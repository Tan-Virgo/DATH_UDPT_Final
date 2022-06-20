<?php

class SanPham_NCCController
{

    public function listproductofsupplier()
    {
        $supplier = NhaCungCapModel::findonesupplier($_REQUEST["mancc"]);
        $data = SanPham_NCCModel::getlistproductofsupplier($_REQUEST["mancc"]);
        $VIEW = "./view/DanhSachSP_NCC.phtml";
        require("./template/template.phtml");
    }

    public function listallproductofsupplier()
    {
        $data = SanPham_NCCModel::getlistallproductofsupplier();
        $VIEW = "./view/DanhSachSanPhamNCC.phtml";
        require("./template/template.phtml");
    }


    public function listproductsupplier()
    {
        if (isset($_REQUEST["maSP"]))
        {
            $data = SanPham_NCCModel::listproductsupplier($_REQUEST["masp"]);
        }
        $VIEW = "./view/DanhSachSanPhamNCC.phtml";
        require("./template/template.phtml");
    }


    public function productdetail()
    {
        $prod = $_REQUEST["id"];
        $data = SanPham_NCCModel::productdetail($prod);
        $VIEW = "./view/DetailSP.phtml";
        require("./template/template.phtml");
    }

}