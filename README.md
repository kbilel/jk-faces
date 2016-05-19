# JK-Faces (The new face of Java web applications)
No suffering from JSF projects any more, create new production-ready web and database driven application using JSF with zero-configurations , and have the freedom to replace your JSF 3rd-party components at anytime without changing any single line of code.

#Usage
1- Create new maven  project with `war` as packaging type.  
2- Add JK-Faces dependency to your `pom.xml` inside the `<dependencies>` section

		<dependency>
			<groupId>com.jalalkiswani</groupId>
			<artifactId>jk-faces</artifactId>
			<version>0.0.5</version>
		</dependency>
    
3- Be sure to set the minimum JDK level in your pom file to 1.7 and tell maven to ignore `web.xml` by adding the following sections inside `build-->plugins` section :

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.3</version>
				<configuration>
					<!-- http://maven.apache.org/plugins/maven-compiler-plugin/ -->
					<source>1.7</source>
					<target>1.7</target>
				</configuration>
			</plugin>

			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>2.6</version>
				<configuration>
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
			</plugin>
		</plugins>
	</build>

**And thats is it... , proceed to next section to test your installation.	
### Important for eclipse users:   
After you add the above section for Java version , it is important it refresh maven projects by `right click on the project-->Maven-->Update Project`
       

#Test the installation:
Create new page named `test.xhtml` inside `src/main/webapp`

## add the following lines to your page:
### (Traditional Way)
	<html xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://java.sun.com/jsf/html" xmlns:jk="http://jalalkiswani.com/jsf" xmlns:p="http://primefaces.org/ui">
	<h:head>
		<title>JK-Faces First Test</title>
	</h:head>
	<h:body>
		<!-- Check JSF Installation -->
		<h:outputText value="Hello from JSF Html" />
		<!--  Check JK Components -->
		<jk:jsfInfo/>
		<!-- Check Primefaces components -->
		<p:editor/>
	</h:body>
	</html>
	
