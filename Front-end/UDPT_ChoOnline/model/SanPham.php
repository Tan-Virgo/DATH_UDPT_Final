<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class SanPhamModel
    {
        public $MaSP;
        public $TenSP;
        public $DonViTinh;
        public $LoaiSP;


        function __construct() 
        {
            $this->MaSP = "";
            $this->TenSP = "";
            $this->DonViTinh = "";
            $this->LoaiSP = "";
        }

        public static function getlistallproduct()
        {
            $url = "http://localhost:8053/api/dssp";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $sp = new SanPhamModel();
                    $sp->MaSP = $row["maSP"];
                    $sp->TenSP = $row["tenSP"];
                    $sp->DonViTinh = $row["donViTinh"];
                    $sp->URL = $row["loaiSP"];
                    $ds[] = $sp; //add an item into array
                }
            }

            return $ds;
        }
    }
?>