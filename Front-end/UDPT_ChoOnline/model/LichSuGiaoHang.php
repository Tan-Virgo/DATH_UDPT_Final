<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class LichSuGiaoHangModel
    {
        public $MaDH;
        public $MaShipper;
        public $TenKH;
        public $DiaChi;
        public $TenShipper;
        public $SDTKhachHang;
        public $TenDVVC;
        public $NgayLap;
        public $TrangThai;
        public $HinhThucThanhToan;
        public $TongTien;

        function __construct() 
        {
            $this->MaDH = "";
            $this->MaShipper = "";
            $this->TenKH = "";
            $this->DiaChi = "";
            $this->TenShipper = "";
            $this->SDTKhachHang = "";
            $this->TenDVVC = "";
            $this->NgayLap = "";
            $this->TrangThai = "";
            $this->HinhThucThanhToan = "";
            $this->TongTien = "";
        }

        public static function deliveryhistory($madvvc)
        {
            $url = "http://localhost:8053/api/lichsugiaohang/" . $madvvc;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $ds = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $p = new LichSuGiaoHangModel();
                    $p->MaDH = $row["maDH"];
                    $p->MaShipper = $row["maShipper"];
                    $p->TenKH = $row["tenKH"];
                    $p->DiaChi = $row["diaChi"];
                    $p->TenShipper = $row["tenShipper"];
                    $p->SDTKhachHang = $row["sdt"];
                    $p->TenDVVC = $row["tenDVVC"];
                    $p->NgayLap = $row["ngayLap"];
                    $p->TrangThai = $row["trangThai"];
                    $p->HinhThucThanhToan = $row["hinhThucThanhToan"];                 
                    $p->TongTien = $row["tongTien"];
                    $ds[] = $p;
                }
            }

            return $ds;
        }

     
    }

?>