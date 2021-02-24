/* devtools qosmag- settings- build, execution..- complier-build project automaticlly secib apply.
sonra registry yazib girdik orda da -complier automatic when app running secib close.
localhost:8080 girsek cssler goreceyik ki oz eksini tapmir. index.css fayli html icine yazmisig buda cerez
app gorur.inpector edende network baxsag localhost gedir 8080 ve ordan response gelir yeni html. sonra elements
baxirig bizden yeniden sorgu gedir 8080 ki mene index.css ver bunu da app verir. appde deyirki men bunu
tanimiram bununcun index.css static folderinde olmalidi.kecen defe ise gormeyi bununla baglidir- ki
biz onda run etmirdik html.de browser daxil olurdug onda intellij arxada bir server qaldirir ve bu spring
app kimi islemir ayri bir app kimi isleyir.ve bunun qaydalarin intellij verir ve bu qaydalarda css -in
static de olmalidi kimi qaydasi yoxdur.eksine oldugun folderde olmalidi qaydasi var. ve burda da baxsag
request gedir networkde preserve log(itkiye hec bir log getmir) isarelesek gorerik.bu browser bize rahatcilig
verir. indi css atirig statice.htmlde qosmag ucun thymeleaf import css edirik- html-de link yerine stylesheet-den
sonra href elave edirik. <link rel="stylesheet" href="/css/index.css"> ve devtools qosula bilmeyib onuncun
edit conf.da on update, on frame xanasinda update classes and resources secirik ve devtools isleyir.indi search
falan ise salmag ucun yeni ad daxil edib yoxlayanda bununcun label, buttonlari salirig bura-
<form methods="POST" actions="/students"> - bu dizaynda deyisiklik etmir.
ve controllerde indexcontroller clasini copy edib studentcontroller adli clas acirig ve annotation
icine "students" yazirig ve return "students/index" edirik. hemcinin templates-de students paketi acib
index.html copy-sini bura atirig.destkop appinden build gradle.den students proyektini gotururuk dependecies yazirig
implementation 'az.charming:charming_teachermanagementdb:1.0-SNAPSHOT' ve repositories-de 	mavenLocal()
elave etdik.StudentControllerde -
@Controller
public class StudentController {

    private final StudentRepository studentRepository = new StudentRepository();

    @RequestMapping("students")
    public String index(Model model){
        model.addAttribute("list",studentRepository.getAll());
        return "students/index";
    }
}
ve student/index.html de tymeleaf sayti qosdug yeniden css oxumasi ucun.Tr-in birin sildik , for each-e saldiq
 <tr th:each="student: ${list}">
                <td th:text="${student.id}">1</td>
                <td th:text="${student.name}">Emin</td>
                <td th:text="${student.surname}">Zeynalov</td>
                <td th:text="${student.age}">28</td>
                <td th:text="${student.scholarship}">200</td>
 </tr>
 run etdik localhost:8080/students chrome girende datadaki melumatlar cixdi. Templates ozundeki html ise ana sehife
 kimi istifade edirik nece ki swingde hem student hemde teacher vardi. head ve yuxari hisse qalir body-ni bele edirik
 <body>
<div id="main-panel">
    <a href="/students" class="btn">Students</a>
    <a href="/teachers" class="btn">Teachers</a>
</div>
</body>
</html>

indexconroller(silirik, default olarag spring ozu qurur) lazim deyil,
index html-e controller olmadan aparir, spring templatesde html var
deye ozu bizim evezimizden indexcontroller qurur, students html-e ise student controller(olmalidi) aparir cunki folder
icindedi spring komek etmir.
/students yazanda gelib controllerde @RequestMapping("students") bura dusur ve getall ile studenleri modele add edir ve
return edir stundetsdeki html faylini, nece return edir?- list ile qaytarir sonra html de capa verirsen.
model(studententity) view(student html) controller(student controller) mvc- web design pattern. Controller sorgu alir,
bazaya(model-e) muraciet edir ve view-a gonderir.
action="/students" - duymeye basanda hara sorgu getsin, @RequestMapping("students") bura gelir .
Methodlarin novu var, search-e(t) basanda students url-ne post novunde sorgu gonderir.
@RequestMapping("students")- default olarag get sorgusudur, uzun yazilisi value, requestmethod.get seklindedir.
Axtarisda errorun(method not allowed status =405) sebebi-index metodu postu desteklemir, destek ucun method={get, post}
Search edib, networkde  students-e daxil olsaq, headers de request method post gorerik yeni post gonderilib,
servere gonderdiyimiz -form data(search neyi vermisen orda yazilir) - applicationa gonderdiyimiz budur ve bu tutulur,
axtarisa verilir, netice ekrana cixarilir.
Neticeni ekrana vermek ucun teachermanagement-de bir dto folderi acirig ve
icinde StudentFromDto calsi acdig(data transfer object) - qarsidan gelen melumatlar
bunun icinde yerlesir.Bu da dizayn patterndi yeni birinden digerine oturulen data varsa
orta da istifade olunur.Burda private name, surname, scholarship falan deyisenler yazirig ve getter, setteri acirig.
Bunun yerine StudentEntity istifade ede bilerik cunki icindekiler eynidi sadece gelecekde ele bir sey istifade ola biler
ki bu entity-de olmasin. Sehifeden gele bilecek her seyi ozunde ehate etsin.
Index metodunda liste repository-nin findlist metodunu doldurub elave edirik.Parametrinde StudentFormDto obyektini elave
edirik(@ModelAttribute annotation-i onunde yazarag).
Index.html StudentForm obyektini dolduracag ve index metoduna gonderecek.
form-a th:object="${studentForm}" elave etdik, input-lara th:field="*{name}" (surname, age, heresine uyugun olarag)
yazdig. Th field obyektin icinde deyisenler hara baxir yeni melumati yazib search edende hemen meulmat studentForm-un
hansi xanasina oturacag.studentForm-u desteklemek ucun index metodunde @ModelAttribute("studentForm") yazirig.

Belelikle search butonu isledi.Ancag indi add, delete butonu da eyni form icindedi deye hansini bassan students-e sorgu
gedecek.Bununcun add-i butonunu formdan kenara cixardirig.
StudentController-de private String action(getter,setter) deyiseni acdig.
Delete-i de formdan cixardig, cunki table-in yaninda olacag.
th object-i , th fieldleri silirik metodu get edirik, bayag etdiyimiz searchi ele bil yeniden yazirig cunki bayagki
usulla butun butonlar bir formdaydi deye o cur yazmisdig ancag indi butonlari ayirmag qerarina geldik ve o usul
elverisli olmadigi ucun bele yazirig.
Indi search edende axtaris verilen url-de xanaya oturmus sekilde olur buda get sorgusuna goredir, bayag post-la sorgu
gedirdi, bu zaman obyekt doldurulur ve oturulur.Post-la olmasi daha tehlukesizdir bunu daha cox bank islerinde, hesab
falan islerinde istifade edirler, indi ise get sorgusu olmaginin yaxsi meselen birine link gonderirsen ve daha deqiq
olur istenilen yere daxil olmag ucun.Bayag headers-de form data variydi indi onun yerine query string parameters var.
Index metoduna @requestparam yazdig ve buna da(requeired=false) yazirig eks halda sehifeye muraciet edende  deyecek ki
mene name, suraname falan gondermemisen. ve add ve search butonuna name="action"  value="search yazdig, add-e uygun
olarag add yazdig.
form icinde search butonuna basanda inputdaki melumatlar students url-ne gonderilir.
Add-i qiraga cixardig ki bu butona basanda students-e sorgu getmesin.
students url-ne gelen melumatlar index metodunda reqeustparam sayesinde uygun deyisenlere oturur.Sonra axtarisa verdik,
liste doldurub tezeden index.html ekrana verdik.Belelikle axtardigimiz sexsi tapib, ekranda gosterdik.
Model attribute- spring framework modeli html-de gore bilir onuncun ne gondermek isteyende model tipli bir obyekt
avtomatik qurulur(program ise dusende spring terefinden) ve bununla gonderilir.
Biri var kitabxana , biri var framework. Spring bir frameworkdur cunki bizim evezimizden ozu avtomatik nelerse edir.Yeni
bir kitabxana qurmusansa ve bu avtomatik bir is gorurse bu artig kitabxana deyil, framework sayilir.
@RequestMapping ona gore yazilir ki students url-ne muraciet edende index metodu cagirilacag.Eslinde controller modeli
tymeleafe oturur ve tymeleaf goturur listi for
each-in icinde hamisini doldurur(id, name falan), html-i hazirlayir ve browsere deyir hazirdir gotur.html-de kodu
(inputlari falan) bele yazmagimiz searc-e basanda browser-e deyirki meselen bu inputa yazilan melumati name, surname
ve s. adi altinda mene gonderersen.Melumati bizim controllere browser gonderir, html deyil.Html sadece bir komandadir.
Searche basmagimiz browserin get sorgusu qurmagidir bunu url-i elimizle yazsag eyni seydir.Obyekt qebul edende postla,
dene-dene fieldler qebul edende get ile yazirig.
Index metodunda return "students/index" yeni ki list modelini bu html sehifesine gonder.
Add ucun - form copy edirik div-den cole yazirig. Buttonlardaki name, value ehtiyac qalmadi ,silirik cunki o yolu
isitfade etmedik.Add ucun olan formun metodunu Post edirik.Studentcontrollerde add metodu acirig.
index metodunda post sorgusunu silib sadece get saxlayirig.
Dto-da toEntity metodu acirig burda StudentEntity doldurub return edirik.Ve bunu
add metodunda studentRepository.insert-e gonderirik ve return "redirect:/students"
edirik.Browserde goreceyik ki add ucun bir panel acildi name, surname falan artirirsan burda. Bunu seliqeye salmag ucun
form-da style="margin 0 auto;
width: 500px; margin-top:50px" yazarag istenilen dizayn veririk.Ve inputlarin sonuna <br/> yazirig . Br enter demekdir
ele bilki sout-da ln.
Browserde sag click inspect edib formlara baxsag bize sehifedeki yerleri gosterecek.
return-de redirect demekle deyirik ki bu url-e get.ve url-e getdiyi ucun index daxil olur orda findlist-de tapir liste
doldurur ve sehifeni gosterir return "students/index" ile.
Dto -da action deyisenini ve getter, setter-ni de silirik cunki daha butun butonlar bir yerde olmasi lazim olmadi.add
metodunda StudentFromDto ehtiyac yoxdu indiki halda StudentEntity-de yaza bilerik ve gelen entity-ni de birbasa insert-e
yaza bilerik. cunki add olan name falan hamisi entity-de var. Formdto o zaman lazim olar ki burda elave Teacher olardi
ve s. Ve biz umumi gelen melumatlari studententity ile, teacherentity ile ayirardig uygun yerlere.
Delete elave etmek ucun-tr-ler arasinda bir td acirig bu td-nin icinde form acirig ve bu formlarin icinde input, button
yazirig.form yene metod -post, action-students/delete yazirig.input type = hidden edirik, button-Delete yazirig.
Delete-e basanda student-in postuna gedecek hidden parametri olarag id adi altinda student-in id-si.
controllerde bir dene delete metodu acirig. id ni goturmek ucun requestparam deyirik.
ve bu id-ni otururuk bura- studentRepository.delete ve yene return redirect edirik.
delete metodunda value= "students/delete" yazirig ve bunu add ucunde edirik hem metodunda hemde html-de.
Normalda input bir text olarag gorunur ancag burda hidden deyilib deye ele gorsenmir sadece request olarag
student/delete -e gedir.Belelikle her  setrin onunde delete var ancag onun yuxarisi bozdur onuncun tr icinde th elave
edirik(adini contorls yazdig).Td-leri for qoydugu ucun her setrin onunde delete oturur.

Biz form-dan kenara cixaridigmiz add -i yeniden iceri atirig onda button-da
type="button" yazirig normalda type yazmayanda default olarag submit olur.submit odurki duymeye basanda request gonder.
Ancag button olanda form-a request getmir ve bize javascript-de lazim olacag yeni add vuranda papap acilsin ancag
iceri de onuncun yeniden saldig ki browser-e girende add searchin yaninda dursun asagi dusmesin.Form-da deletenin
asagisinda bir dene de update butonu acdig helelik bununda type-ni button etdik update basanda hecne olmasin sadece
popop acilsin.asagdaki add-i seliqeye salmag ucun- css-index.css-de class acirig. Ve bu clasi yazirig form-da add-e ,
style silib yerine ve inputlari da float right edirik.Burda her bir label, inputu div-e atirig (div-panel). Div-de ozunu
enterle asagi atir.Br-lari sildik.Sehifede addin xanalarinin her deyisenin onunde durmasi ucun css.de .form-panel div
clasi acib heigth-ni nizamladig.input float right olanda sag cekilir ve label ile elaqe itir onuncun labeller ekranda
alt allta bitisik gelirdi.onuncun biz her label inputa div verib ve bu dive de height verdik.

            .form-panel {
                margin: 0 auto;
                margin-top: 50px;
                width: 260px;
            }

            .form-panel input {
                float: right;
            }

            .form-panel div {
                height: 30px;
            }

controllerde yazdigimiz return redirect students bu html deyil urldir.
requestparam getden geleni de , postdan geleni de goture bilir.get-i demisdik, son olarag yazdigimiz delete metodunda da
 post-a misal olarag gorduk.

son olarag  yazilan kodlar bunlardir:
students/index html:
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/index.css">

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
        <button type="button" class="btn" name="action" value="add">Add</button>
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
                    <form method="POST" action="/student/delete">
                        <input type="hidden" name="id" th:value="${student.id}"/>
                        <button>Delete</button>
                        <button type="button">Update</button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</div>
<form method="POST" action="/students/add" class="form-panel">
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
</form>
</body>
</html>

index/html:

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

studentcontroller:

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

    @RequestMapping(value = "students/delete", method= {RequestMethod.POST})
    public String delete(@RequestParam(required = false) Integer id){
        studentRepository.delete(id);
        return "redirect:/students";
    }
}

formdto:

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
                margin: 0 auto;
                margin-top: 50px;
                width: 260px;
            }

            .form-panel input {
                float: right;
            }

            .form-panel div {
                height: 30px;
            }
teachermanagementapplication:

@SpringBootApplication
public class TeachermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachermanagementApplication.class, args);
	}

}

 */
