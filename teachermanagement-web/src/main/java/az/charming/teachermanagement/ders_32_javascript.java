/* Ders 32 Javascript
Application server- daima isleyen, requestleri qebul edib response qaytaran bir programdir.Java Enterprise Edition ile
Spring Framework ferqi- JEE da her hansi lahiyeni web application server-de yazirig ancag spring-de bunu console da
yaza bilirik.Kohne texnologiyalarda compile edirdin, servere atirdin ve s. Burda olan ustunlukler JEE-de de var ancag,
burda ne varsa webe aiddir springdeki kimi olan ne varsa console-da istifade ede bilmirsen.Bootun ustunluyu- evveler
boot olmayanda springle app yazanda her bir seyi dene-dene qeyd etmeliydin.Meselen bir ayarlar fayli acib orda
bildirirdik ki, html templates-de yerlesir, css static-dedir.Controller-i el ile qosmali idin. Indi ise builde
gradle-de qosdugumuz boot dependency-(implementation 'org.springframework.boot:spring-boot-starter-web') bize elave
kitabxanalar getirir, external libraries-e baxsag gorerik: spring framework web; webmvc; context ve evveller elemeli
oldugumuz isler bunlarin icinde gelir, avtomatik edilir.Buna misal olarag muellim github-da kohne qurdugu applarden
gosterdi: Resources assets folderinde yerlesib, indiki index yazilanda sonuna avtomatik yazilan .html orda jsp istifade
olunanda el ile qeyd edilib ve s.Yeni boot-da bu konfiqurasiyalarin hamisi hazirlanib.
Binding- bir datani diger yere birlesdirmek, calamaqdir. Kecen defe meselen html.den name, surname falan gonderdik
ozumuze. Sonra delete edende id, add edende obyekt (studentEntity) gonderdik. Yeni html-den controller-e ,
controller-den html-e data gonderirsen.Dependncies-de olan test- spring web quranda archtype ile qurur ve test folderi
gelir icinde.
Update- students/index.html-de bir dene update form yazdig (add kimi), controller-de
update metodu acdig(add kimi) ancag id-e gore update edecek deye form-da birdene hidden tipinde input elave etdik ve
ozunde bu input ancag id-ni saxlayir.Update duymesini basanda name, surname-ler ile birlikde id-de gelir.Biz update-in
html-ni web de acib uzerinde isleye bilerik . Meselen console-de update-in hidden-nin value-sunu deyise bilerik
[document.getElementsByName('id2')[0].value=7] yazarag ve hemcinin iger inputlarin name-ni falan deyise bilerik. Indi
biz burda deyisdiyimiz kimi ele edeceyik ki, hemen getElements ile popopa oturan id-ni falan deyisek.Hemcinin istenilen
input-un  bu sekilde adini yazib deyise bilerik.
Update butonunda  onclick="fillSelectedItemForUpdate(..) funksiyasini yazirig bu goturulen setrin field-lerini doldurur
popopa. Bu hazir funksiya olmadigindan bunu head-in icinde script acib orda qururug.Update form-unda her inputa uygun
olarag id acib ad veririk <input type="text" name="age" id="ageUpdate"/> bu sekilde ve gedib funksiya bunlari
doldururug setrden gelen fieldler ile.
function fillSelectedItemForUpdate(id, name, surname, age, scholarship){
    document.getElementById("idUpdate").value=id;
    document.getElementById("nameUpdate").value=name;
    document.getElementById("surnameUpdate").value=surname;
    document.getElementById("ageUpdate").value=age;
    document.getElementById("scholarshipUpdate").value=scholarship;
}

Webdedeki setrlerin fieldlerini goturub ad veririk st-name falan filan, sonra popopu dolduran funksiya ya
this.getAttribute('st-id') funksiyasi ile hemen fieldleri bura doldururug.Burdaki this goturduyumuz setri bildirir.
<button type="button"
                                th:st-id="${student.id}"
                                th:st-name="${student.name}"
                                th:st-surname="${student.surname}"
                                th:st-age="${student.age}"
                                th:st-scholarship="${student.scholarship}"

                                onclick="fillSelectedItemForUpdate(
                                    this.getAttribute('st-id'),
                                    this.getAttribute('st-name'),
                                    this.getAttribute('st-surname'),
                                    this.getAttribute('st-age'),
                                    this.getAttribute('st-scholarship')
                                    )">
                            Update</button>
Update-e klikleyende deyerleri ozunden goturur.Sonra da fill funksiyasi bayag dediyimiz kimi value-lari deyisir
yuxarida.Button tipi "button" edirik ki her basanda sorgu gedib refresh vermesin, default sekilde submit idi.En esasi
her setr-de update basanda hidden id gelir oturur.Inputlara yazdigimiz id=nameUpdate ve s. Javascript sonda bununla
otuzdurur deyerleri komponente.Inputdaki name ise entity-e oturmasi ucun lazimdir.Update popopa network-de baxsag
form dataki deyerleri gorerik ve burdan bu deyerler gedir controllere ordanda obyekte.
Update-e ve add-e basanda popop acilsin deye ilk once formlarda yazirig
<form id="panelUpdate" method="POST" action="/students/update" class="form-panel" style="display: none"> bunu adducunde
yazdig: style="display: none"- yeni ekranda gorsenmesin.Bunlari tapa bilmek ucun ad verdik- id="panelUpdate".
Sonra fillElements.. de fieldleri doldurandan sonra document.getElementById("panelUpdate").style="display: block";
yazirig yeni popop gorsensin. Fieldleri doldurandan sonra yazdig ki, acilanda xanalar dolu gelsin , ilk yazsaydig bos
gorsenib sonra dolacagdi.
Add butonuna basanda popop-u gelsin deye onclick-e bir showAddPanel adli funkiya veririk:
<button type="button" class="btn" name="action" value="add" onclick="showAddPanel();">Add</button>
Sonra bu funksiyani script-de acirig.
function showAddPanel(id){
    document.getElementById("panelAdd").style="display: block";
}
Indi update-e basanda add-in gedib update-in gelmesi ucun showAddPanel-de
panelUpdate-i  artirib none edirik ve fillSelectedItemForUpdate-de panelAdd- artirib none edirik.Yeni heresinde birini
block , birini none edirik.Yandirib sondururuk.
Indi add popopuna dizayn verek css-de.Padding icerden mesafe ucundur, border radius kuncleri ovalni edir,
background-color arxa fona reng verir, position: absolute- ozunu buraxir ve istenilen yere qoya bilirsen ekranda
normalda ise table-dan sonra gelir, margin left -soldan, margintop yuxaridan iteleyir, tekce left yazanda ise konkret
deyir burada dayan, width- genisliyini nizamlayir, position fixed etdik absolute-un yerine fixed olmasa left, right
deye bilmerik.Popopa bir dene de close duymesi artiririg, bunu add formunda add butonundan sonra bir Close adli buton
acarag edirik ve bu butonun  onclick-ne scriptde bir function duzelderek otururuk.
<button type="button" class="btn" onclick="hideAllaPopups()">Close</button>
Bunu hemcinin update popopuna da tetbiq edirik yeni update form-unda da bele buton acirig.
function hideAllaPopups(){
    document.getElementById("panelAdd").style="display: none";
    document.getElementById("panelUpdate").style="display: none";
}
Delete basanda birbasa getmeyib popop acilib tekrar sorusmasi ucun-
birdene delete form:
<form id="panelDelete" method="POST" action="/students/delete" class="form-panel" style="display: none">
    Are you sure to delete?
    <input type="hidden" name="id" id="idDelete"/>
    <button class="btn">Delete</button>
    <button type="button" class="btn" onclick="hideAllaPopups()">Close</button>

Ve tbody-de delete butonuna:
 <form method="POST" action="/students/delete">
                        <input type="hidden" name="id" th:value="${student.id}"/>
                        <button th:st-id="${student.id}"
                                type="button"
                                onclick="fillSelectedItemForDelete(this.getAttribute('st-id'))"
                        >Delete</button>
yazirig,, sadece id otururuk ve scriptde fillSelectedItemForDelete funksiyasini qururug:
function fillSelectedItemForDelete(id){
    document.getElementById("idDelete").value=id;
    document.getElementById("panelDelete").style="display: block";
    document.getElementById("panelUpdate").style="display: none";
    document.getElementById("panelAdd").style="display: none";
}
paneldelete block edib qalanlari none edirik. hideAllPopus-a panelDelete elave edirik
document.getElementById("panelDelete").style="display: none";
hemcin fillUpdate ve showPanel funksiyalarina da artirib none edirik.
Static folderinde bir js folderi ve icinde de index.js fayli acib htmldeki script icerisinde olan function-lari bura
atirig ve bu fayli html-de bele <script src="/js/index.js"></script>
cagirirg.
Java-da virtual masin olan kimi javascriptde bir masin uzerinde isleyir,her bir browser ya ozu o masini yazir ya da
hazir masin uzerinde isleyir,buna engine deyilir,en mehsuru chrome engine-dir, bizim yazdigimiz kodlar arxada bu
engine terefinden oxunur, icra olunur.Es6 class anlayisi gelib javascriptde sonradan, ve bu birbasa her browser
terefinden taninmir, bununcun compile olur normal(sade) javascript formatina ve basa dusulur,
w3schools.com da etrafli var baxsag gorerik konstruktorlar falan var.Deyisen tipi "var" var butun tipleri evez edir,
javascript dinamic tipli dildir.

Umumi istifade olunan kodlar
StudentController:

@Controller
public class StudentController {

    private final StudentRepository studentRepository = new StudentRepository();

    @RequestMapping(value = "students", method= {RequestMethod.GET})
    public String index(Model model,
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) String surname,
                        @RequestParam(required = false) Integer age,
                        @RequestParam(required = false) BigDecimal scholarship
                        ){
        model.addAttribute("list",studentRepository.findList(
                name,
                surname,
                age,
                scholarship
        ));
        return "students/index";
    }

    @RequestMapping(value = "students/add", method= {RequestMethod.POST})
    public String add(@ModelAttribute StudentEntity studentEntity){
        studentRepository.insert(studentEntity);
        return "redirect:/students";
    }

    @RequestMapping(value = "students/update", method= {RequestMethod.POST})
    public String update(@ModelAttribute StudentEntity studentEntity){
        studentRepository.update(studentEntity);
        return "redirect:/students";
    }

    @RequestMapping(value = "students/delete", method= {RequestMethod.POST})
    public String delete(@RequestParam(required = false) Integer id){
        studentRepository.delete(id);
        return "redirect:/students";
    }
}

TeahcermanagementApplication:

@SpringBootApplication
public class TeachermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachermanagementApplication.class, args);
	}

}

index.css:

#main-panel{
            width: 85%;
            margin: 0 auto;
            margin-top: 50px;
        }
        .btn {
            background-color: #008eff;
                    font-size: 20px;
                    color: white;
                    border-radius: 13px; cursor:pointer
        }
        table.blueTable {
            margin-top: 10px;
            border: 1px solid #1C6EA4;
            background-color: #EEEEEE;
            width: 100%;
            text-align: left;
            border-collapse: collapse;
            }
            table.blueTable td, table.blueTable th {
              border: 1px solid #AAAAAA;
              padding: 3px 2px;
            }
            table.blueTable tbody td {
              font-size: 13px;
            }
            table.blueTable tr:nth-child(even) {
              background: #D0E4F5;
            }
            table.blueTable thead {
              background: #1C6EA4;
              background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
              background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
              background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
              border-bottom: 2px solid #444444;
            }
            table.blueTable thead th {
              font-size: 15px;
              font-weight: bold;
              color: #FFFFFF;
              border-left: 2px solid #D0E4F5;
            }
            table.blueTable thead th:first-child {
              border-left: none;
            }

            table.blueTable tfoot {
              font-size: 14px;
              font-weight: bold;
              color: #FFFFFF;
              background: #D0E4F5;
              background: -moz-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
              background: -webkit-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
              background: linear-gradient(to bottom, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
              border-top: 2px solid #444444;
            }
            table.blueTable tfoot td {
              font-size: 14px;
            }
            table.blueTable tfoot .links {
              text-align: right;
            }
            table.blueTable tfoot .links a{
              display: inline-block;
              background: #1C6EA4;
              color: #FFFFFF;
              padding: 2px 8px;
              border-radius: 5px;
            }

            .form-panel {
                display: block;
                border: 1px solid;
                padding: 22px;
                border-radius: 10px;
                background-color: lightblue;
                position: fixed;
                left: 34%;
                top: 22%;
                width: 300px;
            }

            .form-panel input {
                float: right;
            }

            .form-panel div {
                height: 30px;
            }

index.js:

function fillSelectedItemForUpdate(id, name, surname, age, scholarship){
    document.getElementById("idUpdate").value=id;
    document.getElementById("nameUpdate").value=name;
    document.getElementById("surnameUpdate").value=surname;
    document.getElementById("ageUpdate").value=age;
    document.getElementById("scholarshipUpdate").value=scholarship;
    document.getElementById("panelUpdate").style="display: block";
    document.getElementById("panelAdd").style="display: none";
    document.getElementById("panelDelete").style="display: none";

}
function fillSelectedItemForDelete(id){
    document.getElementById("idDelete").value=id;
    document.getElementById("panelDelete").style="display: block";
    document.getElementById("panelUpdate").style="display: none";
    document.getElementById("panelAdd").style="display: none";
}

function showAddPanel(){
    document.getElementById("panelAdd").style="display: block";
    document.getElementById("panelDelete").style="display: none";
    document.getElementById("panelUpdate").style="display: none";
}

function hideAllPopups(){
    document.getElementById("panelAdd").style="display: none";
    document.getElementById("panelUpdate").style="display: none";
    document.getElementById("panelDelete").style="display: none";
}
students/index.html:

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/index.css">
    <script src="/js/index.js"></script>
</head>
<body>
<div id="main-panel">
    <form method="GET" action="/students" >
        <label>name</label>
        <input type="text" name="name" />

        <label>surname</label>
        <input type="text" name="surname" />

        <label>age</label>
        <input type="text" name="age" />

        <label>scholarship</label>
        <input type="text" name="scholarship" />

        <button type="submit" class="btn" >Search</button>
        <button type="button" class="btn" name="action" value="add" onclick="showAddPanel();">Add</button>
    </form>
    <table class="blueTable">
        <thead>
            <tr>
                <th>id
                <th>name</th>
                <th>surname</th>
                <th>age</th>
                <th>scholarship</th>
                <th>controls</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="student: ${list}">
                <td th:text="${student.id}">1</td>
                <td th:text="${student.name}">Emin</td>
                <td th:text="${student.surname}">Zeynalov</td>
                <td th:text="${student.age}">28</td>
                <td th:text="${student.scholarship}">200</td>
                <td>
                    <form method="POST" action="/students/delete">
                        <input type="hidden" name="id" th:value="${student.id}"/>
                        <button th:st-id="${student.id}"
                                type="button"
                                onclick="fillSelectedItemForDelete(this.getAttribute('st-id'))"
                        >Delete</button>
                        <button type="button"
                                th:st-id="${student.id}"
                                th:st-name="${student.name}"
                                th:st-surname="${student.surname}"
                                th:st-age="${student.age}"
                                th:st-scholarship="${student.scholarship}"

                                onclick="fillSelectedItemForUpdate(
                                    this.getAttribute('st-id'),
                                    this.getAttribute('st-name'),
                                    this.getAttribute('st-surname'),
                                    this.getAttribute('st-age'),
                                    this.getAttribute('st-scholarship')
                                    )">
                            Update</button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<form id="panelAdd" method="POST" action="/students/add" class="form-panel" style="display: none">
    <div>
        <label>name:</label>
        <input type="text" name="name"/>
    </div>

    <div>
        <label>surname:</label>
        <input type="text" name="surname"/>
    </div>

    <div>
        <label>age:</label>
        <input type="text" name="age"/>
    </div>

    <div>
        <label>scholarship:</label>
        <input type="text" name="scholarship"/>
    </div>

    <button class="btn" >Add</button>
    <button type="button" class="btn" onclick="hideAllPopups()">Close</button>
</form>

<form id="panelUpdate" method="POST" action="/students/update" class="form-panel" style="display: none">
    <input type="hidden" name="id" id="idUpdate"/>
    <div>
        <label>name:</label>
        <input type="text" name="name" id="nameUpdate"/>
    </div>

    <div>
        <label>surname:</label>
        <input type="text" name="surname" id="surnameUpdate"/>
    </div>

    <div>
        <label>age:</label>
        <input type="text" name="age" id="ageUpdate"/>
    </div>

    <div>
        <label>scholarship:</label>
        <input type="text" name="scholarship" id="scholarshipUpdate"/>
    </div>

    <button class="btn" >Update</button>
    <button type="button" class="btn" onclick="hideAllPopups()">Close</button>
</form>

<form id="panelDelete" method="POST" action="/students/delete" class="form-panel" style="display: none">
    Are you sure to delete?
    <input type="hidden" name="id" id="idDelete"/>
    <button class="btn">Delete</button>
    <button type="button" class="btn" onclick="hideAllPopups()">Close</button>
</form>
</body>
</html>

index.html:

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/index.css">

</head>
<body>
<div id="main-panel">
    <a href="/students" class="btn">Students</a>
    <a href="/teachers" class="btn">Teachers</a>
</div>
</body>
</html>

StudentFormDto(kohneden qalib istifade etmedik, tekce studententity lazim oldugu ucun):

public class StudentFormDto { //Data Transfer Object

    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public void setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
    }

    public StudentEntity toEntity(){
        return new StudentEntity()
                .setName(this.name)
                .setSurname(this.surname)
                .setAge(this.age)
                .setScholarship(this.scholarship);
    }
}
 */
