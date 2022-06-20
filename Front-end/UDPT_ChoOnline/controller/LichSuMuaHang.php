<?php

class LichSuMuaHangController
{

    public function purchasinghistory()
    {
        $data = LichSuMuaHangModel::purchasinghistory();
        $VIEW = "./view/LichSuMuaHang.phtml";
        require("./template/template.phtml");
    }

    
}
