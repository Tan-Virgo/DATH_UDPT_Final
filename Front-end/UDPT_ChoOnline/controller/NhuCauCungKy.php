<?php

class NhuCauCungKyController
{

    public function perioddemand()
    {
        $data = NhuCauCungKyModel::getperioddemand();
        $data_nam = NhuCauCungKyNamModel::getperioddemand();
        $VIEW = "./view/NhuCauCungKy.phtml";
        require("./template/template.phtml");
    }

    
}

