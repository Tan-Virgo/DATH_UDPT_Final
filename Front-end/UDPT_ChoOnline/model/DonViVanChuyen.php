<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class DonViVanChuyenModel
    {
        public $MaDVVC;
        public $TenDVVC;
        public $GiayPhepKinhDoanh;
        public $SDT;
        public $DiaChi;
        public $Email;
        public $SoTaiKhoanNganHang;
        public $PhiVanChuyen_KM;
        public $TaiKhoan;
        public $XetDuyet;

        function __construct() 
        {
            $this->MaDVVC = "";
            $this->TenDVVC = "";
            $this->GiayPhepKinhDoanh = "";
            $this->SDT = "";
            $this->DiaChi = "";
            $this->Email = "";
            $this->SoTaiKhoanNganHang = "";
            $this->PhiVanChuyen_KM = "";
            $this->TaiKhoan = "";
            $this->XetDuyet = "";
        }

        public static function listtransport()
        {
            $url = "http://localhost:8053/api/dsdonvivanchuyen";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dsDVVC = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $DVVC = new DonViVanChuyenModel();
                    $DVVC->MaDVVC = $row["maDVVC"];
                    $DVVC->TenDVVC = $row["tenDVVC"];
                    $DVVC->GiayPhepKinhDoanh = $row["giayPhepKinhDoanh"];
                    $DVVC->SDT = $row["sdt"];
                    $DVVC->DiaChi = $row["diaChi"];
                    $DVVC->Email = $row["email"];
                    $DVVC->SoTaiKhoanNganHang = $row["soTaiKhoanNganHang"];
                    $DVVC->PhiVanChuyen_KM = $row["phiVanChuyen_KM"];
                    $DVVC->TaiKhoan = $row["taiKhoan"];
                    $DVVC->XetDuyet = $row["xetDuyet"];
                    $dsDVVC[] = $DVVC; //add an item into array
                }
            }

            return $dsDVVC;
        }

        public static function findonetransport($madvvc)
        {
            $url = "http://localhost:8053/api/donvivanchuyen/" . $madvvc;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dvvc = new DonViVanChuyenModel();
            if ($response) 
            {              
                $dvvc->MaDVVC = $response["maDVVC"];
                $dvvc->TenDVVC = $response["tenDVVC"];
                $dvvc->GiayPhepKinhDoanh = $response["giayPhepKinhDoanh"];
                $dvvc->SDT = $response["sdt"];
                $dvvc->DiaChi = $response["diaChi"];
                $dvvc->Email = $response["email"];
                $dvvc->SoTaiKhoanNganHang = $response["soTaiKhoanNganHang"];
                $dvvc->PhiVanChuyen_KM = $response["phiVanChuyen_KM"];
                $dvvc->TaiKhoan = $response["taiKhoan"];
                $dvvc->XetDuyet = $response["xetDuyet"];
            }

            return $dvvc;
        }

        public static function findonetransportbytaikhoan($tk)
        {
            $url = "http://localhost:8053/api/donvivanchuyen_taikhoan/" . $tk;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dvvc = new DonViVanChuyenModel();
            if ($response) 
            {              
                $dvvc->MaDVVC = $response["maDVVC"];
                $dvvc->TenDVVC = $response["tenDVVC"];
                $dvvc->GiayPhepKinhDoanh = $response["giayPhepKinhDoanh"];
                $dvvc->SDT = $response["sdt"];
                $dvvc->DiaChi = $response["diaChi"];
                $dvvc->Email = $response["email"];
                $dvvc->SoTaiKhoanNganHang = $response["soTaiKhoanNganHang"];
                $dvvc->PhiVanChuyen_KM = $response["phiVanChuyen_KM"];
                $dvvc->TaiKhoan = $response["taiKhoan"];
                $dvvc->XetDuyet = $response["xetDuyet"];
            }

            return $dvvc;
        }

        public static function addtransport($transport)
        {
            $url = "http://localhost:8053/api/donvivanchuyen";

            $data_array =  array(
                "tenDVVC" => $transport->TenDVVC,
                "giayPhepKinhDoanh" => $transport->GiayPhepKinhDoanh,
                "sdt" => $transport->SDT,
                "diaChi" => $transport->DiaChi,
                "email" => $transport->Email,
                "soTaiKhoanNganHang" => $transport->SoTaiKhoanNganHang,
                "taiKhoan" => $transport->TaiKhoan,
                "phiVanChuyen_KM" => $transport->PhiVanChuyen_KM,
                "xetDuyet" => $transport->XetDuyet
             );

            $make_call = callAPI('POST', $url, json_encode($data_array));
            $response = json_decode($make_call, true);

            return $response;
        }


        public static function updatetransport($transport)
        {
            $url = "http://localhost:8053/api/donvivanchuyen/" . $transport->MaDVVC;

            $data_array =  array(
                "maDVVC" => $transport->MaDVVC,
                "tenDVVC" => $transport->TenDVVC,
                "giayPhepKinhDoanh" => $transport->GiayPhepKinhDoanh,
                "sdt" => $transport->SDT,
                "diaChi" => $transport->DiaChi,
                "email" => $transport->Email,
                "soTaiKhoanNganHang" => $transport->SoTaiKhoanNganHang,
                "taiKhoan" => $transport->TaiKhoan,
                "phiVanChuyen_KM" => $transport->PhiVanChuyen_KM,
                "xetDuyet" => $transport->XetDuyet
             );

             $update_plan = callAPI('PUT', $url, json_encode($data_array));
             $response = json_decode($update_plan, true);

             return $response;
        }

        public static function deletetransport($transport)
        {
            $url = "http://localhost:8053/api/donvivanchuyen/" . $transport->MaDVVC;

            callAPI('DELETE', $url, false);
        }

       

    }

?>