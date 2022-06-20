<?php

use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

class PhanhoiModel
{
    public $maphanhoi;
    public $chitiet;
    public $ngaytao;
    public $nguoidung;
    public $sanpham;
    public $nhacungcap;

    function __construct()
    {
        $this->maphanhoi="";
        $this->chitiet="";
        $this->ngaytao="";
        $this->nguoidung="";
        $this->sanpham="";
        $this->nhacungcap="";
    }

    public static function listphanhoi()
    {
        $url = "http://localhost:8053/api/phanhoi";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dsDVVC = array();

            if ($response) 
            {            
                foreach ($response as $row) 
                {
                    $DVVC = new PhanhoiModel();
                    $DVVC->maphanhoi = $row["maphanhoi"];
                    $DVVC->chitiet = $row["chitiet"];
                    $DVVC->ngaytao = $row["ngaytao"];
                    $DVVC->nguoidung = $row["nguoidung"];
                    $DVVC->sanpham = $row["sanpham"];
                    $DVVC->nhacungcap = $row["nhacungcap"];
                    $dsDVVC[] = $DVVC; //add an item into array
                }
            }
            return $dsDVVC;
    }

    public static function createPhanhoi($Phanhoi)
    {
        $url = "http://localhost:8053/api/phanhoi";
                            
            $data_array = array(                
                "chitiet" => $Phanhoi->chitiet,
                "ngaytao" => $Phanhoi->ngaytao,
                "nguoidung" => $Phanhoi->nguoidung,
                "sanpham" => $Phanhoi->sanpham,
                "nhacungcap" => $Phanhoi->nhacungcap
            );

            $upd_data = callAPI('POST', $url, json_encode(($data_array)));
            $response = json_decode($upd_data, true);
            return $response;
    }
}
?>