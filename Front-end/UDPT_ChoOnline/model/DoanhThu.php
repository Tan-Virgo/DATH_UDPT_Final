<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class DoanhThuModel
    {
        public $Nam;
        public $Quy;
        public $Thang;
        public $MaNCC;
        public $TenNCC;
        public $DoanhThu;

        function __construct() 
        {
            $this->Nam = "";
            $this->Quy = "";
            $this->Thang = "";
            $this->MaNCC = "";
            $this->TenNCC = "";
            $this->DoanhThu = "";
        }

        public static function getturnover($mancc)
        {
            $url = "http://localhost:8053/api/doanhthu/" . $mancc;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $p = new DoanhThuModel();
                    $p->Nam = $row["nam"];
                    $p->Quy = $row["quy"];
                    $p->Thang = $row["thang"];
                    $p->MaNCC = $row["maNCC"];
                    $p->TenNCC = $row["tenNCC"];
                    $p->DoanhThu = $row["doanhThu"];
                    $ds[] = $p;
                }
            }

            return $ds;
        }

        public static function getturnoverpresent($mancc)
        {
            $date = getdate();
            $url = "http://localhost:8053/api/doanhthu/" . $mancc . "/" . $date["year"];

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $p = new DoanhThuModel();
                    $p->Nam = $row["nam"];
                    $p->Quy = $row["quy"];
                    $p->Thang = $row["thang"];
                    $p->MaNCC = $row["maNCC"];
                    $p->TenNCC = $row["tenNCC"];
                    $p->DoanhThu = $row["doanhThu"];
                    $ds[] = $p;
                }
            }

            return $ds;
        }
    }

?>