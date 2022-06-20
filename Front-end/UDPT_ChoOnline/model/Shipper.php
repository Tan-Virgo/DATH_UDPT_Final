<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class ShipperModel
    {
        public $MaShipper;
        public $TenShipper;
        public $SDT;
        public $GioiTinh;
        public $DiaChi;
        public $Email;
        public $CMND;
        public $NgaySinh;
        public $MaDVVC;
        public $TaiKhoan;
        public $XetDuyet;

        function __construct() 
        {
            $this->MaShipper = "";
            $this->TenShipper = "";
            $this->SDT = "";
            $this->GioiTinh = "";
            $this->DiaChi = "";
            $this->Email = "";
            $this->CMND = "";
            $this->NgaySinh = "";
            $this->MaDVVC = "";
            $this->TaiKhoan = "";
            $this->XetDuyet = "";
        }

        public static function getListShipperOfTransport($madvvc)
        {
            $url = "http://localhost:8053/api/dsshipper/" . $madvvc;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dsShipper = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $Shipper = new ShipperModel();
                    $Shipper->MaShipper = $row["maShipper"];
                    $Shipper->TenShipper = $row["tenShipper"];
                    $Shipper->GioiTinh = $row["gioiTinh"];
                    $Shipper->SDT = $row["sdt"];
                    $Shipper->DiaChi = $row["diaChi"];
                    $Shipper->Email = $row["email"];
                    $Shipper->CMND = $row["cmnd"];
                    $Shipper->NgaySinh = $row["ngaySinh"];
                    $Shipper->MaDVVC = $row["maDVVC"];
                    $Shipper->TaiKhoan = $row["taiKhoan"];
                    $Shipper->XetDuyet = $row["xetDuyet"];
                    $dsShipper[] = $Shipper; //add an item into array
                }
            }

            return $dsShipper;
        }

        public static function addshipper($shipper)
        {
            $url = "http://localhost:8053/api/shipper";
            
            $data_array =  array(
                "tenShipper" => $shipper->TenShipper,
                "sdt" => $shipper->SDT,
                "diaChi" => $shipper->DiaChi,
                "email" => $shipper->Email,
                "gioiTinh" => $shipper->GioiTinh,
                "ngaySinh" => $shipper->NgaySinh,
                "cmnd" => $shipper->CMND,
                "maDVVC" => $shipper->MaDVVC,
                "taiKhoan" => $shipper->TaiKhoan,
                "xetDuyet" => $shipper->XetDuyet
            );
        

            $make_call = callAPI('POST', $url, json_encode($data_array));
            $response = json_decode($make_call, true);

            return $response;
        }

        public static function findoneshipper($MaShipper)
        {
            $url = "http://localhost:8053/api/shipper/" . $MaShipper;
            
            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $s = new ShipperModel();
            
            if ($response) 
            {            
                $s->MaShipper = $response["maShipper"];
                $s->TenShipper = $response["tenShipper"];
                $s->GioiTinh = $response["gioiTinh"];
                $s->SDT = $response["sdt"];
                $s->DiaChi = $response["diaChi"];
                $s->Email = $response["email"];
                $s->CMND = $response["cmnd"];
                $s->NgaySinh = $response["ngaySinh"];
                $s->MaDVVC = $response["maDVVC"];
                $s->TaiKhoan = $response["taiKhoan"];
                $s->XetDuyet = $response["xetDuyet"];
            }

            return $s;
        }


        public static function updateshipper($shipper)
        {
            $url = "http://localhost:8053/api/shipper/" . $shipper->MaShipper;

            $data_array =  array(
                "tenShipper" => $shipper->TenShipper,
                "gioiTinh" => $shipper->GioiTinh,
                "sdt" => $shipper->SDT,
                "diaChi" => $shipper->DiaChi,
                "email" => $shipper->Email,
                "cmnd" => $shipper->CMND,
                "ngaySinh" => $shipper->NgaySinh,
                "maDVVC" => $shipper->MaDVVC,
                "taiKhoan" => $shipper->TaiKhoan,
                "xetDuyet" => $shipper->XetDuyet
             );

             $update_plan = callAPI('PUT', $url, json_encode($data_array));
             $response = json_decode($update_plan, true);

             return $response;
        }

        public static function deleteshipper($shipper)
        {
            $url = "http://localhost:8053/api/shipper/" . $shipper->MaShipper;

            callAPI('DELETE', $url, false);
        }

    }

?>