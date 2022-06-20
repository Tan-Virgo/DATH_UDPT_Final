<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class NhuCauCungKyNamModel
    {
        public $Nam;
        public $MaSP;
        public $TenSP;
        public $DonViTinh;
        public $SLBanRa;

        function __construct() 
        {
            $this->Nam = "";
            $this->MaSP = "";
            $this->TenSP = "";
            $this->DonViTinh = "";
            $this->SLBanRa = "";
        }

        public static function getperioddemand()
        {
            $url = "http://localhost:8053/api/nhucaucungkynam";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $p = new NhuCauCungKyNamModel();
                    $p->Nam = $row["nam"];
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