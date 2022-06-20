<?php
declare(strict_types=1);
require_once("./Model/TaiKhoan.php");
use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class DonHangModel
    {
        public $MaDH;
        public $NgayLap;
        public $TongTien;
        public $TrangThai;
        public $MaKH;
        public $HinhThucThanhToan;
        public $MaShipper;
    

        function __construct() 
        {
            $this->MaDH = "";
            $this->NgayLap = "";
            $this->TongTien = "";
            $this->TrangThai = "";
            $this->MaKH = "";
            $this->HinhThucThanhToan = "";
            $this->MaShipper = "";
          
        }

        public static function deliveryconfirmation()
        {
            $url = "http://localhost:8053/api/dsdonhang";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dsDH = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $dh = new DonHangModel();
                    $dh->MaDH = $row["maDH"];
                    $dh->NgayLap = $row["ngayLap"];
                    $dh->TongTien = $row["tongTien"];
                    $dh->TrangThai = $row["trangThai"];
                    $dh->MaKH = $row["maKH"];
                    $dh->HinhThucThanhToan = $row["httt"];
                    $dh->MaShipper = $row["maS"];
                    $dsDH[] = $dh; //add an item into array
                }
            }

            return $dsDH;
        }

        public static function confirmorder()
        {
            $url = "http://localhost:8053/api/dsdonhang";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dsDH = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $dh = new DonHangModel();
                    $dh->MaDH = $row["maDH"];
                    $dh->NgayLap = $row["ngayLap"];
                    $dh->TongTien = $row["tongTien"];
                    $dh->TrangThai = $row["trangThai"];
                    $dh->MaKH = $row["maKH"];
                    $dh->HinhThucThanhToan = $row["httt"];
                    $dh->MaShipper = $row["maS"];
                    $dsDH[] = $dh; //add an item into array
                }
            }

            return $dsDH;
        }

  
        public static function findoneorder($MaDH)
        {
            $url = "http://localhost:8053/api/donhang/" . $MaDH;
            
            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dh = new DonHangModel();
            
            if ($response) 
            {     
                $dh->MaDH = $response["maDH"];
                $dh->NgayLap = $response["ngayLap"];
                $dh->TongTien = $response["tongTien"];
                $dh->TrangThai = $response["trangThai"];
                $dh->MaKH = $response["maKH"];
                $dh->HinhThucThanhToan = $response["httt"];
                $dh->MaShipper = $response["maS"];
            }

            return $dh;
        }


        public static function updateorder($order)
        {
            $url = "http://localhost:8053/api/donhang/" . $order->MaDH;
            $data_array =  array(
                "maDH" => $order->MaDH,
                "ngayLap" => $order->NgayLap,
                "tongTien" => $order->TongTien,
                "trangThai" => $order->TrangThai,
                "maKH" => $order->MaKH,
                "httt" => $order->HinhThucThanhToan,
                "maS" => $order->MaShipper
             );

             $update_plan = callAPI('PUT', $url, json_encode($data_array));
             $response = json_decode($update_plan, true);

             return $response;
        }

        public static function updateconfirmorder($order)
        {
            $url = "http://localhost:8053/api/donhang/" . $order->MaDH;
            $data_array =  array(
                "maDH" => $order->MaDH,
                "ngayLap" => $order->NgayLap,
                "tongTien" => $order->TongTien,
                "trangThai" => $order->TrangThai,
                "maKH" => $order->MaKH,
                "httt" => $order->HinhThucThanhToan,
                "maS" => $order->MaShipper
             );

             $update_plan = callAPI('PUT', $url, json_encode($data_array));
             $response = json_decode($update_plan, true);

             return $response;
        }













        public static function listdonhang($makh)
        {
            $url = "http://localhost:8053/api/donhang_kh/" . $makh;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dsDH = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $dh = new DonHangModel();
                    $dh->MaDH = $row["maDH"];
                    $dh->NgayLap = $row["ngayLap"];
                    $dh->TongTien = $row["tongTien"];
                    $dh->TrangThai = $row["trangThai"];
                    $dh->MaKH = $row["maKH"];
                    $dh->HinhThucThanhToan = $row["httt"];
                    $dh->MaShipper = $row["maS"];
                    $dsDH[] = $dh; //add an item into array
                }
            }

            return $dsDH;
        }
    }

?>