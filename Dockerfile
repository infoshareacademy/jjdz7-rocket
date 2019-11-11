FROM jboss/wildfly:18.0.0.Final

ADD web/target/grajdolexweb.war /opt/jboss/wildfly/standalone/deployments/grajdolexweb.war