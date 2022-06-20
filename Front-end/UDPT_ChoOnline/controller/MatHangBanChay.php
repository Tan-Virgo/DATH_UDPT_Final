<?php

class MatHangBanChayController
{

    public function topproduct()
    {
        $data = MatHangBanChayModel::getTopProduct();
        $VIEW = "./view/MatHangBanChay.phtml";
        require("./template/template.phtml");
    }

    
}

