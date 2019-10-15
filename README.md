# ELK-POC
A POC for sending log to elk

This is a rest service that will produce logs
sent to  elk stack

The log uses GELF format and are sent to logstash gelf input plugin

cd docker-elk

docker-compose up

to generate log message just run 

wget localhost:9090/log/{trace|debug|info|warn|error|fatal}/{message} 

access kibana localhost:5601 (elastic/changeme) to index and view the data
