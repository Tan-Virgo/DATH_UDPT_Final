<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class SanPham_NCCModel
    {
        public $ID;
        public $MaNCC;
        public $MaSP;
        public $TenSP;
        public $DonViTinh;
        public $NSX;
        public $Gia;
        public $Url;

        function __construct() 
        {
            $this->ID = "";
            $this->MaNCC = "";
            $this->MaSP = "";
            $this->TenSP = "";
            $this->DonViTinh = "";
            $this->NSX = "";
            $this->Gia = "";
            $this->Url = "";
        }

        public static function getlistallproductofsupplier()
        {
            $url = "http://localhost:8053/api/sanpham_ncc";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $sp = new SanPham_NCCModel();
                    $sp->ID = $row["id"];
                    $sp->MaNCC = $row["maNCC"];
                    $sp->MaSP = $row["masp"];
                    $sp->TenSP = $row["tenSP"];
                    $sp->DonViTinh = $row["donViTinh"];
                    $sp->NSX = $row["nsx"];
                    $sp->Gia = $row["gia"];
                    $sp->URL = $row["url"];
                    $ds[] = $sp; //add an item into array
                }
            }

            return $ds;
        }



        public static function getlistproductofsupplier($mancc)
        {
            $url = "http://localhost:8053/api/sanpham_ncc/" . $mancc;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $sp = new SanPham_NCCModel();
                    $sp->ID = $row["id"];
                    $sp->MaNCC = $row["maNCC"];
                    $sp->MaSP = $row["masp"];
                    $sp->TenSP = $row["tenSP"];
                    $sp->SDT = $row["donViTinh"];
                    $sp->NSX = $row["nsx"];
                    $sp->Gia = $row["gia"];
                    $ds[] = $sp; //add an item into array
                }
            }

            return $ds;
        }

        public static function listproductsupplier($masp)
        {
            $url = "http://localhost:8053/api/ncc_sanpham/" . $masp;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $sp = new SanPham_NCCModel();
                    $sp->ID = $row["id"];
                    $sp->MaNCC = $row["maNCC"];
                    $sp->MaSP = $row["masp"];
                    $sp->TenSP = $row["tenSP"];
                    $sp->DonViTinh = $row["donViTinh"];
                    $sp->NSX = $row["nsx"];
                    $sp->Gia = $row["gia"];
                    $sp->URL = $row["url"];
                    $ds[] = $sp; //add an item into array
                }
            }

            return $ds;
        }

        public static function productdetail($id)
        {
            $url = "http://localhost:8053/api/spncc/" . $id;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);

            if ($response) 
            {            
                $sp = new SanPham_NCCModel();
                $sp->ID = $response["id"];
                $sp->MaNCC = $response["maNCC"];
                $sp->MaSP = $response["masp"];
                $sp->TenSP = $response["tenSP"];
                $sp->DonViTinh = $response["donViTinh"];
                $sp->NSX = $response["nsx"];
                $sp->Gia = $response["gia"];
                $sp->URL = $response["url"];
            }

            return $sp;
        }

    }

?>