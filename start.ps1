Set-Location .\src;

$destinationDirectory = "../dist";

javac main/Main.java -d $destinationDirectory;
Set-Location $destinationDirectory;

java main.Main