**Output**:  
![alt tag](https://github.com/kiswanij/jk-faces/blob/master/design/example1.PNG)

Try the above using your favorite web/application server (tested on `tomcat7`, `tomcat8` and `wildfly 9`)   

###(JK-Faces way)  
also , you can use JK-Faces way for the same above example as follows :   

	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>JK-Faces First Test</title>
	</head>
	<body>
		<outputText value="Hello from JSF2"/>
		<jsfInfo />
		<editor/>
	</body>
	</html>

Note that, no namespace deification is required and no prefix is required
##Note : 
you should be able to access your pages directly without faces/ path , for example , in the above test example, you
can access your page using the following url http://localhost:8080/your-app-name/<del>faces</del>/test.xhtml with or without the `faces`

##With JK-Faces , you have the following ready and configured:
1. Configured all the required dependencies
  1. JSF API and Implementation
  2. PrimeFaces  	
  3. PrimeFaces Extension
  4. JK-DB database API
  5. Javax-EL API
  6. Owasp CSRF 
  7. Along with my jk-web dependences which includes many other utilities including export your jsf , jsp and html pages to pdf using flying-saucer-pdf
  8. (Soon) Omnifaces
  9. (Soon) Weld 
  10. Jasper Reports
 	
2. Configure all the required filters and servlets: 
  1. Faces-Servlets
  2. Encoding-sevlets 
 
3. Configure the welcome pages to :
  1. index.xhtml
  2. index.jsp
  3. home.xhtml
  4. home.jsp

4. add the required configurations for JSF including:
  1. Fix ViewExpiredException issue with enableRestoreView11Compatibility to fix 
  2. Set  timezone to system timezone
  3. Map JSF xhtml pages on without faces/prefix to protect againest code direct access.
 
5. Configure Primefaces to use awsome-fonts by default

#The unique features of JK-Faces:
1- **Zero configurations** for production ready JSF environment.  
2- **No need for any server-side name-space** definition anymore in your pages(NO , it is not Facelets), check this exmaple:

	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>JK-Faces First Test</title>
	</head>
	<body>
		<editor/>
	</body>
	</html>
This will render primefaces editor components,and of-course no prefix for tag any more.
  
3- **Change your components and components provider at any time without changing single-line of code**  using JK-Faces auto-mapping or manual mapping using `jk-faces-config.xml`  
4- **Web-designer friendly tags**, just add some styles and go (again ,No , it is not Facelets)  
5- **Transparent** relative path and url management , use `<img src="/images/test.jpg">` and it will be automatically updated to include the  context path for the url.  (this includes , `<link>` , `<script>` , `<a>`) tags.   
6- Support traditional JSF and modern JK-Faces front-end technology    
7- Encoding is defaulted to utf-8 on all web/application servers  
8- Access to jsf pages with or without `faces` prefix

## Full Database driven example using JK-Faces and JK-DB  
[JK-DB : database development with Java has never been easier!](https://github.com/kiswanij/jk-db)  
##### Maven `pom.xml`
	<project xmlns="http://maven.apache.org/POM/4.0.0"  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.jk.test</groupId>
	<artifactId>jk-faces-test</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	
	<dependencies>
		<dependency>
			<groupId>com.jalalkiswani</groupId>
			<artifactId>jk-faces</artifactId>
			<version>0.0.5</version>
		</dependency>
	</dependencies>
	
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.3</version>
				<configuration>
					<!-- http://maven.apache.org/plugins/maven-compiler-plugin/ -->
					<source>1.7</source>
					<target>1.7</target>
				</configuration>
			</plugin>
			
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<configuration>
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>

##### JSF test page `src/main/webapp/test.xhtml`
###### (Traditional way)
	<html xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://java.sun.com/jsf/html" xmlns:jk="http://jalalkiswani.com/jsf" xmlns:p="http://primefaces.org/ui">
	<h:head>
		<title>JK-Faces test with JK-DB</title>
	</h:head>
	<h:body>
		<h:form>
			<p:panelGrid columns="1">
				<p:growl autoUpdate="true" />
				<p:inputText value="#{mb.id}" placeholder="Enter id here" />
				<p:inputText value="#{mb.name}" placeholder="Enter name" />
				<p:inputText value="#{mb.salary}" placeholder="Enter salary" />
				<p:commandButton value="Add" action="#{mb.add}" ajax="false" />
			</p:panelGrid>
		</h:form>
	</h:body>
	</html>

#####(JK-Faces way)
	<html xmlns="http://www.w3.org/1999/xhtml" >
	<head >
		<title>JK-Faces</title>
	</head>
	<body >
		<form>
			<panelGrid columns="1">
				<growl autoUpdate="true" />
				<input value="#{mb.id}" placeholder="Enter id here" required="true"/>
				<input value="#{mb.name}" placeholder="Enter name" required="true"/>
				<input value="#{mb.salary}" placeholder="Enter salary" required="true"/>
				<input type="submit" value="Add" action="#{mb.add}" ajax="false" />
			</panelGrid>
		</form>
	</body>
	</html>

This will produce the following output :
![alt tag](https://github.com/kiswanij/jk-faces/blob/master/design/example2.PNG)

**Important:** don't click add yet , you need to write the below manage bean :)

##### JSF Managed bean `src/main/java/test/MBEmployee`
	package com.jk.example.faces;
	
	import javax.faces.bean.ManagedBean;
	
	import com.jk.faces.mb.JKPlainDataAccessManagedBean;
	
	@ManagedBean(name = "mb")
	public class MBEmployee extends JKPlainDataAccessManagedBean {
		Integer id;
		String name;
		Double salary;
	
		public String add() {
			execute("INSERT INTO employees (id,name,salary) VALUES (?,?,?)", id, name, salary);
			success("Added successfully");
			return null;
		}
	
		public Integer getId() {
			return id;
		}
	
		public void setId(Integer id) {
			this.id = id;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public Double getSalary() {
			return salary;
		}
	
		public void setSalary(Double salary) {
			this.salary = salary;
		}	
	}

##### JK-DB Config  `src/main/webapp/WEB-INF/jk-db.properties`
	db-driver-name=com.mysql.jdbc.Driver
	db-url=jdbc:mysql://localhost:3306/app
	db-user=root
	db-password=123456

**Important: ** The above examples assumes the existsnce of `employees` with `id,name,salary` as fields , please refer to JK-DB project to get the script for the table.
 
#UML class diagram
This section for  (Ed ,Jacob ,Cagatay and BalusC)  
![alt tag](https://github.com/kiswanij/jk-faces/blob/master/design/uml.PNG)

Note: sorry Jacob!, I have been enforced to use reflection to access some of your private stuff.

# JK-Faces-mapping  
The mapping between the tags in the pages and the actual tags replaces at runtime is done in tow-ways:  
1- Automatic : the framework will look for the matching tag automtcaiily.  
2- By configuration : Look for the mapping defined in `/META-INF/jk-faces-config.xml`   

## Example of jk-faces-config.xml file
	<jk-faces>
		<name-spaces>
			<namespace>
				<prefix>xmlns:p</prefix>
				<url>http://primefaces.org/ui</url>
			</namespace>
			<namespace>
				<prefix>xmlns:h</prefix>
				<url>http://java.sun.com/jsf/html</url>
			</namespace>
			<namespace>
				<prefix>xmlns:f</prefix>
				<url>http://java.sun.com/jsf/core</url>
			</namespace>
			<namespace>
				<prefix>xmlns:jk</prefix>
				<url>http://jalalkiswani.com/jsf</url>
			</namespace>
			<namespace>
				<prefix>xmlns:ui</prefix>
				<url>http://java.sun.com/jsf/facelets</url>
			</namespace>
			<namespace>
				<prefix>xmlns:fn</prefix>
				<url>http://java.sun.com/jsp/jstl/functions</url>
			</namespace>
			<namespace>
				<prefix>xmlns:c</prefix>
				<url>http://java.sun.com/jsp/jstl/core</url>
			</namespace>
		</name-spaces>
		<tags-mapping>
			<tag>
				<source-tag>input</source-tag>
				<attribute-name>type</attribute-name>
				<attribute-value>text</attribute-value>
				<target-tag>p:inputText</target-tag>
			</tag>
			<tag>
				<source-tag>input</source-tag>
				<attribute-name>type</attribute-name>
				<attribute-value>submit</attribute-value>
				<target-tag>p:commandButton</target-tag>
			</tag>
			<tag>
				<source-tag>input</source-tag>
				<target-tag>p:inputText</target-tag>
			</tag>
		</tags-mapping>
	</jk-faces>
	
**Enjoy!**  
Jalal Kiswani  
http://www.jalalkiswani.com
