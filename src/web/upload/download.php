
<?php
if (!isset($_GET['file']) || empty($_GET['file'])) {
    exit();
}
$upload = basename($_GET['file']);
$filename = "files/" . $upload;

if (is_file($filename)) {
    header("Expires: -1");
    header("Last-Modified: " . gmdate("D, d M Y H:i:s") . " GMT");
    header("Content-type: application/octet-stream"); //or yours?
    header("Content-Transfer-Encoding: binary");
    header("Cache-Control: no-store, no-cache, must-revalidate");
    header("Cache-Control: post-check=0, pre-check=0");
    header("Pragma: no-cache");
    header('Content-Length: '.filesize($filename));
    header("Content-Disposition: attachment; filename=" . $upload . ";\n\n");
    ob_end_clean();
    flush();
    readfile($filename);
}else{
    echo "El archivo no se ecuentra disponible para la Descarga";
}



?>

