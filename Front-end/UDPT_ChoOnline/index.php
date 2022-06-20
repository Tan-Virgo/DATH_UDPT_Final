<?php
if(!isset($_SESSION)) 
{ 
    session_start(); 
} 

require_once("./controller/Home.php");
require_once("./controller/NhaCungCap.php");
require_once("./controller/DonViVanChuyen.php");
require_once("./controller/Shipper.php");
require_once("./controller/TaiKhoan.php");
require_once("./controller/Contact.php");
require_once("./controller/MatHangBanChay.php");
require_once("./controller/NhuCauCungKy.php");
require_once("./controller/SanPham_NCC.php");
require_once("./controller/DoanhThu.php");
require_once("./controller/LichSuGiaoHang.php");
require_once("./controller/LichSuMuaHang.php");
require_once("./controller/DonHang.php");
require_once("./controller/PhanHoi.php");


require_once("./Model/NhaCungCap.php");
require_once("./Model/DonViVanChuyen.php");
require_once("./Model/Shipper.php");
require_once("./Model/TaiKhoan.php");
require_once("./Model/MatHangBanChay.php");
require_once("./Model/NhuCauCungKy.php");
require_once("./Model/NhuCauCungKyNam.php");
require_once("./Model/SanPham_NCC.php");
require_once("./Model/DoanhThu.php");
require_once("./Model/LichSuGiaoHang.php");
require_once("./Model/LichSuMuaHang.php");
require_once("./Model/DonHang.php");
require_once("./Model/PhanHoi.php");
require_once("./Model/KhachHang.php");
require_once("./Model/SanPham.php");

require_once("config/dbconnect.php"); 

$action = "";
if (isset($_REQUEST["action"]))
{    
    $action = $_REQUEST["action"];
}
 

switch ($action)
{
    case "contact":
        $controller = new ContactController();
        $controller->contact();
        break;


    case "purchasinghistory":
        $controller = new LichSuMuaHangController();
         $controller->purchasinghistory();
        break;







    case "listsupplier":
        $controller = new NhaCungCapController();
        $controller->listsupplier();
        break;
    case "addsupplier":
        $controller = new NhaCungCapController();
        $controller->addsupplier();
        break;
    case "showtoupdatesupplier":
        $controller = new NhaCungCapController();
        $controller->showtoupdatesupplier();
        break;
    case "updatesupplier":
        $controller = new NhaCungCapController();
        $controller->updatesupplier();
        break;
    case "deletesupplier":
        $controller = new NhaCungCapController();
        $controller->deletesupplier();
        break;
    case "listproductofsupplier":
        $controller = new SanPham_NCCController();
        $controller->listproductofsupplier();
        break;
    case "acceptsupplier":
        $controller = new NhaCungCapController();
        $controller->acceptsupplier();
        break;




    case "addtransport":
        $controller = new DonViVanChuyenController();
        $controller->addtransport();
        break;
    case "listtransport":
        $controller = new DonViVanChuyenController();
        $controller->listtransport();
        break;
    case "showtoupdatetransport":
        $controller = new DonViVanChuyenController();
        $controller->showtoupdatetransport();
        break;
    case "updatetransport":
        $controller = new DonViVanChuyenController();
        $controller->updatetransport();
        break;
    case "deletetransport":
        $controller = new DonViVanChuyenController();
        $controller->deletetransport();
        break;
    case "accepttransport":
        $controller = new DonViVanChuyenController();
        $controller->accepttranport();
        break;


    case "listshipper":
        $controller = new ShipperController();
        $controller->listshipper();
        break;
    case "showtoaddshipper":
        $controller = new ShipperController();
        $controller->showtoaddshipper();
        break;
    case "addshipper":
        $controller = new ShipperController();
        $controller->addshipper();
        break;
    case "showtoupdateshipper":
        $controller = new ShipperController();
        $controller->showtoupdateshipper();
        break;
    case "updateshipper":
        $controller = new ShipperController();
        $controller->updateshipper();
        break;
    case "deleteshipper":
        $controller = new ShipperController();
        $controller->deleteshipper();
        break;
    case "acceptshipper":
        $controller = new ShipperController();
        $controller->acceptshipper();
        break;


    case "deliveryhistory":
        $controller = new LichSuGiaoHangController();
        $controller->deliveryhistory();
        break;



    case "showtoupdateorder":
        $controller = new DonHangController();
        $controller->showtoupdateorder();
        break;
    case "updateorder":
        $controller = new DonHangController();
        $controller->updateorder();
        break;
    case "deliveryconfirmation":
        $controller = new DonHangController();
        $controller->deliveryconfirmation();
        break;
    case "confirmorder":    
        $controller = new DonHangController();
        $controller->confirmorder();
         break;
    case "showtoconfirmorder":
        $controller = new DonHangController();
        $controller->showtoconfirmorder();
        break;
    case "updateconfirmorder":
        $controller = new DonHangController();
        $controller->updateconfirmorder();
        break;




    case "productdetail":
        $controller = new SanPham_NCCController();
        $controller->productdetail();
        break;
    case "listallproductofsupplier":
        $controller = new SanPham_NCCController();
        $controller->listallproductofsupplier();
        break;



        
    case "listdonhang": 
        $controller = new DonhangController();
        $controller->listdonhang();
        break;
    case "getdonhang":
        $controller = new DonhangController();
        $controller->getdonhang();
        break;    
        
    case "showtoupdatedonhang":
        $controller = new DonhangController();
        $controller->showtoupdatedonhang();
        break;
    case "updateDH":
        $controller = new DonhangController();
        $controller->updatedonhang();
        break;
    case "listphanhoi":
        $controller = new PhanhoiController();
        $controller->listphanhoi();
        break;
    case "showtophanhoi":
        $controller = new PhanhoiController();
        $controller->showtophanhoi();
        break;
    case "createphanhoi":
        $controller = new PhanhoiController();
        $controller->createphanhoi();
        break;




    case "addaccount":
        $controller = new TaiKhoanController();
        $controller->addaccount();
        break;


    case "topproduct":
        $controller = new MatHangBanChayController();
        $controller->topproduct();
        break;
    case "perioddemand":
        $controller = new NhuCauCungKyController();
        $controller->perioddemand();
        break;
    case "turnover":
        $controller = new DoanhThuController();
        $controller->turnover();
        break;


    case "login":
        break;
    case "logout":
        break;
    default:
        $controller = new HomeController();
        $controller->index();
        break;
}

?>
