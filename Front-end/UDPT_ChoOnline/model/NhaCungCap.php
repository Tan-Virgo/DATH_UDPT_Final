<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class NhaCungCapModel
    {
        public $MaNCC;
        public $TenNCC;
        public $GiayPhepKinhDoanh;
        public $SDT;
        public $DiaChi;
        public $Email;
        public $SoTaiKhoanNganHang;
        public $TaiKkhoan;
        public $XetDuyet;

        function __construct() 
        {
            $this->MaNCC = "";
            $this->TenNCC = "";
            $this->GiayPhepKinhDoanh = "";
            $this->SDT = "";
            $this->DiaChi = "";
            $this->Email = "";
            $this->SoTaiKhoanNganHang = "";
            $this->TaiKhoan = "";
            $this->XetDuyet = "";
        }

        public static function listsupplier()
        {
            $url = "http://localhost:8053/api/dsnhacungcap";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dsNCC = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $ncc = new NhaCungCapModel();
                    $ncc->MaNCC = $row["maNCC"];
                    $ncc->TenNCC = $row["tenNCC"];
                    $ncc->GiayPhepKinhDoanh = $row["giayPhepKinhDoanh"];
                    $ncc->SDT = $row["sdt"];
                    $ncc->DiaChi = $row["diaChi"];
                    $ncc->Email = $row["email"];
                    $ncc->SoTaiKhoanNganHang = $row["soTaiKhoanNganHang"];
                    $ncc->TaiKhoan = $row["taiKhoan"];
                    $ncc->XetDuyet = $row["xetDuyet"];
                    $dsNCC[] = $ncc; //add an item into array
                }
            }

            return $dsNCC;
        }

        public static function addsupplier($supplier)
        {
            $url = "http://localhost:8053/api/nhacungcap";

            $data_array =  array(
                "tenNCC" => $supplier->TenNCC,
                "giayPhepKinhDoanh" => $supplier->GiayPhepKinhDoanh,
                "sdt" => $supplier->SDT,
                "diaChi" => $supplier->DiaChi,
                "email" => $supplier->Email,
                "soTaiKhoanNganHang" => $supplier->SoTaiKhoanNganHang,
                "taiKhoan" => $supplier->TaiKhoan,
                "xetDuyet" => $supplier->XetDuyet
             );

            $make_call = callAPI('POST', $url, json_encode($data_array));
            $response = json_decode($make_call, true);

            return $response;
        }

        public static function findonesupplier($MaNCC)
        {
            $url = "http://localhost:8053/api/nhacungcap/" . $MaNCC;
            
            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ncc = new NhaCungCapModel();
            
            if ($response) 
            {            
                $ncc->MaNCC = $response["maNCC"];
                $ncc->TenNCC = $response["tenNCC"];
                $ncc->GiayPhepKinhDoanh = $response["giayPhepKinhDoanh"];
                $ncc->SDT = $response["sdt"];
                $ncc->DiaChi = $response["diaChi"];
                $ncc->Email = $response["email"];
                $ncc->SoTaiKhoanNganHang = $response["soTaiKhoanNganHang"];
                $ncc->TaiKhoan = $response["taiKhoan"];
                $ncc->XetDuyet = $response["xetDuyet"];
            }

            return $ncc;
        }


        public static function findonesupplierbytaikhoan($tk)
        {
            $url = "http://localhost:8053/api/nhacungcap_taikhoan/" . $tk;
            
            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ncc = new NhaCungCapModel();
            
            if ($response) 
            {            
                $ncc->MaNCC = $response["maNCC"];
                $ncc->TenNCC = $response["tenNCC"];
                $ncc->GiayPhepKinhDoanh = $response["giayPhepKinhDoanh"];
                $ncc->SDT = $response["sdt"];
                $ncc->DiaChi = $response["diaChi"];
                $ncc->Email = $response["email"];
                $ncc->SoTaiKhoanNganHang = $response["soTaiKhoanNganHang"];
                $ncc->TaiKhoan = $response["taiKhoan"];
                $ncc->XetDuyet = $response["xetDuyet"];
            }

            return $ncc;
        }


        public static function updatesupplier($supplier)
        {
            $url = "http://localhost:8053/api/nhacungcap/" . $supplier->MaNCC;

            $data_array =  array(
                "maNCC" => $supplier->MaNCC,
                "tenNCC" => $supplier->TenNCC,
                "giayPhepKinhDoanh" => $supplier->GiayPhepKinhDoanh,
                "sdt" => $supplier->SDT,
                "diaChi" => $supplier->DiaChi,
                "email" => $supplier->Email,
                "soTaiKhoanNganHang" => $supplier->SoTaiKhoanNganHang,
                "taiKhoan" => $supplier->TaiKhoan,
                "xetDuyet" => $supplier->XetDuyet
             );

             $update_plan = callAPI('PUT', $url, json_encode($data_array));
             $response = json_decode($update_plan, true);

             return $response;
        }

        public static function deletesupplier($supplier)
        {
            $url = "http://localhost:8053/api/nhacungcap/" . $supplier->MaNCC;

            callAPI('DELETE', $url, false);
        }

    }

?>