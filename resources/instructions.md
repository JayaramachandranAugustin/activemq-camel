net stop winnat
net start winnat

docker build -t activemq .

docker run -p 61616:61616/tcp -p 8161:8161/tcp activemq

change from value ="127.0.0.1" to "0.0.0.0" in conf/jetty.xml
    <bean id="jettyPort" class="org.apache.activemq.web.WebConsolePort" init-method="start">
             <!-- the default port number for the web console -->
        <property name="host" value="0.0.0.0"/>
        <property name="port" value="8161"/>
    </bean>