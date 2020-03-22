# Proiect Proiectare Software

În acest proiect voi surprinde o aplicație web pentru înscrierea persoanelor la cursuri de dans latino. Vor exista mai multe clase de dans unde se pot face înscrieri, la diferiți instructori, care îi pot anunța prin aplicație ulterioare modificări de program sau activități pe lângă cursurile săptamânale.

# Versiunea actuală
Momentan, în aplicație se pot adăuga useri, care reprezintă toate persoanele înscrise la cursurile de dans. Pe lăngă nume, prenume și vârstă, este important și sexul pentru diferitele workshopuri de styling. Ca și administrator, se vor putea extrage liste cu toți participanții, doar fetele, respectiv baieții, sau dupa un indice unic.

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
		
