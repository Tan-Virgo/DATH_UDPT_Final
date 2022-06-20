<?php
declare(strict_types=1);

use Tobscure\JsonApi\Parameters;

require_once("./Model/CallAPI.php");

    class TaiKhoanModel
    {
        public $ID;
        public $Username;
        public $Password;
        public $TrangThai;
        public $VaiTro;

        function __construct() 
        {
            $this->ID = "";
            $this->Username = "";
            $this->Password = "";
            $this->TrangThai = "";
            $this->VaiTro = "";
        }

        public static function listaccount()
        {
            $url = "http://localhost:8053/api/dstaikhoan";

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);
            
            $dsNCC = array();

            if ($response) 
            {            
                foreach ($response as $row) {
                    $ncc = new TaiKhoanModel();
                    $ncc->ID = $row["id"];
                    $ncc->Username = $row["username"];
                    $ncc->Password = $row["password"];
                    $ncc->TrangThai = $row["trangThai"];
                    $ncc->VaiTro = $row["vaiTro"];
                    $dsNCC[] = $ncc; //add an item into array
                }
            }

            return $dsNCC;
        }

        public static function addaccount($account)
        {
            $url = "http://localhost:8053/api/taikhoan";

            $data_array =  array(
                "username" => $account->Username,
                "password" => $account->Password,
                "vaiTro" => $account->VaiTro,
                "trangThai" => $account->TrangThai
             );

            $make_call = callAPI('POST', $url, json_encode($data_array));
            $response = json_decode($make_call, true);

            return $response;
        }

        public static function getaccountbyusername($username)
        {
            $url = "http://localhost:8053/api/taikhoan/" . $username;

            $get_data = callAPI('GET', $url, false);
            $response = json_decode($get_data, true);

            $tk = new NhaCungCapModel();

            if ($response) 
            {        
                $tk->ID = $response["id"];    
                $tk->Username = $response["username"];
                $tk->Password = $response["password"];
                $tk->TrangThai = $response["trangThai"];
                $tk->VaiTro = $response["vaiTro"];
            }

            return $tk;
        }

    }

?>