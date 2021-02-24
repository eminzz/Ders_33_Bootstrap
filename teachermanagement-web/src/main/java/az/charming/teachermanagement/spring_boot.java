/* java ee(enterprise edition)- burda claslar ve ozu isleyen sistemler(containerler) var. Hansiki
meselen enterprise bin qurursan ve bu obyekt ne zaman olmelidir , ne zaman acig qalmalidir bunu onun(ee)
icinde gelen hemen container ede bilir.Java EE diagram seklinde de baxa bilerik, gorerik ki bir nece
spesifikasiyalardan ibaretdir. Spesifikasiya odur ki, meselen baza qosulmag ucun javanin driver clasinda connection
implement eden obyekt verilir bu javanin qoydugu bir nov qaydadi ve mysql, oracle ve s. sirketler bu spefikasiyadan
istifade edib qosulma kitabxanalar duzeldib, hamsinin kokunde bu var ve bunun uzerinde ferqlilikler edibler. Bizede
kitabxanalari oyrenmek yox bu spesifikasiyani oyrenmek lazimdir.Bu java se-dedir ve java ee-de hemcinin beledir sadece
spesifikasiylar coxdur.JAX-RS, JAX-WS, SERVELET(hemcinin bu implementasiyadir), EJB artig kohnedir(String cixandan
sonra).JSF(kohne sayilir),ve community edition enterprise-i desteklemir onuncun start.spring.io deyib google
orda proyekti acirig gradle, java, 2.4(versiya, bunun uzerinde clicklesmisdir ele), sonra group, artifact adini yazirig
Group-az.charming
Artifact-teachermanagement
Name-teachermanagement
Description-Web Platform for Teacher Management
Package name-az.charming.teachermanagement
Packaging- @ Jar  War
Java- 15 11 @8 secirik ve sagda dependecies-ler elave edirik.(devtools, spring web, thymeleaf), jdbc qosmuruq cunki
db ni qosacagiq orda var bu neceki desktop-a qosduq. Indi web qururuq deye ancag web aid hisseleri artirdig.
Generate edib zip formali kitabxana geldi ve biz bunu zipden foldere saldig ve intellijde bunun icinde poryelkt
qurdug(teachermanagement-web).Proyekte baxsag gorerik ki src-da -main ve burda java ve resources(digerlerinde ferqli
olaraq) var.Resources de  static , templates ve application properties var. Static de css ve javascript fayllari
ve s olur, templates-de html fayllari olur(en vacib bunlardir) web ucun esas lazim olan budur bize , sayta girende
bir nece sehifeler var onlar gelib burada heresi bir sehife kimi yerlesir(oz proyektimizde de var update, teacher,
student ve s. sehifeler var onlarda heresi bir sehife kimi oturacag)Applacition properties-de bezi ayarlari bura
yazacayig bunlar hansilardi isledende bileceyik. Esas bize lazim olan build gradle baxiriq- burda goturduyumuz
onceden gormediyimiz id 'org.springframework.boot' version '2.4.2'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	pluginler var, id 'java' - bu ise evvelde variydi. dependenciesler: 1) thymeleaf- bize imkan verir ki kodlarimizi
ekranda gostere bilek daha dogrusu bunu ede bilmemiz ucun kodlari sadelesdirir. 2) web-bunun kokudu butun bize lazim
olan classlar, annotation-lar bu webden gelecek.3) devtools ise- sehifeni refresh etmeden kodu yazdin gelir yeni
application restart etmirsen her defe.4) test- hele bize lazim deyil.
bu proyekti spiringde qurdug, neceki
biz jdbc ni istifade ederek ordan drive goturub proyektimize qosurdug, burda spiringin dependecieslerinden,
jarlarindan istifade edirem demekdir-spiringde qurdum demek. Filin uzerine vurdug(dependenciesleri yuklesin).
Ve java da birdene package acdig(controller adli), icinde de class(IndexController)

@Controller
public class IndexController {

    @RequestMapping("alma")
    public String index(){
        return "index";
    }
}
ve templates-de html fayli(index adli) acdig sonunccu 5 i secerek, ve bodylerin arasina Hello World!!!
yazdig, sonra main metodunu run edirik asagida tomcat started 8080 yeni proyekt start oldu 8080 portunda.
google localhost:8080 yazirig sehifede Hello World!!! yazisi cixir /alma yazirig yanina ve sag click inspector
vururuq bir pencere acilir network vurub ctrl +R il reload edirik alma cixir bura clicklyende general, reqeust
header, response header gelir.Generalda - Request URL: http://localhost:8080/alma deyir ki bura request
gonderdin, Request Method: GET- get requesti gonderdin, bu requestin cavabi(status) 200 oldu-
Status Code: 200. Bir mektub olanda onun uzerine yazilar yazilir buna headers deyilir, request ve response
-2 cur olur. Request Headers- User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36
(KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36 yeni sene melumati mozilla veya google veya safari ile
gonderdim.Host: localhost:8080 deyir sene filan adrese request gonderdim.
Accept: text/html,application/xhtml+xml,application/xml;q=0.9, deyir ki men bu formatda melumati qebul edirem.
Accept-Encoding: datani encode elemekdir. Accept-Language:  burda deyir ,men qebul edirem bu dillerin
herfleri ile, Connection: keep-alive connnection acig qalir.Burda gonderen haqda informasiya gonderilir.
Sorgu gedenden sonra response cavab gelir.yene senin sorgunun neticeleri haqdadi,
Content-Language: ru-RU
Content-Type: text/html;charset=UTF-8
Date: Mon, 01 Feb 2021 21:47:18 GMT
Keep-Alive: timeout=60  men sene text/html gonderdim, rus herfleri ile, filan vaxta -tarix ve timeoutum
60 milli saniyedir. Bu headerler mektubun uzerinde ilkin yazidir, birde var Response body- mektubun icidir.
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    Hello World!!!
</body>
</html>
bu bize gelen cavabdir(mektubun ici) bunu browser taniyir,ve bunu goturub sehifede hello world!!!
yazisiyla gosterir. bayag dediyimiz requestdeki accept text/html falan demek isteyir ki men gonderdiyim
bu formatlarda ola biler. Request -inde body-si var yeni bizde qarsi terefe mektub yazanda body-sini de
elave ede bilerik.Tomcat -web application serverdir yeni ki bu tcp ile isleyen programdi ve gedir 8080 portunda
bize qulag asir, bir nece bele appler var glassfish, weblogic ve s.Bu app server index faylini ozunde saxlayir,
meselen alma gelende index qayatarmaliyam(return de yazdigimiz index-e baxir ve orda ne yazilibsa onu html
kimi taniyib sonuna .html artirir. Metod adi ferqlide ola biler).@Controller bir anlayisdir tomcat baxdi almaya
ve deyir bu getdi indexcontrollere ve oda bize index.html qaytardi burda indexcontroller bizim controllerdi
ve index.html bizim view-dur, var birde model anlayisi umumilikde deyilir MVC. indi VC-ni bildik.
Html- <!DOCTYPE html> bununla(doctype-la) browser anlayir ki bu html 5dir ve buna uygun kodlar ola biler.
qalan isler </html> arasinda yazilir.
sonra headlerle nastroykasi bildirilir ki utf-8 istifade olunur ve browserde sehifenin adi title da yazilir.
Bodylerde de sehifeye cixan sozu (mektubu) yazirig.Studentimizi ifade eden kodlari yazirig body-de.
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<center>
    <label>name</label>
    <input type="text" name="name"/>

    <label>surname</label>
    <input type="text" name="surname"/>

    <label>age</label>
    <input type="text" name="age"/>

    <label>scholarship</label>
    <input type="text" name="scholarship"/>

    <button>Search</button>
    <button>Add</button>
    <button>Delete</button>
    <table>
        <thead>
            <tr>
                <th>id
                <th>name</th>
                <th>surname</th>
                <th>age</th>
                <th>scholarship</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Emin</td>
                <td>Zeynalov</td>
                <td>28</td>
                <td>200</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Fidan</td>
                <td>Abilhasanli</td>
                <td>25</td>
                <td>300</td>
            </tr>
        </tbody>
    </table>
</center>
</body>
</html>
center yazarag web deki tablei ortaya cekdi. body-de acdig theadler ve tbodyler, theadin tr(row) -
id	name	surname	age	scholarship setri veririk he heresininde tek tek adlanmasini thlarla verdik,
tbody-de tr ile -1	Emin	Zeynalov	28	200 bu setri verdik ve tek tek detallarini td ile verdik yeni
Emin ,Zeynalov ve s. label-larla swingdeki kimi xanalarin onundeki adlari verdik sehifede gorunmesi ucun.
input-lar xanalardi ve swingdeki textfieldler kimidir, ve text tipi verilir ve componentlerin adi ise "surname"
"age" ve s. seklinde yazilir.Buttonlarda eyni swwingdeki duymelerimiz kimi add, delete falan.
https://www.w3schools.com/-frontend ucunyaxsi saytdir, biz buttonlar formasini deyismek ucun style istifade edirik
bunu inputda da yazib xanaya vid vere bilerik.
<button style="background-color:red; font-size: 20px">Search</button>
    <button style="background-color:red">Add</button>
    <button style="background-color:red">Delete</button>
duymeleri qirmizi renge cevirdik ve searchi olcusunu artirdig bunlari rahat olmasi ucun browserde search uzeri
sag click inspector secib isleye bilerik-neticeni tez gorme imkani verir bize.
element.style {
    background-color: #008eff;
    font-size: 20px;
    color: white;
    border-radius: 13px;
}
gorunduyu kimi rengi mavi etdik etdik, olcunu yuvarlaq etdik, search yazisini ag etdik ve bunu kopya edib
html-de yazarag yaddasinda saxlayirig.
<button style="background-color: #008eff;
    font-size: 20px;
    color: white;
    border-radius: 13px;">Search</button>
digerlerine de etdik.cursor:pointer yazib duyme uzerine mouse getirdiymizde el isaresi olur.Buna(style) css deyilir
(cascading styles sheets),html (hypertext markup language).Browserler bunu basa dusur style adli tag css formatinda
olur falan. biz bunu head icinde yazib buttonun icinde style silib class="btn" yazarag istifade ede bilerik
    <style>
        .btn {
            background-color: #008eff;
                    font-size: 20px;
                    color: white;
                    border-radius: 13px; cursor:pointer
        }
    </style>
bu bir nov metod anlayisi kimidir meselen rengi deyisin yuxarda bir defe hansi buttonda bu cagrilibsa deyisilir
rahatliqdir.Bir de var id class evezine bunu istifade edirik id odurki 1 defe istifade olunur meselen saytin
logosu bu sehifede olacag yuxarda i fso. Eslinde yene istifade ede bilersen ancag mentiqi cehetden bir defedir,
yeni elave istifade etmek duz deyil.Mozilla firefox-da yazilanda sehvleri gosterir ve programist bilir ancag
chrome sehvlerin ustunu ortur , goz yumur.
    <style>
        #search-btn{
            background-color:red
        }
        .btn {
            background-color: #008eff;
                    font-size: 20px;
                    color: white;
                    border-radius: 13px; cursor:pointer
        }
    </style>
ancag search de istifade edirik adini verdik ve # -le baslayir, buttonda da class yerine id yazirig, class ise . ile
baslayir.validatorlar var ki html yoxlayir, var saytin url ni verib yoxlayirsan.meselen verdik html validatorda
center gosterdi i beyenilen tag deyil css istifade ele.bunu yigisdirmag ucun evvel bunlari panel uzerine yigirig
bununcun body icinde yuxarda <div> acirig ve gedib inspector da isleyirik panel formasini. backgroung red verib panel
rahat gore bilerik amma buna ehtiyac yoxdu, margin var bu panelin col mesafesini nizamlayir yuxari, sag , asagi, sol
saati kimi buna 0 auto deyirik(yuxari asagi 0, sag sol auto) ve margin-top elave edib 50 px veririk, padding panelin
ic mesafesin nizamlayir,width panel ekranda genisliyi, margin auto -centeri evez edib ortaya atir.ve html de
#main-panel adli id acib panelin gostericilerini bura kopyalayirig ve <div id="main-panel> yazirig. table reng falan
vermek ucun bir table css generator yazirig google da hazir formasinin css copy(blueTable adli birin tapdig) edirik ve
style-da table.blueTable clasini aib bura yazirig. table. demekle bu axtaris kodudu eslinde yeni get  table
taglarinde clasi blueTable olani tap. ve <table class="blueTable"> table a bunu yazdig.
        #main-panel{
            width: 85%;
            margin: 0 auto;
            margin-top: 50px;
        } bayag sozugeden panel.
tfoot -table head, body-si oldugu kimi ayagida var.table ile search arasina mesafe verdik blueTable clasina
margin-top: 10px; yazarag.static paketmizi directory secib css yazarag static.css etdik ve burd adi fayl
acib index.css yazdig lakin bununcun ultimate isteyir onun bu fayli atirig templates-e ve htmldeki style icini
bura yazirig idleri claslari ve style silib html-de bu fayli cagiririg
<link rel="stylesheet" href="index.css"> yazaraq.
 */
