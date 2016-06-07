# README #

## GEREKLI UYGULAMALAR ##
Uygulamanin calismasi icin asagidaki uygulamalarin yuklu olmasi ve mongotraining-web/resources/ altinda global.local.properties konfigure edilmis olmasi gerekmektedir.

* MongoDB: Uygulamada verilerin tutuldugu NoSQL database, mongo.host ve mongo.port ile konfigure edilir. MongoDB kurulumu icin [buraya](https://docs.mongodb.org/manual/installation/)
* Maven: Projeyi derlemek icin gereklidir. Maven kurulumu icin [buraya](https://maven.apache.org/install.html) 

## BUILD VE RUN ##

Projeyi build etmek icin Intellij Idea'dan

* Run -> Edit Configurations secilir
* Acilan ekrandan uc tane configuration tanimlanmasi gerekmektedir. Bu konfigurasyonlar sirasiyla
1 - Parent POM dosyasini derleme 
2 - Tum projeyi derleme
3 - Projeyi ayaga kaldirmak
icin kullanilir.
* **Parent POM'u derlemek icin:** + tusuna basilarak Maven configuration secilir ve ekranin sag tarafinda alanlar acilir. Burada sirasiyla:
**Name:** Build Parent (Ya da ne istersen)
**Working Directory:** Root path, ornegin "/Users/abc/mongotraining"
**Command Line:** clean install -P parent
Alternatif olarak projenin fiziksel olarak yuklendigi adres terminalden acilarak **"maven clean install -P parent"** komutu calistirilabilir.

* **Tum projeyi derlemek icin:**  + tusuna basilarak Maven configuration secilir ve ekranin sag tarafinda alanlar acilir. Burada sirasiyla:
**Name:** Build All (Ya da ne istersen)
**Working Directory:** Root path, ornegin "/Users/abc/mongotraining"
**Command Line:** clean install -P web 
Alternatif olarak projenin fiziksel olarak yuklendigi adres terminalden acilarak **"maven clean install -P web"** komutu calistirilabilir. 

* **Projeye ayaga kaldirmak icin:**  + tusuna basilarak Maven configuration secilir ve ekranin sag tarafinda alanlar acilir. Burada sirasiyla:
**Name:** Run (Ya da ne istersen)
**Working Directory:** web projesinin oldugu klasor, ornegin "/Users/abc/mongotraining/mongotraining-web"
**Command Line:** jetty:run -DtargetPlatform=local