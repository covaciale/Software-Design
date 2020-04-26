# Proiect Proiectare Software

În acest proiect voi surprinde o aplicație web pentru înscrierea persoanelor la cursuri de dans latino. Vor exista mai multe clase de dans unde se pot face înscrieri, la diferiți instructori, care îi pot anunța prin aplicație ulterioare modificări de program sau activități pe lângă cursurile săptamânale.

# Versiunea actuală
Momentan, în aplicație se pot adăuga useri, care reprezintă toate persoanele înscrise la cursurile de dans. Pe lăngă nume, prenume și vârstă, este important și sexul pentru diferitele workshopuri de styling. Ca și administrator, se vor putea extrage liste cu toți participanții, doar fetele, respectiv baieții, sau dupa un indice unic.

![UML](E:\Facultate\Proiectare Software\demo\UML.png)

Până la realizarea interfeței GUI se folosește Postman unde sunt apelate funcțiile pentru vizualizarea tuturor din baza de date, vizualizarea unui user după id și adăugarea unui user.Primele două sunt de tipul GET, iar ultima POST.

    @GetMapping("/allList") // localhost:8080/allList
    public User findAll() {
    }

    @GetMapping("/findById") // localhost:8080/findById
    public User findById() {
    }

    @PostMapping("/insertItem") // localhost:8080/insertItem
    public void insertItem(User item) {
    }

# Implementare
Prima clasă prezentata este cea care reprezintă obiectele din baza de date, USER. Fiecare user are un id unic, prenume, nume, vârstă și sex. Pentru a construi liste folosind baza de date este nevoie de constructori, unul gol, al doilea folosind atributele, si gettere si settere pentru fiecare atribut.

O clasa la fel de importantă este ConnectionFactory unde se face conexiunea cu baza de date.

-static Connection getConnection()
-static void close(Connection c)
-static void close(Statement s)
-static void close(ResultSet r)
    
AbstractDAO este clasa pentru implementarea metodelor folosite la operațiile cu baza de date. Această clasa cuprinde: metodele pentru crearea stringurilor pentru query-urile din baza de date, metodele de find, si metoda pentru a crea obiecte de tipul User folosind obiectul obținut din baza de date.

  -String createSelectQuery(String field)
  -String createSelectAll()
  -String createInsertQuery(String field)
  -List<T> findAll()
  -List<T> findByGender(String gender)
  -T findById(int id)
  -T add(T user)
  -List<T> createObjects
  
  
# Tehnici folosite
Design Pattern-ul Observer definește o relație de dependență 1 la n între obiecte astfel încât când un obiect își schimbă starea, toți dependenții lui sunt notificați și actualizați automat. Folosirea acestui pattern implică existența unui obiect cu rolul de subiect, care are asociată o listă de obiecte dependente, cu rolul de observatori, pe care le apelează automat de fiecare dată când se întâmplă o acțiune.
Practic în toate aceste situații clasele Observer observă modificările/acțiunile clasei Subject. Observarea se implementează prin notificări inițiate din metodele clasei Subject.

In cazul proiectului prezentat, design-ul Observer a fost implementat in urmatoarea situatie: daca unul dintre antrenori modifica data/ora cursului se transmite un mesaj, dat tot de catre antrenor, pentru toate persoanele inscrise la cursul respectiv.


    @Override
    public void update(Observable o, Object arg) {
        Pair<Date, Date> dates = (Pair<Date, Date>)arg; //the old date and the new date
        this.coursesDates.remove(dates.getKey());
        this.coursesDates.add(dates.getValue());
    }
    
        public void setDate(Date date) {
        Pair<Date, Date> dates = new Pair<>(this.date, date);
        setChanged();
        notifyObservers(dates);
        this.date = date;
    }
    
Patternurile de tip Factory sunt folosite pentru obiecte care generează instanțe de clase înrudite (implementează aceeași interfață, moștenesc aceeași clasă abstractă). Acestea sunt utilizate atunci când dorim să izolăm obiectul care are nevoie de o instanță de un anumit tip, de creearea efectivă acesteia. În plus clasa care va folosi instanța nici nu are nevoie să specifice exact subclasa obiectului ce urmează a fi creat, deci nu trebuie să cunoască toate implementările acelui tip, ci doar ce caracteristici trebuie să aibă obiectul creat. Din acest motiv, Factory face parte din categoria Creational Patterns, deoarece oferă o soluție legată de creearea obiectelor.

    public class UserFactory {
    private DancesDAO dancesDAO = new DancesDAO();

    public User createUser(int idUser, String firstName, String secondName, int age, String gender, String dance){
        if (idUser > 0 && firstName != null && secondName != null && age > 14 &&
                (gender.equals("F") || gender.equals("M"))){
            if (dancesDAO.findByName(dance).size() != 0){
                return new User(idUser, firstName, secondName, age, gender, dance);
            }
            return null;
        }
        return null;
    }
}

  
# Metode de testare și verificare
Pentru testare am facut 2 unit teste, unul pentru findById și unul pentru findByGender pentru datele din baza de date actuală. Pentru modificări ale bazei de date se poate modifica codul, în loc de userul creat prin constructor, se poate folosi ”when(apel functie).thenReturn(lista/user așteptat)” după care se parcurg aproximativ pașii din metoda pe care o verificăm, creăm baza de date, convertim obiectul/obiectele obținute, pe urmă le verificăm.
 
# Dependințe utilizate
 - Springboot
 
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	
- JUnit

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13</version>
			<scope>test</scope>
		</dependency>
 
 - Mockito
 
 		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-all</artifactId>
			<version>1.9.5</version>
			<scope>test</scope>
		</dependency>
		
- MySQL

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		
