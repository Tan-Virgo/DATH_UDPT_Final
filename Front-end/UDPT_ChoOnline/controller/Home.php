<?php

class HomeController
{
    public function index()
    {
        $data = "No data !!!";        
        $VIEW = "./view/TrangChu.phtml";
        require("./template/template.phtml");
    }
}
