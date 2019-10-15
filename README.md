# ELK-POC
A POC for sending log to elk

Set up of ELK stack
follow the instruction here:

https://github.com/deviantony/docker-elk

Download with git


$ git clone https://github.com/deviantony/docker-elk.git
$ cd docker-elk
Then change the configu files according with the diff here...

diff --git a/docker-compose.yml b/docker-compose.yml
index 6936be0..19c4023 100644
--- a/docker-compose.yml
+++ b/docker-compose.yml
@@ -38,7 +38,7 @@ services:
         target: /usr/share/logstash/pipeline
         read_only: true
     ports:
-      - "5000:5000"
+      - "12201:12201/udp"
       - "9600:9600"
     environment:
       LS_JAVA_OPTS: "-Xmx256m -Xms256m"
diff --git a/logstash/pipeline/logstash.conf b/logstash/pipeline/logstash.conf
index 14c76f8..43997b3 100644
--- a/logstash/pipeline/logstash.conf
+++ b/logstash/pipeline/logstash.conf
@@ -1,9 +1,6 @@
 input {
-       tcp {
-               port => 5000
-       }
+  gelf {}
 }
-
 ## Add your filters / logstash plugins configuration here

 output {
@@ -12,4 +9,5 @@ output {
                user => "elastic"
                password => "changeme"
        }
+        stdout {}
 }
 
 Finally:
 
 $ docker-compose up
 
 
run the project directly from Eclipse or IntelliJ

Access:

localhost:9090/log/{trace|debug|info|warn|error|fatal}/{message} to generate logs

access kibana localhost:5601 (elastic/changeme) to index and view the data
