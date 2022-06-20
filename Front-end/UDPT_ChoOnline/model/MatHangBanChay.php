<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class MatHangBanChayModel
    {
        public $MaLoaiSP;
        public $TenLoaiSP;
        public $MaSP;
        public $TenSP;
        public $MaNCC;
        public $TenNCC;
        public $DonViTinh;
        public $Gia;
        public $NSX;
        public $SLBanRa;

        function __construct() 
        {
            $this->MaLoaiSP = "";
            $this->TenLoaiSP = "";
            $this->MaSP = "";
            $this->TenSP = "";
            $this->MaNCC = "";
            $this->TenNCC = "";
            $this->DonViTinh = "";
            $this->Gia = "";
            $this->NSX = "";
            $this->SLBanRa = "";
        }

        public static function getTopProduct()
        {
            $url = "http://localhost:8053/api/mathangbanchay";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $p = new MatHangBanChayModel();
                    $p->MaLoaiSP = $row["maLoaiSP"];
                    $p->TenLoaiSP = $row["tenLoaiSP"];
                    $p->MaSP = $row["maSP"];
                    $p->TenSP = $row["tenSP"];
                    $p->MaNCC = $row["maNCC"];
                    $p->TenNCC = $row["tenNCC"];
                    $p->DonViTinh = $row["donViTinh"];
                    $p->Gia = $row["gia"];
                    $p->NSX = $row["ns"];
                    $p->SLBanRa = $row["slbanRa"];
                    $ds[] = $p;
                }
            }

            return $ds;
        }

     
    }

?>