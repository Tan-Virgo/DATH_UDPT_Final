<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class KhachHangModel
    {
        public $MaKH;
        public $TenKH;
        public $NgaySinh;
        public $SDT;
        public $DiaChi;
        public $Email;
        public $CMND;
        public $MaLoaiKH;
        public $TaiKhoan;

        function __construct() 
        {
            $this->MaKH = "";
            $this->TenKH = "";
            $this->NgaySinh = "";
            $this->SDT = "";
            $this->DiaChi = "";
            $this->Email = "";
            $this->CMND = "";
            $this->MaLoaiKH = "";
            $this->TaiKhoan = "";
        }

        public static function findonecustomer($makh)
        {
            $url = "http://localhost:8053/api/khachhang/" . $makh;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $kh = new KhachHangModel();
            if ($response) 
            {              
                $kh->MaKH = $response["maKH"];
                $kh->TenKH = $response["tenKH"];
                $kh->NgaySinh = $response["ngaySinh"];
                $kh->SDT = $response["sdt"];
                $kh->DiaChi = $response["diaChi"];
                $kh->Email = $response["email"];
                $kh->CMND = $response["cmnd"];
                $kh->MaLoaiKH = $response["maLoaiKH"];
                $kh->TaiKhoan = $response["taiKhoan"];
            }

            return $kh;
        }

        public static function findonecustomerbytaikhoan($tk)
        {
            $url = "http://localhost:8053/api/khachhang_taikhoan/" . $tk;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $kh = new KhachHangModel();
            if ($response) 
            {              
                $kh->MaKH = $response["maKH"];
                $kh->TenKH = $response["tenKH"];
                $kh->NgaySinh = $response["ngaySinh"];
                $kh->SDT = $response["sdt"];
                $kh->DiaChi = $response["diaChi"];
                $kh->Email = $response["email"];
                $kh->CMND = $response["cmnd"];
                $kh->MaLoaiKH = $response["maLoaiKH"];
                $kh->TaiKhoan = $response["taiKhoan"];
            }

            return $kh;
        }


    }

?>