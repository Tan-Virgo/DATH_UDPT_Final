<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class LichSuMuaHangModel
    {
        public $ID;
        public $MaDH;
        public $TenSP;
        public $TenNCC;
        public $NhaSanXuat;
        public $Gia;
        public $SoLuong;
        public $DonViTinh;
        public $NgayLap;
        public $HinhThucThanhToan;
        public $TongTien;

        function __construct() 
        {
            $this->ID = "";
            $this->MaDH = "";
            $this->TenSP = "";
            $this->TenNCC = "";
            $this->NhaSanXuat = "";
            $this->Gia = "";
            $this->SoLuong = "";
            $this->DonViTinh = "";
            $this->NgayLap = "";
            $this->HinhThucThanhToan = "";
            $this->TongTien = "";
        }

        public static function purchasinghistory($makh)
        {
            $url = "http://localhost:8053/api/lichsumuahang/" . $makh;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $p = new LichSuMuaHangModel();
                    $p->MaDH = $row["maDH"];
                    $p->TenSP = $row["tenSP"];
                    $p->TenNCC = $row["tenNCC"];
                    if(isset($row["nsx"])){
                    $p->NhaSanXuat = $row["nsx"];}
                    $p->Gia = $row["gia"];
                    $p->SoLuong = $row["soLuong"];
                    $p->DonViTinh = $row["donViTinh"];
                    $p->NgayLap = $row["ngayLap"];
                    $p->HinhThucThanhToan = $row["hinhThucThanhToan"];                 
                    $p->TongTien = $row["tongTien"];
                    $ds[] = $p;
                }
            }

            return $ds;
        }

     
    }

?>