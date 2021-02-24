/* her defe html yazmayag deye bootstrap, her defe javascript yazmayag deye jquery istifade edeceyik. getbootstrap
saytindan  css linkini gotururuk proyekte oz css-in evezine yazirig:

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

bayag oz faylimizdaydi indi ise online url-i yazib goturur. Meselen bu linki browserde yazsag -
        https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css
css kodlari gelecek, ancag burda min-minify olunmusdur, yeni butun kodlar arda-arda, yazilmisdir. min silsek bizim
css-miz seklinde yazilacag. min ona gore lazimdir ki artig proyekt hazirdir, production-a cixacag. min silinmis sekli
ise edit ucundur.Bu hemcinin javascript ucunde beledir.Javascript linkini gotururuk yazirig ve hemcinin oz css ve
javascript-imiz qalir. Proyekte girsek bootstrapin qosuldugunu gorerik, search, add butonlarinin dizayni deyisib ve
mouse uzerine gelende butondaki ferqlilik gorsenir.
Search inspect etsek gorerik index css var bu bizim css-dir, bir de buttons.css var bu da bootstrapindir, transition-
mouse butonun uzerine gelende ferqlenmesi ucundur, color red desek yuxarda asagida bir dene de color oldugu ucun en son
yazilani goturur ve bunun uzerinden xet cekir. Onuncun color-red ! important deyirik ki bunu esas gotursun.Bootstrap
kodlarinda deyisiklik etmek ucun css folderinde bir bootstrap.css fayli acirig ve kodlari bura yazib deyisiklik edirik.
Ve bu bizim customize bootstrapimiz olur. Ancag lazim deyil bize hal hazirda.Getbootstrap saytindan bir cox seyleri
hazir goture bilirik, meselen table ucun olan dizaynlar var ve birini secib html-de bluetable  evezine -
<table class="table table-striped"> yazirig.Sonra buttonlar ucun - delete ucun
                        <button th:st-id="${student.id}"
                                type="button"
                                class="btn btn-danger"
                                onclick="fillSelectedItemForDelete(this.getAttribute('st-id'))"
                        >Delete</button>
btn btn-danger getirib verdik delete-in dizayni deyisdi, update-de class="btn btn-secondary" yazdig. inputlar ucun
class="form-control" yazirig bunu umumi formdaki inputlara, add ve update popopunun  formlarina(inputlarina) yazirig.
index.css de kohne kodlarin bezilerin silirik.
#main-panel{
            width: 85%;
            margin: 0 auto;
            margin-top: 50px;
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
search ve add butonunun clasina btn-primary artiririg - <button type="submit" class="btn btn-primary">Search</button>,
inputlarin alt-alta dusdu bunu yanasi etmek ucun form-a bir class yazib - row g-3 needs-validation verdik. sonra her
input ve label-lari bir div-e salib ve divlere de bir class yazib col-md-3 verdik yeni bu sekilde:
<form method="GET" action="/students" class="row g-3 needs-validation">
       <div class="col-md-3">
            <label>name</label>
            <input type="text" name="name" class="form-control"/>
       </div>
       ... ve s.

col md 4 -u 3 edirik, search add butonunu da col md12 edirik ki, qisalsin.col 12 falan ne demekdir. bu ekranin
bolunmesidir. Main panelde form var ve bunlarin da icinde divler(input, label).Main panel bunlarin containeridir.
Main panel ekranin 80 faizini tutsun demisik ve burda main panel 12 beraber hisseye bolunub- col m 12 ile.
col md 3 ile ise her inputa 3 dene vererek 4 inputu bir siraya saldig.sonra search add butonunu saxlayan dive ise
md 12 verdik yeni butun setri gotur.col- column demekdir. Buna grid(kletka) sistemi deyilir.Md , sm ve s. bunlarin
ekranin olcusu bildirir. inputa md 3 deyib ekrani balacalasdirsaq input 3-e bolunmeden  cixacag,  umumi setri goturub
sm-e dusecek cunki artig ekran pixel-i md-e uygun deyil ve col prinsipi tetbiq olmur.Default olarag input oldugu setri
tam ehate edir.Bunu istemeyende col yazirsan. eger olcu md-e uygunsa 3 hisse goturur. birbasa col 12 falan yazmagsa o
demekdir ki her zaman , her ekran olcusunde setri bele bol. ancag md, sm falan yazmag odur ki telefon, plansetde bu
cur gorun, kompda bu cur.Ekrandan ekrana dizayn deyismesine responsive(flexible) dizayn deyilir. Modal popap-a deyilir.
Modal- add ucun yazag, getbootstrapdan modal yazib goturduk- formun icinde :
 <div class="modal" tabindex="-1" id="panelAdd">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
yazdig.Sonra div class="modal-body" acib icerisinde label,inputlari yerslesdirdik:
<div class="modal-body">
                    <div>
                        <label>name:</label>
                        <input type="text" name="name" class="form-control"/>
                    </div>

                    <div>
                        <label>surname:</label>
                        <input type="text" name="surname" class="form-control"/>
                    </div>

                    <div>
                        <label>age:</label>
                        <input type="text" name="age" class="form-control"/>
                    </div>

                    <div>
                        <label>scholarship:</label>
                        <input type="text" name="scholarship" class="form-control"/>
                    </div>
</div>
sonra buttonlari footer yazib icine atirig ve hamsini, formu da baglayirig.Ve close duymesinde onclick=hideAllPopops
silib- data-bs-dismiss="modal" yazirig bu onuncundur ki bootstrap javascripti  elave etmisik yuxarda ona deyirki, bu
olan butona yeni close duymesine close funksiyonalligini elave ele.
 <div class="modal-footer">
                    <button class="btn" >Add</button>
                    <button type="button" class="btn" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</form>
Form-un id-ni silirik cunki oz cssmizi istifade etmirik, style-da silinir cunki bootstrap default olarag modalsan deyir,
hemcinin clasida silirik yeni bu sekilde- <form method="POST" action="/students/add" > qalir.
Add-e basanda popop acilsin deye- popop add-in ilk divine id="panelAdd", deyirik VE yuxarda add duymesine gedib
onclick-i silib yerine data bs target yazib panelAdd deyirik-
data-bs-toggle="modal" data-bs-target="#panelAdd">Add</button>.Artig bura clickleyende bootstrapin javascripti basa
dusecek ki asagidaki panelAdd-i show elemek lazimdir.Eyni seyi update ucunde yazirig. Ve yuxarda update butonuna data
bs toggle, targeti yazirig:
<button type="button"
                                class="btn btn-secondary"
                                data-bs-toggle="modal"
                                data-bs-target="#panelUpdate" ....
Ancag bunun javascriptini (onclick=...) silmirik ona gore ki id-sini goture bilsin.Oz js de eslinde show edir ona gore
oz js-inde(fillSelectedItemForUpdate) showlari(style) silek ozu ancag set elemekle mesgul olsun.Delete ucunde eyni
seyleri edirik, sadece
<h5 class="modal-title">Modal title</h5> burda modal title yerine silib Delete yazirig.
Yuxari delete butonunda cagiririg:
<button th:st-id="${student.id}"
                                type="button"
                                class="btn btn-danger"
                                data-bs-toggle="modal"
                                data-bs-target="#panelDelete" ...
Yene oz delete js qalir. ancag yene update kimi bununda showlarini yigisdiririg ancag id set edir.Oz js-imizde s
howAddPanel ve hideAllPopops silirik artig istifade olunmur.
Bootstrap css kitabxansi oldugu kimi , jquery-de javascript kitabxanasidir.Bunu isitfade etmek ucun meselen jquery
drag and drop yazirig -jqueryui.com-dan dragable gotururuk. Burdan jquery-nin oz css-ni ve oz javascriptini import
edirsen:
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
Bundan sonra id=dragable demeyinle dragable(yeni paneli istediyin yone apara bilirsen) duzeldirsen , bunu jquery
avtomatik edir.
<div id="draggable" class="ui-widget-content">
  <p>Drag me around</p>
</div>
Sortable- itemlerin surusdurub asagi yuxari yerini deyisdirirsen.Progresbar var isin nece faizin etmisen onu kanal
seklinde gosterir.
Burda $ ile hazir funksiya duzeldibler yeni adini $ qoyublar:
<script>
  $( function() {
    $( "#progressbar" ).progressbar({
      value: 37
    });
  } );
  </script>
# ile deyilir basa dusur ki id-ye muraciet etmek isteyirsen. Eger noqte olsaydi class basa duseceydi.Ve deyeri 37 olsun
yeni dizaynla 100-den 37 faiz gosterir.
Jquery-de deyil yalniz umumiyyetle javascriptde bezekli morterize acilib baglanirsa bu artig obyektdir.Burda da
progresbar funksiyasi cagirilib ve iceriye obyekt verilib.Obyketde de value deye field var onun deyerine 37 di
verilib.Jquery azadlig verir ki funksiyani istediyin vaxt cagira bilesen. Bu artig kohne texnologiyadir.
Ferqli bir sey deyil sadece javascriptdeki adi hazir funksiyadir.

Proyektde olan kodlar:

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

StudentFormDto:

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

TeachermanagementApplication:

@SpringBootApplication
public class TeachermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachermanagementApplication.class, args);
	}

}


Index.css:

#main-panel{
            width: 85%;
            margin: 0 auto;
            margin-top: 50px;
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

Index.js:

function fillSelectedItemForUpdate(id, name, surname, age, scholarship){
    document.getElementById("idUpdate").value=id;
    document.getElementById("nameUpdate").value=name;
    document.getElementById("surnameUpdate").value=surname;
    document.getElementById("ageUpdate").value=age;
    document.getElementById("scholarshipUpdate").value=scholarship;
}
function fillSelectedItemForDelete(id){
    document.getElementById("idDelete").value=id;
}

Students/Index.html:

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
          crossorigin="anonymous">
    <link href="/css/index.css" rel="stylesheet">
    <script src="/js/index.js"></script>
</head>
<body>
<div id="main-panel">
    <form method="GET" action="/students" class="row g-3 needs-validation">
       <div class="col-md-3">
            <label>name</label>
            <input type="text" name="name" class="form-control"/>
       </div>

        <div class="col-md-3">
            <label>surname</label>
            <input type="text" name="surname" class="form-control"/>
        </div>

        <div class="col-md-3">
            <label>age</label>
            <input type="text" name="age" class="form-control"/>
        </div>

        <div class="col-md-3">
            <label>scholarship</label>
            <input type="text" name="scholarship" class="form-control"/>
        </div>
        <div class="col-md-12">
            <button type="submit" class="btn btn-primary">Search</button>
            <button type="button" class="btn btn-primary" name="action" value="add" data-bs-toggle="modal"
                    data-bs-target="#panelAdd">Add</button>
       </div>
    </form>
    <table class="table table-striped">
        >
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
                                class="btn btn-danger"
                                data-bs-toggle="modal"
                                data-bs-target="#panelDelete"
                                onclick="fillSelectedItemForDelete(this.getAttribute('st-id'))"
                        >Delete</button>
                        <button type="button"
                                class="btn btn-secondary"
                                data-bs-toggle="modal"
                                data-bs-target="#panelUpdate"
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


<form method="POST" action="/students/add" >
    <div class="modal" tabindex="-1" id="panelAdd">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div>
                        <label>name:</label>
                        <input type="text" name="name" class="form-control"/>
                    </div>

                    <div>
                        <label>surname:</label>
                        <input type="text" name="surname" class="form-control"/>
                    </div>

                    <div>
                        <label>age:</label>
                        <input type="text" name="age" class="form-control"/>
                    </div>

                    <div>
                        <label>scholarship:</label>
                        <input type="text" name="scholarship" class="form-control"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn" >Add</button>
                    <button type="button" class="btn" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</form>

<form method="POST" action="/students/update" >
    <div class="modal" tabindex="-1" id="panelUpdate">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                        <input type="hidden" name="id" id="idUpdate"/>
                        <div>
                            <label>name:</label>
                            <input type="text" name="name" id="nameUpdate" class="form-control"/>
                        </div>

                        <div>
                            <label>surname:</label>
                            <input type="text" name="surname" id="surnameUpdate" class="form-control"/>
                        </div>

                        <div>
                            <label>age:</label>
                            <input type="text" name="age" id="ageUpdate" class="form-control"/>
                        </div>

                        <div>
                    <label>scholarship:</label>
                    <input type="text" name="scholarship" id="scholarshipUpdate" class="form-control"/>
                </div>
                </div>
                <div class="modal-footer">
                    <button class="btn">Update</button>
                    <button type="button" class="btn" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</form>

<form method="POST" action="/students/delete">
    <div class="modal" tabindex="-1" id="panelDelete">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Delete</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Are you sure to delete?
                    <input type="hidden" name="id" id="idDelete"/>
                </div>
                <div class="modal-footer">
                    <button class="btn">Delete</button>
                    <button type="button" class="btn" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>

Index.html:

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

build.gradle:

plugins {
	id 'org.springframework.boot' version '2.4.2'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
}

group = 'az.charming'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	implementation 'az.charming:charming_teachermanagementdb:1.0-SNAPSHOT'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
	useJUnitPlatform()
}

 */

