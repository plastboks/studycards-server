<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE xml-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.xml.org/dtd/xml-configuration-3.0.dtd">

<xml-configuration>
    <session-factory>
        <!-- Database connection settings -->
        <property name="connection.driver_class">org.postgresql.Driver</property>
        <property name="connection.url">jdbc:postgresql://localhost:5432/studycards</property>
        <property name="connection.username">postgres</property>
        <property name="connection.password">example</property>
        <property name="transaction.factory_class">org.xml.transaction.JDBCTransactionFactory</property>

        <!-- SQL dialect - generate SQL for a particular database -->
        <property name="dialect">org.xml.dialect.PostgreSQLDialect</property>

        <!-- Echo all executed SQL statements -->
        <property name="show_sql">true</property>

        <!-- Enable Hibernate's automatic session context management -->
        <property name="current_session_context_class">thread</property>

        <!-- Auto create or update tables -->
        <property name="hbm2ddl.auto">update</property>

        <!-- Mapping resource configuration files -->
        <mapping class="net.plastboks.studycards.model.User"/>
        <mapping class="net.plastboks.studycards.model.ApiKey"/>

    </session-factory>
</xml-configuration>
