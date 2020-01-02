FROM jboss/wildfly:18.0.0.Final
​
ADD web/target/grajdolexweb.war /opt/jboss/wildfly/standalone/deployments/grajdolexweb.war
​
RUN /opt/jboss/wildfly/bin/add-user.sh root grajdolex --silent
CMD ["echo Waiting 5 seconds"]
CMD ["sleep", "5"]
CMD ["echo Starting Wildfly"]
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]