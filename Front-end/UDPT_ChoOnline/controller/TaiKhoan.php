<?php

class TaiKhoanController
{
    public function addaccount()
    {   
        if (isset($_REQUEST["Username"]) && isset($_REQUEST["Password"]))
        {
            $acc = new TaiKhoanModel();
            $acc->Username = $_REQUEST["Username"];
            $acc->Password = $_REQUEST["Password"];
            $acc->VaiTro = $_REQUEST["vaiTro"];
            $acc->TrangThai = $_REQUEST["trangThai"];
            $res = TaiKhoanModel::addaccount($acc);
            if ($res)
                echo "<script type='text/javascript'>alert('Thêm thành công');</script>";
            else
                echo "<script type='text/javascript'>alert('Thêm thất bại');</script>";  
        }
        $VIEW = "./view/DangKyTaiKhoan.phtml";
        require("./template/template.phtml");
    }


    public function login()
    {
        if (count($_POST) >= 0 && isset($_POST["username"]))
        {
            $username = $_POST["username"];
            $password = $_POST["password"];    
            $userLogin = TaiKhoanModel::login($username, $password);        
            if (isset($userLogin) && $userLogin != null)
            {
                $_SESSION["IsLogined"] = True;
                $_SESSION["UserName"] = $username;
                $_SESSION["VaiTro"] = $userLogin->VaiTro;           
                header("Location:index.php");
            }		
            else
            {
                echo "<script type='text/javascript'>alert('Username hoặc Password không đúng!');</script>";               
                $VIEW = "./view/Login.phtml";
            }
        }
        else 
        {
            $data = "";        

            $VIEW = "./view/Login.phtml";
        }
        require("./template/template.phtml");
    }

    public function logout()
    {
        unset($_SESSION["IsLogined"]);
		header("Location:index.php");		
    }


    public static function authentication()
    {
        if (!isset ($_SESSION["IsLogined"]) || $_SESSION["IsLogined"] != "true")
        {
            echo "<script type='text/javascript'>alert('Đăng nhập thất bại');</script>";       
        }        
    }

    public function unauthorized_page()
    {        
        $data = ""; 
        $VIEW = "./view/ThongBao.phtml";
        require("./template/template.phtml");
    }
}
