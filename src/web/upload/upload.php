<?php

class Upload {

    var $maxsize = 0;
    var $message = "";
    var $newfile = "";
    var $newpath = "";
    var $filesize = 0;
    var $filetype = "";
    var $filename = "";
    var $filetemp;
    var $fileexte;
    var $allowed;
    var $blocked;
    var $isimage;
    var $isupload;

    function Upload() {
        $this->allowed = array("image/bmp", "image/jpeg", "image/pjpeg", "image/png", "image/x-png", "image/tiff", "application/pdf");
        $this->blocked = array("php", "phtml", "php3", "php4", "js", "shtml", "pl", "py", "yml", "sh", "bat", "exe", "html");
        
        $this->message = "";
        $this->isupload = false;
    }

    function setFile($field, $cedulaTercero, $nombreDocumento, $fechaDocumento) {
        $this->filesize = $_FILES[$field]['size'];

        $this->filename = $_FILES[$field]['name'];

        $this->filetemp = $_FILES[$field]['tmp_name'];

        $this->filetype = $_FILES[$field]['type'];

        $this->fileexte = substr($this->filename, strrpos($this->filename, '.') + 1);
        
        $this->newfile = $cedulaTercero."_".$nombreDocumento."_".$fechaDocumento.".".$this->fileexte;
    }    

    function setPath($value) {
        $this->newpath = $value;
    }

    function setMaxSize($value) {
        $this->maxsize = $value;
    }
    
    function isImage($value) {
        $this->isimage = $value;
    }
    
    function getNewFile() {
        return $this->newfile;
    }
    
    function save() {
        if (is_uploaded_file($this->filetemp)){
            //Si el Archivo no es válido
            if ($this->filename == "") {
                $this->message = "No se Subió Archivo";
                $this->isupload = false;
                return false;
            }   
            
            //Verificar si el tipo de archivo es permitido
            if (in_array($this->filetype, $this->allowed)) {
                //Sube el archivo al servidor
                if (move_uploaded_file($this->filetemp, $this->newpath . "/" . $this->newfile)) {
                    $this->message .= "Archivo Subido Exitosamente!";
                    $this->isupload = true;
                    return true;
                }
            }else{
                $this->message .= "Archivo No Permitido - " . $this->fileexte;
                $this->isupload = false;
                return false;
            }
            
        }else{
            $this->message .= "El Archivo no pudo ser subido. Por favor intente de nuevo";
            $this->isupload = false;
            return false;
        }
    }
}
?>