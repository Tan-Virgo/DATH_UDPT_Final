<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class NhuCauCungKyModel
    {
        public $ID;
        public $Nam;
        public $Quy;
        public $Thang;
        public $MaSP;
        public $TenSP;
        public $DonViTinh;
        public $SLBanRa;

        function __construct() 
        {
            $this->ID = "";
            $this->Nam = "";
            $this->Quy = "";
            $this->Thang = "";
            $this->MaSP = "";
            $this->TenSP = "";
            $this->DonViTinh = "";
            $this->SLBanRa = "";
        }

        public static function getperioddemand()
        {
            $url = "http://localhost:8053/api/nhucaucungky";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $p = new NhuCauCungKyModel();
                    $p->Nam = $row["nam"];
                    $p->Quy = $row["quy"];
                    $p->Thang = $row["thang"];
                    $p->MaSP = $row["maSP"];
                    $p->TenSP = $row["tenSP"];
                    $p->DonViTinh = $row["donViTinh"];
                    $p->SLBanRa = $row["slbanRa"];
                    $ds[] = $p;
                }
            }

            return $ds;
        }

     
    }

?>