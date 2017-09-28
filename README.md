# hibernate-tutorial1
Hibernate tutorial 1 : JavaSE 1.8 + Hibernate5 + Maven4 + MySQL Basic configuration

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/nfriaa/hibernate-tutorial1/issues) [![Travis](https://img.shields.io/travis/rust-lang/rust.svg)](https://github.com/nfriaa/hibernate-tutorial1) [![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/nfriaa/hibernate-tutorial1/blob/master/LICENSE)

## Description
A sample code to configure a maven project and test connection to MySQL database using Hibernate ORM.

## 1. Create maven project and add dependencies
```
<!-- MySQL connector -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>6.0.6</version>
</dependency>

<!-- Hibernate -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.2.11.Final</version>
</dependency>
```
## 2. Create the hibernate config file 'hibernate.cfg.xml'
```

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
    <session-factory>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/persist_db</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">root</property>
    </session-factory>
</hibernate-configuration>
```

## 3. Create HibernateUtil.java 
Hibernate Utility class with a convenient method to get Session Factory

## 4. Create a main Application class
A class whith main method for testing all this... 


```
         __      _             
        / _|    (_)            
  _ __ | |_ _ __ _  __ _  __ _ 
 | '_ \|  _| '__| |/ _` |/ _` |
 | | | | | | |  | | (_| | (_| |
 |_| |_|_| |_|  |_|\__,_|\__,_|
``` 