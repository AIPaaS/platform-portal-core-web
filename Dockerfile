FROM java:8-jre

ENV PAAS_HOME /usr/local/paas-wdep-0.0.1-SNAPSHOT
ENV PATH $PAAS_HOME/bin:$PATH
RUN mkdir -p "$PAAS_HOME"
WORKDIR $PAAS_HOME
ADD paas-wdep-0.0.1-SNAPSHOT-deploy.tar /usr/local

RUN chmod u+x $PAAS_HOME/bin/docker_start.sh

ENTRYPOINT ["/usr/local/paas-wdep-0.0.1-SNAPSHOT/bin/start.sh","run"]