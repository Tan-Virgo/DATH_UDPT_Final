<?php

class DoanhThuController
{

    public function turnover()
    {
        $supplier = NhaCungCapModel::findonesupplier(1);
        $data = DoanhThuModel::getturnover(1);
        $datachart = DoanhThuModel::getturnoverpresent(1);
        $VIEW = "./view/DoanhThu.phtml";
        require("./template/template.phtml");
    }

    
}